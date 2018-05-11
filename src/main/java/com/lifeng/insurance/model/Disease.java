package com.lifeng.insurance.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
* @ClassName: Disease 
* @Description: TODO(疾病model) 
* @author lifeng
* @date 2018年5月11日 下午8:22:24 
*
 */
@Entity
@Table(name="insurance_disease")
public class Disease implements Serializable {

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id",columnDefinition="bigint COMMENT '主键，自动生成'")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	//ICD10疾病编码
	@Column(name="disease_Code",columnDefinition="varchar(100) COMMENT 'ICD10疾病编码'",unique=true)
	private String diseaseCode;
	//ICD10疾病名称
	@Column(name="disease_Name",columnDefinition="varchar(100) COMMENT 'ICD10疾病名称'")
	private String diseaseName;
	
	//拼音简码
	@Column(name="pinyin",columnDefinition="varchar(100)  COMMENT '拼音简码'")
	private String pinyin;
	//开始时间
	@Column(name="start_date",columnDefinition="date  COMMENT '开始时间'")
	private Date startDate;
	//结束时间
	@Column(name="stop_date",columnDefinition="date  COMMENT '结束时间'")
	private Date stopDate;
	//有效标志 0 无效 1 有效
	@Column(name="status",columnDefinition="varchar(1)  COMMENT '有效标志  0 无效 1 有效 ' default 1 ",nullable=false)
	private String status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDiseaseCode() {
		return diseaseCode;
	}
	public void setDiseaseCode(String diseaseCode) {
		this.diseaseCode = diseaseCode;
	}
	public String getDiseaseName() {
		return diseaseName;
	}
	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}
	public String getPinyin() {
		return pinyin;
	}
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getStopDate() {
		return stopDate;
	}
	public void setStopDate(Date stopDate) {
		this.stopDate = stopDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
