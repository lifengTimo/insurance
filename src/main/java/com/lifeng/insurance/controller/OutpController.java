package com.lifeng.insurance.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.lifeng.insurance.model.OutpMaster;
import com.lifeng.insurance.service.OutpService;

/**
 * 
* @ClassName: OutpController 
* @Description: TODO(门诊报销web) 
* @author lifeng
* @date 2018年5月13日 下午4:34:58 
*
 */
@Controller
@RequestMapping("outp")
public class OutpController {
	
	/**
	 * 门诊报销service
	 */
	@Autowired
	private OutpService outpService;
	/**
	 * 
	* @Title: insert 
	* @Description: TODO(保存门诊报销信息并且处理监控) 
	* @param @param master
	* @param @return  参数说明 
	* @return String    返回类型 
	* @throws
	 */
	@RequestMapping("/insert")
	@ResponseBody
	public String insert(@RequestBody OutpMaster master) {
		Map<String, Object> map=new HashMap<>();
		map.put("result", outpService.insertOutp(master));
		return JSON.toJSONString(map);
	}

}
