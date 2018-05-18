package com.lifeng.insurance.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @ClassName: DrugBodyLimit
 * @Description: TODO(药品)
 * @author lifeng
 * @date 2018年5月10日 下午6:50:08
 *
 */
@Entity
@Table(name = "insurance_drugBody")
public class DrugBodyLimit implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id", columnDefinition = "bigint COMMENT '主键，自动生成'")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	// 药品编码
	@Column(name = "drug_Code", columnDefinition = "varchar(100) COMMENT '药品编码'",unique=true)
	private String drugCode;
	// 药品名称
	@Column(name = "drug_Name", columnDefinition = "varchar(100) COMMENT '药品名称'")
	private String drugName;
	// 年龄限制
	@Column(name = "body_Limit", columnDefinition = "varchar(4) COMMENT '年龄限制'")
	private String bodyLimit;

	// 创建时间
	@Column(name = "create_time", columnDefinition = "timestamp COMMENT '创建时间' DEFAULT CURRENT_TIMESTAMP ", insertable = false, updatable = false)
	@JSONField(format = "yyyy-MM-dd hh:mm:ss")
	private Timestamp createTime;
	// 年龄限制名称
	@Transient
	private String bodyLimitName;

	public String getBodyLimitName() {
		return bodyLimitName;
	}

	public void setBodyLimitName(String bodyLimitName) {
		this.bodyLimitName = bodyLimitName;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDrugCode() {
		return drugCode;
	}

	public void setDrugCode(String drugCode) {
		this.drugCode = drugCode;
	}

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public String getBodyLimit() {
		return bodyLimit;
	}

	public void setBodyLimit(String bodyLimit) {
		this.bodyLimit = bodyLimit;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "DrugBodyLimit [id=" + id + ", drugCode=" + drugCode + ", drugName=" + drugName + ", bodyLimit="
				+ bodyLimit + ", createTime=" + createTime + ", bodyLimitName=" + bodyLimitName + "]";
	}

}
