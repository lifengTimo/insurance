package com.lifeng.insurance.service.impl;


import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lifeng.insurance.dao.DrugHospitalRepository;
import com.lifeng.insurance.dao.PublicDictRepository;
import com.lifeng.insurance.model.DrugHosipital;
import com.lifeng.insurance.model.PageReturn;
import com.lifeng.insurance.service.DrugHospitalService;
@Service
public class DrugHospitalServiceImpl implements DrugHospitalService{

	//药品医院等级限制dao
	@Autowired
	private DrugHospitalRepository hospitalDao;
	
	//公共字典Dao
	@Autowired
	private PublicDictRepository dictDao;
	@Override
	public PageReturn getAll(Pageable pageable) {
		Page<DrugHosipital> results = hospitalDao.findAll(pageable);
		System.out.println(results.getContent());
		return PageReturn.instance((int)results.getTotalElements(), results.getContent());
	}

	@Override
	public int insert(DrugHosipital hospital) {
		if(hospital.getId()!=null) {
			DrugHosipital old=hospitalDao.getOne(hospital.getId());
			old.setHospitalGrade(hospital.getHospitalGrade());
			hospital=old;
		}
		hospitalDao.save(hospital);
		return 1;
	}

	@Override
	public DrugHosipital getOne(Integer id) {
		Optional<DrugHosipital> results = hospitalDao.findById(id);
		return results.get();
	}

	@Override
	public int del(String ids) {
		String[] split = ids.split(",");	
		return hospitalDao.delIds(Arrays.asList(split));
	}

}
