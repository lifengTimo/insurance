package com.lifeng.insurance.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lifeng.insurance.model.OutpMaster;
/**
 * 
* @ClassName: OuptMasterRepository 
* @Description: TODO(门诊报销主表Dao) 
* @author lifeng
* @date 2018年5月13日 下午4:13:05 
*
 */
public interface OutpMasterRepository  extends JpaRepository<OutpMaster,Integer>{ 

}
