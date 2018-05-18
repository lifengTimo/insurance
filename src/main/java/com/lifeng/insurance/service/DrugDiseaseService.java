package com.lifeng.insurance.service;

import org.springframework.data.domain.Pageable;

import com.lifeng.insurance.model.DrugDisease;
import com.lifeng.insurance.model.PageReturn;

/**
 * 
* @ClassName: DrugDiseaseService 
* @Description: TODO(药品疾病限制Service) 
* @author lifeng
* @date 2018年5月11日 下午5:11:30 
*
 */
public interface DrugDiseaseService {
	
	/**
	 * 
	* @Title: getAll 
	* @Description: TODO(根据分页信息查询药品疾病限制信息) 
	* @param @param pageable
	* @param @return  参数说明 
	* @return PageReturn    返回类型 
	* @throws
	 */
	PageReturn getAll(Pageable pageable);
	
	/**
	 * 
	* @Title: insert 
	* @Description: TODO(插入药品疾病限制信息) 
	* @param @param hospital
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws
	 */
	int insert(DrugDisease day);
	
	/**
	 * 
	* @Title: getOne 
	* @Description: TODO(通过id查询药品疾病限制信息) 
	* @param @param id
	* @param @return  参数说明 
	* @return DrugDisease    返回类型 
	* @throws
	 */
	DrugDisease getOne(Integer id);
	/**
	 * 
	* @Title: del 
	* @Description: TODO(通过ids批量删除药品疾病限制信息) 
	* @param @param ids
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws
	 */
	int del(String ids);

}
