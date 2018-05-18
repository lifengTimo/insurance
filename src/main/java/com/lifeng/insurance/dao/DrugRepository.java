package com.lifeng.insurance.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lifeng.insurance.model.Drug;
/**
 * 
* @ClassName: DrugRepository 
* @Description: TODO(药品model) 
* @author lifeng
* @date 2018年5月11日 下午10:15:16 
*
 */
public interface DrugRepository  extends JpaRepository<Drug,Integer> {
	
	@Query(value="select *  from insurance_drug where drug_name like %?1%", nativeQuery = true)
	List<Drug> getAll(String q);

}
