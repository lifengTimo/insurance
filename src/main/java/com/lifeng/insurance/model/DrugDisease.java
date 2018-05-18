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

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
* @ClassName: DrugDisease 
* @Description: TODO(药品疾病限制) 
* @author lifeng
* @date 2018年5月18日 上午11:50:02 
*
 */
@Entity
@Table(name="insurance_Drug_Disease")
public class DrugDisease {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id", columnDefinition = "bigint COMMENT '主键，自动生成'")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	//药品
	@JoinColumn(name = "drug_id",columnDefinition="varchar(32) COMMENT '药品id' ")
	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	private Drug drug;
	
	//疾病
	@JoinColumn(name = "disease_id",columnDefinition="varchar(32) COMMENT '疾病id' ")
	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	private Disease disease;
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
	public Disease getDisease() {
		return disease;
	}
	public void setDisease(Disease disease) {
		this.disease = disease;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	
}
