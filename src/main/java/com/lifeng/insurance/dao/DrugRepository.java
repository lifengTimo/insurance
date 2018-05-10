package com.lifeng.insurance.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lifeng.insurance.model.Drug;

public interface DrugRepository  extends JpaRepository<Drug,Integer> {
	
	@Query(value="select t.* ,T2.value_name as charge_Name from insurance_drug T left JOIN public_dict T2 on T.charge_type=T2.value_code and T2.dict_code='insuranc_charge_type' where t.drug_name like %?1%", nativeQuery = true)
	List<Drug> getAll(String q);

}
