package com.lifeng.insurance.service;

import java.util.List;

import com.lifeng.insurance.model.PublicDict;

/**
 * 
* @ClassName: PublicDictService 
* @Description: TODO(公共字典) 
* @author lifeng
* @date 2018年5月9日 下午11:08:17 
*
 */
public interface PublicDictService {
	
	/**
	 * 
	* @Title: getAllByType 
	* @Description: TODO(通过类型查询公共字典) 
	* @param @param type
	* @param @return  参数说明 
	* @return List<PublicDict>    返回类型 
	* @throws
	 */
	List<PublicDict> getAllByType(String type);
	

}
