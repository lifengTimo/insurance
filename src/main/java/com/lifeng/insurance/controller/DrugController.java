package com.lifeng.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lifeng.insurance.model.Drug;
import com.lifeng.insurance.service.DrugService;

/**
 * 
* @ClassName: DrugController 
* @Description: TODO(药品Controller) 
* @author lifeng
* @date 2018年5月9日 下午10:06:49 
*
 */
@Controller
@RequestMapping("drug")
public class DrugController {
	
	@Autowired
	private DrugService drugService;
	
	@RequestMapping("/getAll")
	@ResponseBody
	public List<Drug> getAll(String q){
		return drugService.getAll(q);
	}

}
