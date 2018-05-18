package com.lifeng.insurance.service;


import java.util.List;

import org.springframework.data.domain.Pageable;

import com.lifeng.insurance.model.IllegalRecord;
import com.lifeng.insurance.model.PageReturn;
import com.lifeng.insurance.model.QueryContext;


/**
 * 
* @ClassName: IllegalRecordService 
* @Description: TODO(违规记录service) 
* @author lifeng
* @date 2018年5月16日 下午11:18:47 
*
 */
public interface IllegalRecordService {

	/**
	 * 
	* @Title: getAll 
	* @Description: TODO(通过分页信息查询) 
	* @param @param pageable
	* @param @return  参数说明 
	* @return PageReturn    返回类型 
	* @throws
	 */
	PageReturn getAll(Pageable pageable,QueryContext query);
	
	/**
	 * 
	* @Title: getOne 
	* @Description: TODO(根据id查询内容) 
	* @param @param id
	* @param @return  参数说明 
	* @return IllegalRecord    返回类型 
	* @throws
	 */
	IllegalRecord getOne(Integer id);

}
