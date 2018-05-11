package com.lifeng.insurance.dao;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.lifeng.insurance.model.DrugHosipital;

/**
 * 
* @ClassName: DrugHospitalRepository 
* @Description: TODO(药品医院等级限制Dao) 
* @author lifeng
* @date 2018年5月11日 下午12:03:34 
*
 */
public interface DrugHospitalRepository  extends JpaRepository<DrugHosipital,Integer>{

	/**
	 * 
	* @Title: delIds 
	* @Description: TODO(通过ids批量删除药品医院等级限制信息) 
	* @param @param ids
	* @param @return  参数说明 
	* @return int    返回类型 
	* @throws
	 */
	@Transactional
	@Modifying
	@Query(value="delete from insurance_drug_hospital  where id in ?1",nativeQuery=true)
	public int delIds(Collection ids);
}
