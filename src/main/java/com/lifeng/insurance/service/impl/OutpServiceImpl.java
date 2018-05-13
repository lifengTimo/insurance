package com.lifeng.insurance.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.lifeng.insurance.dao.DiseaseGenderRepository;
import com.lifeng.insurance.dao.DiseaseRepository;
import com.lifeng.insurance.dao.DrugBodyLimitRepository;
import com.lifeng.insurance.dao.DrugDayRepository;
import com.lifeng.insurance.dao.DrugInsuranceTypeRepository;
import com.lifeng.insurance.dao.DrugRepository;
import com.lifeng.insurance.dao.OutpDetailRepository;
import com.lifeng.insurance.dao.OutpMasterRepository;
import com.lifeng.insurance.dao.PatientRepository;
import com.lifeng.insurance.dao.PublicDictRepository;
import com.lifeng.insurance.dao.SexLimitRepository;
import com.lifeng.insurance.model.Disease;
import com.lifeng.insurance.model.DiseaseGender;
import com.lifeng.insurance.model.Drug;
import com.lifeng.insurance.model.DrugBodyLimit;
import com.lifeng.insurance.model.DrugDay;
import com.lifeng.insurance.model.DrugInsuranceType;
import com.lifeng.insurance.model.OutpDetail;
import com.lifeng.insurance.model.OutpMaster;
import com.lifeng.insurance.model.Patient;
import com.lifeng.insurance.model.PublicDict;
import com.lifeng.insurance.model.SexLimit;
import com.lifeng.insurance.service.OutpService;
/**
 * 
* @ClassName: OutpServiceImpl 
* @Description: TODO(报销处理实现) 
* @author lifeng
* @date 2018年5月13日 下午4:21:33 
*
 */
@Service
public class OutpServiceImpl implements OutpService{

	/**
	 * 门诊报销主表Dao
	 */
	@Autowired
	private OutpMasterRepository masterDao;
	
	/**
	 * 门诊报销细节表Dao
	 */
	@Autowired
	private OutpDetailRepository detailDao;
	
	/**
	 * 病人信息dao
	 */
	@Autowired
	private PatientRepository patientDao;
	/**
	 * 药品信息Dao
	 */
	@Autowired
	private DrugRepository drugDao;
	
	/**
	 * 疾病信息Dao
	 */
	@Autowired
	private DiseaseRepository diseaseDao;
	
	/**
	 * 疾病性别限制信息Dao
	 */
	@Autowired
	private DiseaseGenderRepository diseaseGenderDao;
	
	
	/**
	 * 药品性别限制信息Dao
	 */
	@Autowired
	private SexLimitRepository drugSexDao;
	
	/**
	 * 药品年龄限制信息Dao
	 */
	@Autowired
	private DrugBodyLimitRepository drugBodyDao;
	
	/**
	 * 公共字典Dao
	 */
	@Autowired
	private PublicDictRepository dictDao;
	
	/**
	 * 药品天数限制Dao
	 */
	@Autowired
	private DrugDayRepository drugDayDao;
	
	/**
	 * 药品险种险种Dao
	 */
	@Autowired
	private DrugInsuranceTypeRepository drugTypeDao;
	
