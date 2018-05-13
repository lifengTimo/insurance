package com.lifeng.insurance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lifeng.insurance.model.Patient;

/**
 * 
* @ClassName: PatientRepository 
* @Description: TODO(病人Dao) 
* @author lifeng
* @date 2018年5月13日 上午10:36:28 
*
 */
public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
