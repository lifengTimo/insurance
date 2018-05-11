package com.lifeng.insurance.service;

import org.springframework.data.domain.Pageable;

import com.lifeng.insurance.model.DrugDay;
import com.lifeng.insurance.model.PageReturn;

/**
 * 
* @ClassName: DrugDayService 
* @Description: TODO(药品拿药天数限制Service) 
* @author lifeng
* @date 2018年5月11日 下午5:11:30 
*
 */
public interface DrugDayService {
	
	/**
	 * 
	* @Title: getAll 
	* @Description: TODO(根据分页信息查询药品拿药天数限制信息) 
	* @param @param pageable
	* @param @return  参数说明 
	* @return PageReturn    返回类型 
	* @throws
	 */
	PageReturn getAll(Pageable pageable);
	
	/**
	 * 
	* @Title: insert 
	* @Description: TODO(插入药品拿药天数限制信息) 
	* @param @param hospital
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws
	 */
	int insert(DrugDay day);
	
	/**
	 * 
	* @Title: getOne 
	* @Description: TODO(通过id查询药品拿药天数限制信息) 
	* @param @param id
	* @param @return  参数说明 
	* @return DrugDay    返回类型 
	* @throws
	 */
	DrugDay getOne(Integer id);
	/**
	 * 
	* @Title: del 
	* @Description: TODO(通过ids批量删除药品拿药天数限制信息) 
	* @param @param ids
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws
	 */
	int del(String ids);

}
