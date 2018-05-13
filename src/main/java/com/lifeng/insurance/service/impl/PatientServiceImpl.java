package com.lifeng.insurance.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.lifeng.insurance.dao.PatientRepository;
import com.lifeng.insurance.model.Patient;
import com.lifeng.insurance.service.PatientService;
/**
 * 
* @ClassName: PatientServiceImpl 
* @Description: TODO(病人serviceImpl) 
* @author lifeng
* @date 2018年5月13日 上午10:43:12 
*
 */
@Service
public class PatientServiceImpl implements PatientService {

	/**
	 * 病人Dao
	 */
	@Autowired
	private PatientRepository patienDao;
	
	@Override
	public Patient getOne(String idNo) {
		Patient patient=new Patient();
		patient.setIdNo(idNo);
		Optional<Patient> option = patienDao.findOne(Example.of(patient));
		if(!option.isPresent()) {
			return null;
		}
		patient = option.get();
		Date now=new Date();
		int age=now.getYear()-patient.getBirthday().getYear();
		patient.setAge(age);
		return patient;
	}

	@Override
	public List<Patient> getAll() {
		// TODO Auto-generated method stub
		return patienDao.findAll();
	}
	
	

}
