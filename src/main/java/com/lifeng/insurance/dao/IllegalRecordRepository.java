package com.lifeng.insurance.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lifeng.insurance.model.IllegalRecord;

public interface IllegalRecordRepository extends JpaRepository<IllegalRecord,Integer > {

	@Query("select u from IllegalRecord u left outer join u.outp o "
			+ "left outer join o.patient p "
			+" left outer join o.hospital h "
			+ "where u.createTime between ?1 and ?2"
			+ " and p.name like %?4% and p.idNo like %?5%"
			+" and h.hospitalNo like %?3%")
	List<IllegalRecord> getAllByQuery(Date startTime, Date endTime,String hospitalId, String name, String idCard);
	
	@Query(value="SELECT\r\n" + 
			"	u.id AS  id,\r\n" + 
			"	u.createtime AS createTime,\r\n" + 
			"	u2.name as name,\r\n" + 
			"  u3.hospital_name hospitalName,\r\n" + 
			" u2.id_no as idCard, "+
			"	u.record AS record\r\n" + 
			"FROM\r\n" + 
			"	insurance_illegal_record u\r\n" + 
			"LEFT OUTER JOIN insurance_outp_master u1 ON u.outp_id = u1.id\r\n" + 
			"LEFT OUTER JOIN patient u2 ON u1.patient_id = u2.id\r\n" + 
			"LEFT OUTER JOIN hospital u3 ON u1.hospital_id = u3.id\r\n" + 
			"WHERE\r\n" + 
			"	(\r\n" + 
			"		u.createtime BETWEEN  STR_TO_DATE(?1,\"%Y-%m-%d %H:%i:%s\") \r\n" + 
			"		AND  STR_TO_DATE(?2,\"%Y-%m-%d %H:%i:%s\") \r\n" + 
			"	)\r\n" + 
			"AND (u2. NAME LIKE %?4%)\r\n" + 
			"AND (u2.id_no LIKE %?5%)\r\n" + 
			"AND (u3.hospital_no LIKE %?3%)",nativeQuery=true)
	Page<IllegalRecordReturn> getAllByI(String startTime, String endTime,String hospitalId, String name, String idCard, Pageable pageable);
	@Query(value="SELECT\r\n" + 
			"	u.id AS  id,\r\n" + 
			"	u.createtime AS createTime,\r\n" + 
			"	u2.name as name,\r\n" + 
			"  u3.hosital_name hospitalName,\r\n" + 
			"	u.record AS record\r\n" + 
			"FROM\r\n" + 
			"	insurance_illegal_record u\r\n" + 
			"LEFT OUTER JOIN insurance_outp_master u1 ON u.outp_id = u1.id\r\n" + 
			"LEFT OUTER JOIN patient u2 ON u1.patient_id = u2.id\r\n" + 
			"LEFT OUTER JOIN hospital u3 ON u1.hospital_id = u3.id\r\n" + 
			"WHERE\r\n" + 
			"	(\r\n" + 
			"		u.createtime BETWEEN  STR_TO_DATE(?1,\"%Y-%m-%d %H:%i:%s\") \r\n" + 
			"		AND  STR_TO_DATE(?2,\"%Y-%m-%d %H:%i:%s\") \r\n" + 
			"	)\r\n" + 
			"AND (u2. NAME LIKE %?4%)\r\n" + 
			"AND (u2.id_no LIKE %?5%)\r\n" + 
			"AND (u3.hosital_no LIKE %?3%)",nativeQuery=true)
	List<IllegalRecordReturn> getAllByII(String startTime, String endTime,String hospitalId, String name, String idCard);
}
