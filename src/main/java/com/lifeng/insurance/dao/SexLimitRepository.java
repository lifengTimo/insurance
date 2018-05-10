package com.lifeng.insurance.dao;

import java.util.Collection;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.lifeng.insurance.model.SexLimit;



/**
 * 
* @ClassName: SexLimitRepository 
* @Description: TODO(药品限制 性别限制 Repository) 
* @author lifeng
* @date 2018年5月8日 下午11:07:52 
*
 */
public interface SexLimitRepository extends JpaRepository<SexLimit, Integer> {

	@Transactional
	@Modifying
	@Query(value="delete from insurance_sexlimit where id in ?1",nativeQuery=true)
	int deleteByIds(Collection  ids);
}
