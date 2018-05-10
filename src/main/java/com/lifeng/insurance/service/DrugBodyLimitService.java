package com.lifeng.insurance.service;

import org.springframework.data.domain.Pageable;

import com.lifeng.insurance.model.DrugBodyLimit;
import com.lifeng.insurance.model.PageReturn;
/**
 * 
* @ClassName: DrugBodyLimitService 
* @Description: TODO(药品年龄限制Service) 
* @author lifeng
* @date 2018年5月10日 下午9:25:23 
*
 */
public interface DrugBodyLimitService {
	/**
	 * 
	* @Title: getAllAmin 
	* @Description: TODO(分页信息获取药品年龄限制信息) 
	* @param @param pageable
	* @param @return  参数说明 
	* @return PageReturn    返回类型 
	* @throws
	 */
	PageReturn getAll(Pageable pageable);
	
	/**
	 * 
	* @Title: insert 
	* @Description: TODO(药品插入年龄限制信息) 
	* @param @param body
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws
	 */
	int insert(DrugBodyLimit body);
	
	/**
	 * 
	* @Title: getOneById 
	* @Description: TODO(根据id查询药品年龄限制信息) 
	* @param @param id
	* @param @return  参数说明 
	* @return DrugBodyLimit    返回类型 
	* @throws
	 */
	DrugBodyLimit getOneById(Integer id);
	
	/**
	 * 
	* @Title: update 
	* @Description: TODO(更新药品年龄限制信息) 
	* @param @param body
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws
	 */
	int update(DrugBodyLimit body);
	/**
	 * 
	* @Title: del 
	* @Description: TODO(根据集合ids删除药品年龄限制信息) 
	* @param @param ids
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws
	 */
	int del(String ids);

}
