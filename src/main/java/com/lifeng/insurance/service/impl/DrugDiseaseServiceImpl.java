package com.lifeng.insurance.service.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lifeng.insurance.dao.DrugDiseaseRepository;
import com.lifeng.insurance.model.DrugDisease;
import com.lifeng.insurance.model.PageReturn;
import com.lifeng.insurance.service.DrugDiseaseService;
/**
 * 
* @ClassName: DrugDiseaseServiceImpl 
* @Description: TODO(药品疾病限制Service实现) 
* @author lifeng
* @date 2018年5月11日 下午5:39:53 
*
 */
@Service
public class DrugDiseaseServiceImpl implements DrugDiseaseService {

	/**
	 * 药品疾病限制限制Dao
	 */
	@Autowired
	private DrugDiseaseRepository drugdiseaseDao;
	
	@Override
	public PageReturn getAll(Pageable pageable) {
		Page<DrugDisease> findAll = drugdiseaseDao.findAll(pageable);
		return PageReturn.instance((int)findAll.getTotalElements(), findAll.getContent());
	}

	@Override
	public int insert(DrugDisease day) {
		if(day.getId()!=null) {
			DrugDisease oldDay=drugdiseaseDao.getOne(day.getId());
			oldDay.setDisease(day.getDisease());
			day=oldDay;
		}
		DrugDisease save = drugdiseaseDao.save(day);
		if(save==null) {
			return 0;
		}
		return 1;
	}

	@Override
	public DrugDisease getOne(Integer id) {
		
		return drugdiseaseDao.findById(id).get();
	}

	@Override
	public int del(String ids) {
		String[] split = ids.split(",");
		return drugdiseaseDao.delIds(Arrays.asList(split));
	}

}
