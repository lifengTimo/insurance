package com.lifeng.insurance.service.impl;


import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lifeng.insurance.dao.DrugInsuranceTypeRepository;
import com.lifeng.insurance.dao.PublicDictRepository;
import com.lifeng.insurance.model.DrugInsuranceType;
import com.lifeng.insurance.model.PageReturn;
import com.lifeng.insurance.service.DrugInsuranceTypeService;
/**
 * 
* @ClassName: DrugInsuranceTypeServiceImpl 
* @Description: TODO(药品险种限制ServiceImpl) 
* @author lifeng
* @date 2018年5月11日 下午6:39:36 
*
 */
@Service
public class DrugInsuranceTypeServiceImpl implements DrugInsuranceTypeService{

	//药品险种限制dao
	@Autowired
	private DrugInsuranceTypeRepository InsuranceTypeDao;
	
	//公共字典Dao
	@Autowired
	private PublicDictRepository dictDao;
	@Override
	public PageReturn getAll(Pageable pageable) {
		Page<DrugInsuranceType> results = InsuranceTypeDao.findAll(pageable);
		System.out.println(results.getContent());
		return PageReturn.instance((int)results.getTotalElements(), results.getContent());
	}

	@Override
	public int insert(DrugInsuranceType InsuranceType) {
		InsuranceTypeDao.save(InsuranceType);
		return 1;
	}

	@Override
	public DrugInsuranceType getOne(Integer id) {
		Optional<DrugInsuranceType> results = InsuranceTypeDao.findById(id);
		return results.get();
	}

	@Override
	public int del(String ids) {
		String[] split = ids.split(",");	
		return InsuranceTypeDao.delIds(Arrays.asList(split));
	}

}
