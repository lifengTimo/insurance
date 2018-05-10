package com.lifeng.insurance.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lifeng.insurance.model.PublicDict;
/**
 * 
* @ClassName: PublicDictRepository 
* @Description: TODO(公共字典Dao) 
* @author lifeng
* @date 2018年5月9日 下午11:10:14 
*
 */
public interface PublicDictRepository extends JpaRepository<PublicDict,Integer> {

}
