package com.lifeng.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.lifeng.insurance.model.Page;
import com.lifeng.insurance.model.PageReturn;
import com.lifeng.insurance.model.SexLimit;
import com.lifeng.insurance.service.SexLimitService;
import com.lifeng.insurance.util.QueryTool;

/**
 * 
* @ClassName: SexLimitController 
* @Description: TODO(这药品限制 性别限制  web) 
* @author lifeng
* @date 2018年5月8日 下午11:28:08 
*
 */
@Controller
@RequestMapping("sexLimit")
public class SexLimitController {
	/**
	 * 药品限制 性别限制 service
	 */
	@Autowired
	private SexLimitService sexService;
	/**
	 * 
	* @Title: getAll 
	* @Description: TODO(根据分页条件获取所有的管理员信息) 
	* @param @param page 分页信息
	* @param @return  返回数据
	* @return PageReturn    返回类型 
	* @throws
	 */
	@RequestMapping("/getAll")
	@ResponseBody
	public PageReturn getAll(Page page) {
		PageRequest pageRequest=null;
		pageRequest=QueryTool.buildPageRequest(page.getPage()-1, page.getRows());
		return sexService.getAllSexLimit(pageRequest);
	}
	/**
	 * 
	* @Title: insert 
	* @Description: TODO(插入性别限制信息) 
	* @param @param sex
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws
	 */
	@RequestMapping("/insert")
	@ResponseBody
	public int insert(SexLimit sex) {
		return sexService.insert(sex);
	}
	/**
	 * 
	* @Title: getOne 
	* @Description: TODO(通过id查询单条性别限制信息) 
	* @param @param id
	* @param @return  参数说明 
	* @return SexLimit    返回类型 
	* @throws
	 */
	@RequestMapping("/getOne")
	@ResponseBody
	public SexLimit getOne(Integer id) {
		return sexService.getOneById(id);
	}
	/**
	 * 
	* @Title: update 
	* @Description: TODO(修改性别限制内容) 
	* @param @param sex
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws
	 */
	@PutMapping("/update")
	@ResponseBody
	public int update(SexLimit sex) {
		return sexService.update(sex);
	}
	
	/**
	 * 
	* @Title: del 
	* @Description: TODO(根据ids删除性别限制内容) 
	* @param @param ids
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws
	 */
	 @RequestMapping("/del")
	@ResponseBody
	public int del(@RequestParam(value="ids",defaultValue="0",required=false) String ids) {
		System.out.println(ids);
		return sexService.delete(ids);
	}
}

