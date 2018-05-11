package com.lifeng.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lifeng.insurance.model. DiseaseGender;
import com.lifeng.insurance.model.Page;
import com.lifeng.insurance.model.PageReturn;
import com.lifeng.insurance.service.DiseaseGenderService;
import com.lifeng.insurance.util.QueryTool;

/**
 * 
* @ClassName: DiseaseGenderController 
* @Description: TODO(疾病性别等级限制Web) 
* @author lifeng
* @date 2018年5月11日 下午12:15:40 
*
 */

@Controller
@RequestMapping("diseaseGender")
public class DiseaseGenderController {
	
	@Autowired
	private DiseaseGenderService genderService;
	
	/**
	 * 
	* @Title: getAll 
	* @Description: TODO(通过分页信息查询疾病性别等级限制内容) 
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
		return genderService.getAll(pageRequest);
	}
	/**
	 * 
	* @Title: insert 
	* @Description: TODO(插入疾病性别等级限制信息) 
	* @param @param gender
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws
	 */
	@RequestMapping("/insert")
	@ResponseBody
	public int insert(@RequestBody  DiseaseGender gender) {
		
		return genderService.insert(gender);
	}
	/**
	 * 
	* @Title: getOne 
	* @Description: TODO(通过id查询疾病性别等级限制) 
	* @param @param id
	* @param @return  参数说明 
	* @return  DiseaseGender    返回类型 
	* @throws
	 */
	@RequestMapping("/getOne")
	@ResponseBody
	public  DiseaseGender getOne(Integer id) {
		return genderService.getOne(id);
	}
	/**
	 * 
	* @Title: del 
	* @Description: TODO(通过ids批量删除疾病性别等级限制信息) 
	* @param @param ids
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws
	 */
	@RequestMapping("/del")
	@ResponseBody
	public int del(String ids) {
		return genderService.del(ids);
	}
}
