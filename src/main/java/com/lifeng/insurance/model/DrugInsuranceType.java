package com.lifeng.insurance.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
* @ClassName: DrugInsuranceType 
* @Description: TODO(药品险种限制POJO) 
* @author lifeng
* @date 2018年5月11日 下午6:24:30 
*
 */
@Entity
@Table(name = "insurance_drug_Insurance_Type")
public class DrugInsuranceType {

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
	
	//药品险种限制
	@ManyToOne(targetEntity=PublicDict.class,optional = true,fetch=FetchType.EAGER)
	@JoinColumn(name="insurance_Type",columnDefinition="varchar(10)  COMMENT '药品险种限制'")
	private PublicDict insuranceType;
	
	// 创建时间
	@Column(name = "create_time", columnDefinition = "timestamp COMMENT '创建时间'", insertable = false, updatable = false)
	@Generated(GenerationTime.INSERT)
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

	public PublicDict getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(PublicDict insuranceType) {
		this.insuranceType = insuranceType;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "DrugInsuranceType [id=" + id + ", drug=" + drug + ", insuranceType=" + insuranceType + ", createTime="
				+ createTime + "]";
	}
	
	
}
