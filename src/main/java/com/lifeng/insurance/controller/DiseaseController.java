package com.lifeng.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lifeng.insurance.model.Disease;
import com.lifeng.insurance.service.DiseaseServcie;

/**
 * 
* @ClassName: DiseaseController 
* @Description: TODO(疾病web) 
* @author lifeng
* @date 2018年5月11日 下午10:24:32 
*
 */
@Controller
@RequestMapping("disease")
public class DiseaseController {
	//疾病service
	@Autowired
	private DiseaseServcie diseaseService;
	
	/**
	 * 
	* @Title: getAll 
	* @Description: TODO(根据条件模糊查询疾病) 
	* @param @param q
	* @param @return  参数说明 
	* @return List<Disease>    返回类型 
	* @throws
	 */
	@RequestMapping("/getAll")
	@ResponseBody
	public List<Disease> getAll(@RequestParam(name="q",defaultValue="",required=false) String q){
		return diseaseService.getAll(q);
	}
	
	

}
