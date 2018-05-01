package com.lifeng.insurance.dao;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.lifeng.insurance.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{
	
	
	@Query(value="select * from insurance_admin a where a.user_name= ?1 and a.password= ?2 limit 1", nativeQuery = true)
	Admin exitsAdmin(String userName,String password);
	
	@Transactional
	@Modifying
	@Query(value="delete from insurance_admin  where id in ?1",nativeQuery=true)
	Integer deleteIds(Collection ids);

}
