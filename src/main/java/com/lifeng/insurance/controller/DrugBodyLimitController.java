package com.lifeng.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lifeng.insurance.model.DrugBodyLimit;
import com.lifeng.insurance.model.Page;
import com.lifeng.insurance.model.PageReturn;
import com.lifeng.insurance.service.DrugBodyLimitService;
import com.lifeng.insurance.util.QueryTool;

/**
 * 
* @ClassName: DrugBodyLimitController 
* @Description: TODO(药品限制年龄限制 Web) 
* @author lifeng
* @date 2018年5月10日 下午9:43:20 
*
 */
@Controller
@RequestMapping("drugBody")
public class DrugBodyLimitController {
	
	@Autowired
	private DrugBodyLimitService bodyService;
	
	/**
	 * 
	* @Title: getAll 
	* @Description: TODO(根据分页信息查询药品限制年龄信息) 
	* @param @param page
	* @param @return  参数说明 
	* @return PageReturn    返回类型 
	* @throws
	 */
	@RequestMapping("/getAll")
	@ResponseBody
	public  PageReturn getAll(Page page) {
		PageRequest pageRequest=null;
		pageRequest=QueryTool.buildPageRequest(page.getPage()-1, page.getRows());
		return bodyService.getAll(pageRequest);
	}
	/**
	 * 
	* @Title: insert 
	* @Description: TODO(插入药品年龄限制信息) 
	* @param @param body
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws
	 */
	@RequestMapping("/insert")
	@ResponseBody
	public int insert(DrugBodyLimit body) {
		return bodyService.insert(body);
	}

	/**
	 * 
	* @Title: getOne 
	* @Description: TODO(根据id查询药品年龄限制信息) 
	* @param @param id
	* @param @return  参数说明 
	* @return DrugBodyLimit    返回类型 
	* @throws
	 */
	@RequestMapping("/getOne")
	@ResponseBody
	public DrugBodyLimit getOne(Integer id) {
		return bodyService.getOneById(id);
	}
	/**
	 * 
	* @Title: update 
	* @Description: TODO(更新药品年龄限制信息) 
	* @param @param body
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws
	 */
	@PutMapping("/update")
	@ResponseBody
	public int update(DrugBodyLimit body) {
		return bodyService.update(body);
	}
	
	@RequestMapping("/del")
	@ResponseBody
	public int del(String ids) {
		return bodyService.del(ids);
	}
}
