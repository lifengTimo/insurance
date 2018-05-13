package com.lifeng.insurance.service;

import com.lifeng.insurance.model.OutpMaster;

/**
 * 
* @ClassName: OutpService 
* @Description: TODO(门诊报销处理) 
* @author lifeng
* @date 2018年5月13日 下午4:17:12 
*
 */
public interface OutpService {

	/**
	 * 
	* @Title: insertOutp 
	* @Description: TODO(插入门诊报销处理) 
	* @param @param master
	* @param @return  参数说明 
	* @return String    返回类型 
	* @throws
	 */
	public String insertOutp(OutpMaster master);
}
