package com.lifeng.insurance.service;

import java.util.List;

import com.lifeng.insurance.model.Drug;

/**
 * 
* @ClassName: DrugService 
* @Description: TODO(药品Service) 
* @author lifeng
* @date 2018年5月9日 下午10:03:33 
*
 */
public interface DrugService {

	/**
	 * 
	* @Title: getAll 
	* @Description: TODO(查询全部的药品信息) 
	* @param @return  参数说明 
	* @return List<Drug>    返回类型 
	* @throws
	 */
	List<Drug> getAll(String q);
}
