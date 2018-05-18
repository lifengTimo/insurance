package com.lifeng.insurance.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
* @ClassName: OutpMaster 
* @Description: TODO(门诊报销主表pojo) 
* @author lifeng
* @date 2018年5月13日 上午11:41:59 
*
 */
@Entity
@Table(name="insurance_outp_master")
public class OutpMaster implements Serializable {
	
	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id",columnDefinition="bigint COMMENT '主键，自动生成'")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	//病人
	@JoinColumn(name="patient_id",columnDefinition="varchar(32) COMMENT '病人Id'")
	@ManyToOne()
	private Patient patient;
	
	//主诊断
    @JoinColumn(name="disease_id",columnDefinition="varchar(32) COMMENT '主诊断疾病编码'")
	@ManyToOne()
	private Disease disease;
    /**
     * 医院编码
     */
    @JoinColumn(name="hospital_id",columnDefinition="varchar(32) COMMENT '医院编码'")
    @ManyToOne()
    private Hospital hospital;
	
	//门诊报销细节表
	@JoinColumn(name="outp_id",columnDefinition="varchar(32) COMMENT '门诊报销主表Id'")
	@OneToMany(cascade=CascadeType.ALL)
	List<OutpDetail> details=new ArrayList<OutpDetail>();
	
	//总费用金额
	@Column(name="toal_Cost",columnDefinition="decimal(12,4) COMMENT '总费用金额'")
	private BigDecimal toalCost;
	
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

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Disease getDisease() {
		return disease;
	}

	public void setDisease(Disease disease) {
		this.disease = disease;
	}

	

	public List<OutpDetail> getDetails() {
		return details;
	}

	public void setDetails(List<OutpDetail> details) {
		this.details = details;
	}

	public BigDecimal getToalCost() {
		return toalCost;
	}

	public void setToalCost(BigDecimal toalCost) {
		this.toalCost = toalCost;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	
	

}
