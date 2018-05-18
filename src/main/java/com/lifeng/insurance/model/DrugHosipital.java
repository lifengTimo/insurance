package com.lifeng.insurance.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
* @ClassName: DrugHosipital 
* @Description: TODO(药品医院等级限制model) 
* @author lifeng
* @date 2018年5月11日 上午10:17:38 
*
 */
@Entity
@Table(name = "insurance_drug_hospital")
public class DrugHosipital implements Serializable{

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id", columnDefinition = "bigint COMMENT '主键，自动生成'")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	//药品
	@JoinColumn(name = "drug_id",columnDefinition="varchar(32) COMMENT '药品id' ")
	@OneToOne(fetch=FetchType.EAGER,optional=false)
	private Drug drug;
	
	//医院等级
	@ManyToOne(targetEntity=PublicDict.class,optional = true)
	@JoinColumn(name="hospital_Grade",columnDefinition="varchar(10)  COMMENT '医院等级'")
	private PublicDict hospitalGrade;
	
	// 创建时间
	@Column(name = "create_time", columnDefinition = "timestamp COMMENT '创建时间' DEFAULT CURRENT_TIMESTAMP ", insertable = false, updatable = false)
	@JSONField(format = "yyyy-MM-dd hh:mm:ss")
	private Timestamp createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Drug getDrug() {
		return drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}

	public PublicDict getHospitalGrade() {
		return hospitalGrade;
	}

	public void setHospitalGrade(PublicDict hospitalGrade) {
		this.hospitalGrade = hospitalGrade;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	
}
