package com.lifeng.insurance.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 限制性别model
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

	/**
	 * 地方药品编码
	 */
	@Id
	@Column(name = "drug_Code",columnDefinition="varchar(32) COMMENT '地方药品编码'")
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
	
	
}
