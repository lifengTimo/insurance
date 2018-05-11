package com.lifeng.insurance.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lifeng.insurance.model.Disease;
/**
 * 
* @ClassName: DiseaseRepository 
* @Description: TODO(疾病model) 
* @author lifeng
* @date 2018年5月11日 下午10:17:07 
*
 */
public interface DiseaseRepository  extends JpaRepository<Disease,Integer> {

	/**
	 * 
	* @Title: getAll 
	* @Description: TODO(根据条件模糊查询疾病) 
	* @param @param q
	* @param @return  参数说明 
	* @return List<Disease>    返回类型 
	* @throws
	 */
	@Query(value="select * from insurance_disease  where disease_name like %?1%  or pinyin like %?1%  limit 200",nativeQuery=true)
	List<Disease> getAll(String q);

}
