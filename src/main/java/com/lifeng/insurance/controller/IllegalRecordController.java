package com.lifeng.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lifeng.insurance.model.IllegalRecord;
import com.lifeng.insurance.model.Page;
import com.lifeng.insurance.model.PageReturn;
import com.lifeng.insurance.model.QueryContext;
import com.lifeng.insurance.service.IllegalRecordService;
import com.lifeng.insurance.util.QueryTool;

/**
 * 
* @ClassName: IllegalRecordController 
* @Description: TODO(违规记录web) 
* @author lifeng
* @date 2018年5月16日 下午11:26:29 
*
 */

@Controller
@RequestMapping("record")
public class IllegalRecordController {
	
	/**
	 * 违规记录Service
	 */
	@Autowired
	private IllegalRecordService recordService;
	
	/**
	 * 
	* @Title: getAll 
	* @Description: TODO(通过分页信息查询 ) 
	* @param @param page
	* @param @return  参数说明 
	* @return PageReturn    返回类型 
	* @throws
	 */
	@RequestMapping("/getAll")
	@ResponseBody
	public PageReturn getAll(QueryContext page){
		PageRequest pageRequest=null;
		pageRequest=QueryTool.buildPageRequest(page.getPage()-1, page.getRows());
	
		return recordService.getAll(pageRequest,page);
	}

	/**
	 * 
	* @Title: getOne 
	* @Description: TODO(通过id获取单条记录) 
	* @param @param id
	* @param @return  参数说明 
	* @return IllegalRecord    返回类型 
	* @throws
	 */
	@RequestMapping("/getOne")
	@ResponseBody
	public IllegalRecord getOne(Integer id) {
		return recordService.getOne(id);
	}
}
