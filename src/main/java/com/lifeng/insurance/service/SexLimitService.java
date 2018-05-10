package com.lifeng.insurance.service;
/**
 * 
* @ClassName: SexLimitService 
* @Description: TODO(药品限制 性别限制 Service) 
* @author lifeng
* @date 2018年5月8日 下午11:13:28 
*
 */


import org.springframework.data.domain.Pageable;

import com.lifeng.insurance.model.PageReturn;
import com.lifeng.insurance.model.SexLimit;


public interface SexLimitService {
	
	/**
	 * 
	* @Title: getAllSexLimit 
	* @Description: TODO(获取所有的性别限制信息) 
	* @param @param pageable
	* @param @return  分页信息
	* @return PageReturn    分页条件下的性别信息
	* @throws
	 */
	PageReturn getAllSexLimit(Pageable pageable);
	
	/**\
	 * 
	* @Title: insert 
	* @Description: TODO(插入药品限制中的性别限制) 
	* @param @param sex
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws
	 */
	int insert(SexLimit sex);
	
	/**
	 * 
	* @Title: getOneById 
	* @Description: TODO(通过id查询单条性别限制信息) 
	* @param @param id
	* @param @return  参数说明 
	* @return SexLimit    返回类型 
	* @throws
	 */
	SexLimit getOneById(int id);
	
	/**
	 * 
	* @Title: update 
	* @Description: TODO(修改性别限制内容) 
	* @param @param sex
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws
	 */
	int update(SexLimit sex);
	/**
	 * 
	* @Title: delete 
	* @Description: TODO(根据ids删除性别限制内容) 
	* @param @param ids
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws
	 */
	int delete(String ids);
}
