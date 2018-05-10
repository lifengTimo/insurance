package com.lifeng.insurance.dao;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.lifeng.insurance.model.DrugBodyLimit;



/**
 * 
* @ClassName: DrugBodyLimitRepository 
* @Description: TODO(药品限制年龄限制Dao) 
* @author lifeng
* @date 2018年5月10日 下午7:49:27 
*
 */
public interface DrugBodyLimitRepository  extends JpaRepository<DrugBodyLimit,Integer>{
	

	@Transactional
	@Modifying
	@Query(value="delete from insurance_drug_body  where id in ?1",nativeQuery=true)
	Integer deleteIds(Collection ids);
}
