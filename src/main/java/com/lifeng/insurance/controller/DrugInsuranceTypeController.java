package com.lifeng.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lifeng.insurance.model.DrugInsuranceType;
import com.lifeng.insurance.model.Page;
import com.lifeng.insurance.model.PageReturn;
import com.lifeng.insurance.service.DrugInsuranceTypeService;
import com.lifeng.insurance.util.QueryTool;

/**
 * 
* @ClassName: DrugInsuranceTypeController 
* @Description: TODO(药品险种限制Web) 
* @author lifeng
* @date 2018年5月11日 下午12:15:40 
*
 */

@Controller
@RequestMapping("drugType")
public class DrugInsuranceTypeController {
	
	@Autowired
	private DrugInsuranceTypeService insuranceTypeService;
	
	/**
	 * 
	* @Title: getAll 
	* @Description: TODO(通过分页信息查询药品险种限制内容) 
	* @param @param page
	* @param @return  参数说明 
	* @return PageReturn    返回类型 
	* @throws
	 */
	@RequestMapping("/getAll")
	@ResponseBody
	public PageReturn getAll(Page page) {
		
		try {
			PageRequest pageRequest=null;
			pageRequest=QueryTool.buildPageRequest(page.getPage()-1, page.getRows());
			return insuranceTypeService.getAll(pageRequest);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	/**
	 * 
	* @Title: insert 
	* @Description: TODO(插入药品险种限制信息) 
	* @param @param InsuranceType
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws
	 */
	@RequestMapping("/insert")
	@ResponseBody
	public int insert(@RequestBody DrugInsuranceType InsuranceType) {
		try {
			return insuranceTypeService.insert(InsuranceType);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}
	/**
	 * 
	* @Title: getOne 
	* @Description: TODO(通过id查询药品险种限制信息) 
	* @param @param id
	* @param @return  参数说明 
	* @return DrugInsuranceType    返回类型 
	* @throws
	 */
	@RequestMapping("/getOne")
	@ResponseBody
	public DrugInsuranceType getOne(Integer id) {
		return insuranceTypeService.getOne(id);
	}
	/**
	 * 
	* @Title: del 
	* @Description: TODO(通过ids批量删除药品险种限制信息) 
	* @param @param ids
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws
	 */
	@RequestMapping("/del")
	@ResponseBody
	public int del(String ids) {
		return insuranceTypeService.del(ids);
	}
}
