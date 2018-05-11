package com.lifeng.insurance.service;
/**
 * 
* @ClassName: DiseaseServcie 
* @Description: TODO(疾病Service) 
* @author lifeng
* @date 2018年5月11日 下午10:20:23 
*
 */

import java.util.List;

import com.lifeng.insurance.model.Disease;

/**
 * 
* @ClassName: DiseaseServcie 
* @Description: TODO(疾病Servcie) 
* @author lifeng
* @date 2018年5月11日 下午10:22:29 
*
 */
public interface DiseaseServcie {
	/**
	 * 
	* @Title: getAll 
	* @Description: TODO(根据条件模糊查询疾病) 
	* @param @param q
	* @param @return  参数说明 
	* @return List<Disease>    返回类型 
	* @throws
	 */
	List<Disease> getAll(String q);

}
