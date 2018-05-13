package com.lifeng.insurance.service;

import java.util.List;

import com.lifeng.insurance.model.Patient;

public interface PatientService {
	
	/**\
	 * 
	* @Title: getOne 
	* @Description: TODO(根据病人身份证号码查询病人信息) 
	* @param @param idNo
	* @param @return  参数说明 
	* @return Patient    返回类型 
	* @throws
	 */
	Patient getOne(String idNo);
	
	/**
	 * 
	* @Title: getAll 
	* @Description: TODO(获取全面病人信息) 
	* @param @return  参数说明 
	* @return List<Patient>    返回类型 
	* @throws
	 */
	List<Patient> getAll();

}
