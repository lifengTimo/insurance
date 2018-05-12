package com.lifeng.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lifeng.insurance.model.PublicDict;
import com.lifeng.insurance.service.PublicDictService;

/**
 * 
* @ClassName: PublicDictController 
* @Description: TODO(公共字典web) 
* @author lifeng
* @date 2018年5月12日 下午9:43:03 
*
 */
@Controller
@RequestMapping("dict")
public class PublicDictController {
	
	@Autowired
	private PublicDictService dictService;
	
	@RequestMapping("/getAll")
	@ResponseBody
	public List<PublicDict> getAll(String type){
		return dictService.getAllByType(type);
	}
}
