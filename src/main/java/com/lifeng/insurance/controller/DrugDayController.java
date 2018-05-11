package com.lifeng.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lifeng.insurance.model.DrugDay;
import com.lifeng.insurance.model.Page;
import com.lifeng.insurance.model.PageReturn;
import com.lifeng.insurance.service.DrugDayService;
import com.lifeng.insurance.util.QueryTool;

/**
 * 
* @ClassName: DrugHospitalController 
* @Description: TODO(药品天数限制Web) 
* @author lifeng
* @date 2018年5月11日 下午12:15:40 
*
 */

@Controller
@RequestMapping("drugDay")
public class DrugDayController {
	
	@Autowired
	private DrugDayService dayService;
	
	/**
	 * 
	* @Title: getAll 
	* @Description: TODO(通过分页信息查询药品天数限制内容) 
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
		return dayService.getAll(pageRequest);
	}
	/**
	 * 
	* @Title: insert 
	* @Description: TODO(插入药品天数限制信息) 
	* @param @param hospital
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws
	 */
	@RequestMapping("/insert")
	@ResponseBody
	public int insert(@RequestBody DrugDay day) {
		
		return dayService.insert(day);
	}
	/**
	 * 
	* @Title: getOne 
	* @Description: TODO(通过id查询药品天数限制信息) 
	* @param @param id
	* @param @return  参数说明 
	* @return DrugDay    返回类型 
	* @throws
	 */
	@RequestMapping("/getOne")
	@ResponseBody
	public DrugDay getOne(Integer id) {
		return dayService.getOne(id);
	}
	/**
	 * 
	* @Title: del 
	* @Description: TODO(通过ids批量删除药品天数限制信息) 
	* @param @param ids
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws
	 */
	@RequestMapping("/del")
	@ResponseBody
	public int del(String ids) {
		return dayService.del(ids);
	}
}
