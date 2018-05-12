package com.lifeng.insurance.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.lifeng.insurance.dao.DrugRepository;
import com.lifeng.insurance.dao.PublicDictRepository;
import com.lifeng.insurance.model.Drug;
import com.lifeng.insurance.model.PublicDict;
import com.lifeng.insurance.service.DrugService;
/**
 * 
* @ClassName: DrugServiceImpl 
* @Description: TODO(药品service) 
* @author lifeng
* @date 2018年5月12日 下午11:05:12 
*
 */
@Service
public class DrugServiceImpl implements DrugService {

	/**
	 * 药品dao
	 */
	@Autowired
	private DrugRepository drugRepository;
	/**
	 * 公共字典dao
	 */
	@Autowired
	private PublicDictRepository dictDao;
	
	@Override
	public List<Drug> getAll(String q) {
		PublicDict example=new PublicDict();
		example.setDictCode("insuranc_charge_type");
		if(q==null) q="";
		List<Drug> list = drugRepository.getAll(q);
		for(Drug item:list) {
			example.setValueCode(item.getChargeType());
			Optional<PublicDict> dict = dictDao.findOne(Example.of(example));
			item.setChargeType(dict.get().getValueName());
		}
		return list;
	}

}
