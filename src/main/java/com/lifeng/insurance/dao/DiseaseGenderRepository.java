package com.lifeng.insurance.dao;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.lifeng.insurance.model.DiseaseGender;

/**
 * 
* @ClassName: DiseaseGenderRepository 
* @Description: TODO(疾病性别限制Dao) 
* @author lifeng
* @date 2018年5月11日 下午11:27:09 
*
 */
public  interface DiseaseGenderRepository  extends JpaRepository<DiseaseGender,Integer>{

	/**
	 * 
	* @Title: deleteIds 
	* @Description: TODO(通过ids批量删除疾病性别限制信息) 
	* @param @param ids
	* @param @return  参数说明 
	* @return Integer    返回类型 
	* @throws
	 */
	@Transactional
	@Modifying
	@Query(value="delete from insurance_disease_gender  where id in ?1",nativeQuery=true)
	Integer deleteIds(Collection ids);
}
