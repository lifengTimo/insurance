package com.lifeng.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * 导航栏Controller
 * @author PA
 *
 */
import org.springframework.web.bind.annotation.ResponseBody;

import com.lifeng.insurance.model.Nav;
import com.lifeng.insurance.service.NavService;
@Controller
@RequestMapping("nav")
public class NavController {
	@Autowired
	private NavService navService;
	
	@RequestMapping("/getAll")
	@ResponseBody
	public List<Nav> getAll(@RequestParam(value="id",required=false,defaultValue="0")String id){
		return navService.selectAllNav(id);
	}
	

}
