package com.lifeng.insurance.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import com.alibaba.fastjson.annotation.JSONField;
/**
 * 
* @ClassName: DrugDay 
* @Description: TODO(药品天数限制model) 
* @author lifeng
* @date 2018年5月11日 下午5:05:22 
*
 */
@Entity
@Table(name="insurance_drug_day")
public class DrugDay implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id", columnDefinition = "bigint COMMENT '主键，自动生成'")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	//药品
	@JoinColumn(name = "drug_id",columnDefinition="varchar(32) COMMENT '药品id' ")
	@OneToOne(fetch=FetchType.EAGER,optional=false)
	private Drug drug;
	
	//药品限制天数
	@Column(name="day",columnDefinition="bigint COMMENT '药品限制天数'")
	private Integer day;
	
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

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	
}
