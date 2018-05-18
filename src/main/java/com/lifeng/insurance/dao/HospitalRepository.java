package com.lifeng.insurance.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lifeng.insurance.model.Hospital;

/**
 * 
* @ClassName: HospitalRepository 
* @Description: TODO(参保医院Dao) 
* @author lifeng
* @date 2018年5月16日 下午5:05:48 
*
 */
public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

	@Query(value="select *  from hospital where hospital_name like %?1% or pinyin like  %?1%  limit 200" , nativeQuery = true)
	List<Hospital> getAllByQ(String q);
}