	@Override
	public String insertOutp(OutpMaster master) {
		List<OutpDetail> details=master.getDetails();
		//总额
		BigDecimal totalAmonut=new BigDecimal(0.00);
		//单项费用
		BigDecimal price;
		//总天数
		BigDecimal day;
		//计算总费用
		for(OutpDetail item:details) {
			price=item.getPrice();
			day=new BigDecimal(item.getDay());
			BigDecimal itemTotal = price.multiply(day);
			totalAmonut=totalAmonut.add(itemTotal);
			
		}
		master.setToalCost(totalAmonut);
		master=masterDao.save(master);
		details = detailDao.saveAll(details);
		//保存后进行秋后算账
		StringBuffer stringBuffer=new StringBuffer();
		//查询病人信息
		 Patient patient = patientDao.findById(master.getPatient().getId()).get(); 
		 //查询疾病信息
		 Disease disease = diseaseDao.findById(master.getDisease().getId()).get();
		 
		 
		 //监控疾病性别信息是否正确
		 stringBuffer.append(diseaseGenderMonitor(patient, disease));
		 Optional<Drug> options;
		 Drug drug;
		 //监控药品信息
		 for(OutpDetail item:details) {
			//药品性别限制信息
			 options=drugDao.findById(item.getDrug().getId());
			 //非空判断
			 if(!options.isPresent()) {
				 continue;
			 }
			 //获取药品信息
			 drug=options.get();
			 //药品性别限制信息
			 stringBuffer.append(drugSexMonitor(drug, patient));
			 //药品年龄限制信息
			 stringBuffer.append(drugBodyMonitor(drug,patient));
			 
			 //药品用药天数限制
			 stringBuffer.append(drugDayMonitor(drug, item.getDay()));
			 
			 //药品限制限制
			 //获取药品险种限制信息
			 PublicDict type = dictDao.getOne(item.getReimburseType().getId());
			 stringBuffer.append(drugInsuranceTypeMonitor(drug, type));
		 }
		
		return stringBuffer.toString();
	}
	/**
	 * 
	* @Title: diseaseGenderMonitor 
	* @Description: TODO(监控疾病性别信息是否正确) 
	* @param @param patient
	* @param @param disease
	* @param @return  参数说明 
	* @return String    返回类型 
	* @throws
	 */
	private String diseaseGenderMonitor(Patient patient, Disease disease) {
		//查询疾病性别限制信息
		DiseaseGender example=new DiseaseGender();
		example.setDisease(disease);
		Optional<DiseaseGender> option = diseaseGenderDao.findOne(Example.of(example));
		if(!option.isPresent()) {
			return "";
		}
		DiseaseGender gender = option.get();
		//获取病人的性别名称
		String patientSex=patient.getSex().getValueName();
		//获取疾病限制的性别名称
		String diseaseSex=gender.getGenderLimit().getValueName();
		//判断性别是否相等
		if(patientSex.equals(diseaseSex)) {
			return "";
		}
		return "本次交易有疾病方面问题："+disease.getDiseaseCode()+" "+disease.getDiseaseName()+"性别限制为"+diseaseSex+"性\n";
	}
	/**
	 * 
	* @Title: drugSexMonitor 
	* @Description: TODO(监控药品性别信息是否正确) 
	* @param @param drug
	* @param @param patient
	* @param @return  参数说明 
	* @return String    返回类型 
	* @throws
	 */
	private String drugSexMonitor(Drug drug,Patient patient) {
		SexLimit ex=new SexLimit();
		ex.setDrugCode(drug.getDrugCode());
		ex.setDrugName(drug.getDrugName());
		Optional<SexLimit> option = drugSexDao.findOne(Example.of(ex));
		if(!option.isPresent()) {
			return "";
		}
		SexLimit gender = option.get();
		//获取药品的性别限制名称
		String drugSex=(gender.getPromptMessage().equals("1"))?"男":"女";
		//获取病人的性别名称
		String patientSex=patient.getSex().getValueName();
		
		if(patientSex.equals(drugSex)) {
			return "";
		}
		return "\n本次交易有药品问题： "+drug.getDrugCode()+drug.getDrugName()+" 性别限制为"+drugSex+"性\n";
	}
	/**
	 * 
	* @Title: drugBodyMonitor 
	* @Description: TODO(药品年龄监控) 
	* @param @param drug 药品信息
	* @param @param patient 参保人信息
	* @param @return  参数说明 
	* @return String    返回类型 
	* @throws
	 */
	private String drugBodyMonitor(Drug drug,Patient patient) {
		DrugBodyLimit example=new DrugBodyLimit();
		example.setDrugCode(drug.getDrugCode());
		example.setDrugName(drug.getDrugName());
		Optional<DrugBodyLimit> option = drugBodyDao.findOne(Example.of(example));
		if(!option.isPresent()) {
			return "";
		}
		DrugBodyLimit body = option.get();
		Date now=new Date();
		//参保人年龄
		int age=now.getYear()-patient.getBirthday().getYear();
		String ageName=ageRange(age);
		
		//获取药品的年龄限制信息
		PublicDict exampleDict=new PublicDict();
		exampleDict.setDictCode("AGE_RANGE");
		exampleDict.setValueCode(body.getBodyLimit());
		Example<PublicDict> of = Example.of(exampleDict);
		Optional<PublicDict> optionAge = dictDao.findOne(of);
		
		if(!optionAge.isPresent()) {
			return "";
		}
		PublicDict drugAge = optionAge.get();
		
		//比较参保人和药品的年龄信息限制
		if(ageName.equals(drugAge.getValueName())) {
			return "";
		}
		return "\n次交易有药品问题： "+drug.getDrugCode()+drug.getDrugName()+" 年龄应该限制为"+drugAge.getValueName()+"\n";
	}
	/**
	 * 
	* @Title: ageRange 
	* @Description: TODO(判断年龄) 
	* @param @param age
	* @param @return  参数说明 
	* @return String    返回类型 
	* @throws
	 */
	private String ageRange(int age) {
		String range="";
		if(age<=18) {
			range="儿童";
		}else if(age <=60) {
			range="成年";
		}else {
			range="老年";
		}
		return range;
	}
	/**
	 * 
	* @Title: drugDayMonitor 
	* @Description: TODO(药品天数限制监控) 
	* @param @param drug 药品信息
	* @param @return  参数说明 
	* @return String    返回类型 
	* @throws
	 */
	public String drugDayMonitor(Drug drug,int nowDay) {
		//查询药品天数信息
		DrugDay example=new DrugDay();
		example.setDrug(drug);
		Optional<DrugDay> option = drugDayDao.findOne(Example.of(example));
		if(!option.isPresent()) {
			return "";
		}
		DrugDay drugDay = option.get();
		//药品限制天数
		Integer day = drugDay.getDay();
		
		if(nowDay<=day) {
			return "";
		}
		
		return "\n次交易有药品问题： "+drug.getDrugCode()+drug.getDrugName()+" 用药天数应该限制在"+day+"天\n";
		
		
	}
	/**
	 * 
	* @Title: drugInsuranceTypeMonitor 
	* @Description: TODO(药品限制监控) 
	* @param @param drug 药品
	* @param @param type 医嘱险种限制
	* @param @return  参数说明 
	* @return String    返回类型 
	* @throws
	 */
	public String drugInsuranceTypeMonitor(Drug drug,PublicDict type) {
		DrugInsuranceType example=new DrugInsuranceType();
		example.setDrug(drug);
		Optional<DrugInsuranceType> option = drugTypeDao.findOne(Example.of(example));
		if(!option.isPresent()) {
			return "";
		}
		DrugInsuranceType drugInsuranceType = option.get();
		//药品本身险种
		String drugType=drugInsuranceType.getInsuranceType().getValueName();
		//医嘱本身险种
		String orderType=type.getValueName();
		if(orderType.equals(drugType)) {
			return "";
		}
		return "\n次交易有药品问题： "+drug.getDrugCode()+drug.getDrugName()+" 医保险种应该限制在"+drugType+" 类型\n";
	}
	
}
