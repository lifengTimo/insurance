package com.lifeng.insurance.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import com.alibaba.fastjson.annotation.JSONField;
/**
 * 
* @ClassName: DiseaseGender 
* @Description: TODO(疾病限制model) 
* @author lifeng
* @date 2018年5月11日 下午11:01:45 
*
 */
@Entity
@Table(name = "insurance_disease_gender")
public class DiseaseGender implements Serializable {

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id", columnDefinition = "bigint COMMENT '主键，自动生成'")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	//疾病
	@JoinColumn(name="disease_id",columnDefinition="varchar(32) COMMENT '疾病id'")
	@OneToOne(targetEntity=Disease.class,optional=true)
	private Disease disease;
	//性别限制
	@JoinColumn(name="gender_Limit",columnDefinition="varchar(32) COMMENT '性别限制'")
	@ManyToOne
	private PublicDict  genderLimit;
	
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

	public Disease getDisease() {
		return disease;
	}

	public void setDisease(Disease disease) {
		this.disease = disease;
	}

	public PublicDict getGenderLimit() {
		return genderLimit;
	}

	public void setGenderLimit(PublicDict genderLimit) {
		this.genderLimit = genderLimit;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	
}
