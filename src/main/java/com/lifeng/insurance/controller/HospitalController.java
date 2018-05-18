package com.lifeng.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * 
* @ClassName: HospitalController 
* @Description: TODO(定点经办机构医院web) 
* @author lifeng
* @date 2018年5月16日 下午7:20:47 
*
 */
import org.springframework.web.bind.annotation.ResponseBody;

import com.lifeng.insurance.model.Hospital;
import com.lifeng.insurance.service.HospitalService;
@Controller
@RequestMapping("hospital")
public class HospitalController {

	@Autowired
	private HospitalService hospitalService;
	
	/**
	 * 
	* @Title: getAll 
	* @Description: TODO(通过拼音模糊查询内容) 
	* @param @param q
	* @param @return  参数说明 
	* @return List<Hospital>    返回类型 
	* @throws
	 */
	@RequestMapping("/getAll")
	@ResponseBody
	public List<Hospital> getAll(@RequestParam(name="q",defaultValue="",required=false) String q) {
		return hospitalService.getAll(q);
	}
}
