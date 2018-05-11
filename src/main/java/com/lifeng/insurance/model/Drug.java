package com.lifeng.insurance.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 药品编码
 * @author admin
 *
 */
@Entity
@Table(name="insurance_drug")
public class Drug implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name = "id",columnDefinition="bigint COMMENT '主键，自动生成'")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	//药品编码
	@Column(name="drug_Code",columnDefinition="varchar(100) COMMENT '药品编码'")
	private String drugCode;
	//药品名称
	@Column(name="drug_Name",columnDefinition="varchar(100) COMMENT '药品名称'")
	private String drugName;
	//英文名称（化学名称）
	@Column(name="english_Name",columnDefinition="varchar(100) COMMENT '英文名称（化学名称）'")
	private String englishName;
	
	
	//开始时间
	@Column(name="start_Time",columnDefinition="timestamp COMMENT '开始时间'")
	@JSONField(format="yyyy-MM-dd")
	private Date startTime;
	//结束时间
	@Column(name="stop_Time",columnDefinition="timestamp COMMENT '结束时间'")
	@JSONField(format="yyyy-MM-dd")
	private Date stopTime;
	
	//收费项目等级
	@Column(name="charge_Type",columnDefinition="varchar(10) COMMENT '收费项目等级'")
	private String chargeType;
	
	//收费项目等级名称
	@Transient
	private String chargeName;
	
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

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getStopTime() {
		return stopTime;
	}

	public void setStopTime(Date stopTime) {
		this.stopTime = stopTime;
	}

	public String getChargeType() {
		return chargeType;
	}

	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}

	public String getChargeName() {
		return chargeName;
	}

	public void setChargeName(String chargeName) {
		this.chargeName = chargeName;
	}

	@Override
	public String toString() {
		return "Drug [id=" + id + ", drugCode=" + drugCode + ", drugName=" + drugName + ", englishName=" + englishName
				+ ", startTime=" + startTime + ", stopTime=" + stopTime + ", chargeType=" + chargeType + ", chargeName="
				+ chargeName + "]";
	}
	
}
