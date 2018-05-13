package com.lifeng.insurance.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lifeng.insurance.model.OutpDetail;
/**
 * 
* @ClassName: OutpDetailRepository 
* @Description: TODO(门诊报销明细表存储) 
* @author lifeng
* @date 2018年5月13日 下午4:16:12 
*
 */
public interface OutpDetailRepository extends JpaRepository<OutpDetail, Integer>{

}
