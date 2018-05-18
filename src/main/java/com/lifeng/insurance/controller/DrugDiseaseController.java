package com.lifeng.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lifeng.insurance.model.DrugDisease;
import com.lifeng.insurance.model.Page;
import com.lifeng.insurance.model.PageReturn;
import com.lifeng.insurance.service.DrugDiseaseService;
import com.lifeng.insurance.util.QueryTool;

/**
 * 
* @ClassName: DrugHospitalController 
* @Description: TODO(药品疾病限制Web) 
* @author lifeng
* @date 2018年5月11日 下午12:15:40 
*
 */

@Controller
@RequestMapping("drugDisease")
public class DrugDiseaseController {
	
	@Autowired
	private DrugDiseaseService drugDiseaseService;
	
	/**
	 * 
	* @Title: getAll 
	* @Description: TODO(通过分页信息查询药品疾病限制内容) 
	* @param @param page
	* @param @return  参数说明 
	* @return PageReturn    返回类型 
	* @throws
	 */
	@RequestMapping("/getAll")
	@ResponseBody
	public PageReturn getAll(Page page) {
		PageRequest pageRequest=null;
		pageRequest=QueryTool.buildPageRequest(page.getPage()-1, page.getRows());
		return drugDiseaseService.getAll(pageRequest);
	}
	/**
	 * 
	* @Title: insert 
	* @Description: TODO(插入药品疾病限制信息) 
	* @param @param hospital
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws
	 */
	@RequestMapping("/insert")
	@ResponseBody
	public int insert(@RequestBody DrugDisease day) {
		
		return drugDiseaseService.insert(day);
	}
	/**
	 * 
	* @Title: getOne 
	* @Description: TODO(通过id查询药品疾病限制信息) 
	* @param @param id
	* @param @return  参数说明 
	* @return DrugDisease    返回类型 
	* @throws
	 */
	@RequestMapping("/getOne")
	@ResponseBody
	public DrugDisease getOne(Integer id) {
		return drugDiseaseService.getOne(id);
	}
	/**
	 * 
	* @Title: del 
	* @Description: TODO(通过ids批量删除药品疾病限制信息) 
	* @param @param ids
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws
	 */
	@RequestMapping("/del")
	@ResponseBody
	public int del(String ids) {
		return drugDiseaseService.del(ids);
	}
}
