package com.lifeng.insurance.service;
/**\
 * 
* @ClassName: HospitalService 
* @Description: TODO(参保医院Service) 
* @author lifeng
* @date 2018年5月16日 下午6:02:07 
*
 */

import java.util.List;

import com.lifeng.insurance.model.Hospital;

public interface HospitalService {
	/**
	 * 
	* @Title: getAll 
	* @Description: TODO(通过拼音模糊查询内容) 
	* @param @param q
	* @param @return  参数说明 
	* @return List<Hospital>    返回类型 
	* @throws
	 */
	List<Hospital> getAll(String q);

}
