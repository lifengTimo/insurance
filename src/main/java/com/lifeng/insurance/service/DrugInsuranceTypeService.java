package com.lifeng.insurance.service;

import org.springframework.data.domain.Pageable;

import com.lifeng.insurance.model.DrugInsuranceType;
import com.lifeng.insurance.model.PageReturn;

/**
 * 
* @ClassName: DrugHospitalService 
* @Description: TODO(药品险种限制Service) 
* @author lifeng
* @date 2018年5月11日 下午12:06:39 
*
 */
public interface DrugInsuranceTypeService {
	
	/**
	 * 
	* @Title: getAll 
	* @Description: TODO(根据分页信息查询全面药品险种限制信息) 
	* @param @param pageable
	* @param @return  参数说明 
	* @return PageReturn    返回类型 
	* @throws
	 */
	PageReturn getAll(Pageable pageable);
	
	/**
	 * 
	* @Title: insert 
	* @Description: TODO(插入药品险种限制信息) 
	* @param @param hospital
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws
	 */
	int insert(DrugInsuranceType hospital);
	
	/**
	 * 
	* @Title: getOne 
	* @Description: TODO(通过id查询药品险种限制信息) 
	* @param @param id
	* @param @return  参数说明 
	* @return DrugInsuranceType    返回类型 
	* @throws
	 */
	DrugInsuranceType getOne(Integer id);
	/**
	 * 
	* @Title: del 
	* @Description: TODO(通过ids批量删除药品险种限制信息) 
	* @param @param ids
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws
	 */
	int del(String ids);
}
