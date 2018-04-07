package com.lifeng.insurance.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.lifeng.insurance.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{
	
	
	@Query(value="select * from insurance_admin a where a.user_name= ?1 and a.password= ?2 limit 1", nativeQuery = true)
	Admin exitsAdmin(String userName,String password);

}
