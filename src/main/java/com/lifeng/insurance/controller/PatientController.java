package com.lifeng.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lifeng.insurance.model.Patient;
import com.lifeng.insurance.service.PatientService;
/**
 * 
* @ClassName: PatientController 
* @Description: TODO(病人Web) 
* @author lifeng
* @date 2018年5月13日 上午10:46:21 
*
 */
@Controller
@RequestMapping("patient")
public class PatientController {

	/**
	 * 病人Service
	 */
	@Autowired
	private PatientService patientService;
	
	/**
	 * 
	* @Title: getAll 
	* @Description: TODO(获取全部的病人信息) 
	* @param @return  参数说明 
	* @return List<Patient>    返回类型 
	* @throws
	 */
	@RequestMapping("/getAll")
	@ResponseBody
	public List<Patient> getAll(){
		return patientService.getAll();
	}
	/**
	 * 
	* @Title: getOne 
	* @Description: TODO(根据社保身份证号码查询人信息) 
	* @param @param idNo
	* @param @return  参数说明 
	* @return Patient    返回类型 
	* @throws
	 */
	@RequestMapping("/getOne")
	@ResponseBody
	public Patient getOne(@RequestParam(name="idNo",defaultValue="",required=false)String idNo){
		return patientService.getOne(idNo);
	}
}
