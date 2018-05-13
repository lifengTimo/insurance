package com.lifeng.insurance.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import com.alibaba.fastjson.annotation.JSONField;
/**
 * 药品限制性别model
 * @author PA
 *
 */
@Entity
@Table(name="insurance_sexlimit")
public class SexLimit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5685841872462481616L;

	@Id
	@Column(name = "id",columnDefinition="bigint COMMENT '主键，自动生成'")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	/**
	 * 地方药品编码
	 */
	@Column(name = "drug_Code",columnDefinition="varchar(32) COMMENT '地方药品编码'",unique=true)
	private String  drugCode;
	/**
	 * 地方药品名称
	 */
	@Column(name = "drug_Name",columnDefinition="varchar(200) COMMENT '地方药品名称'")
	private String drugName;
	
	/**
	 * 提示信息 是否限制男女 1 限制男  2 限制女性
	 */
	@Column(name = "prompt_Message",columnDefinition="varchar(1) COMMENT '提示信息 是否限制男女 1 限制男  2 限制女性'")
	private String promptMessage;
	
	@Column(name="create_time",columnDefinition="timestamp COMMENT '创建时间'",insertable=false, updatable=false)
	@Generated(GenerationTime.INSERT)
	@JSONField(format="yyyy-MM-dd hh:mm:ss")
	private  Timestamp createTime;

	/**
	 * 提示信息  名称
	 */
	@Transient 
	private String promptMessageName;
	
	
	
	public String getPromptMessageName() {
		return promptMessageName;
	}

	public void setPromptMessageName(String promptMessageName) {
		this.promptMessageName = promptMessageName;
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

	public String getPromptMessage() {
		return promptMessage;
	}

	public void setPromptMessage(String promptMessage) {
		this.promptMessage = promptMessage;

	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
