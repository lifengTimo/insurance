package com.lifeng.insurance.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * 
* @ClassName: OutpDetail 
* @Description: TODO(门诊报销明细表pojo) 
* @author lifeng
* @date 2018年5月13日 上午11:46:20 
*
 */
@Entity
@Table(name="insurance_outp_detail")
public class OutpDetail implements Serializable {

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id",columnDefinition="bigint COMMENT '主键，自动生成'")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	//药品
	@JoinColumn(name="drug_id",columnDefinition="varchar(32) COMMENT '药品Id'")
	@ManyToOne
	private Drug drug;
	
	//用量
	@Column(name="USE_NUM",columnDefinition="varchar(32) COMMENT '用量'")
	
	private String  userNum;
	
	//用量单位
	@JoinColumn(name="USE_UNIT",columnDefinition="varchar(32) COMMENT '用量单位'")
	@ManyToOne
	private PublicDict useUnit;
	//用法
	@JoinColumn(name="FREQ",columnDefinition="varchar(32) COMMENT '用法'")
	@ManyToOne
	private PublicDict freq;
	
	//用药途径
	@JoinColumn(name="USE_WAY",columnDefinition="varchar(32) COMMENT '用药途径'")
	@ManyToOne
	private PublicDict userWay;
	
	//天数
	@Column(name="day",columnDefinition="bigint COMMENT '天数'")
	private int day;
	
	//单价
	@Column(name="price",columnDefinition="decimal(12,4) COMMENT '单价'")
	private BigDecimal price;
	
	//报销类型
	@JoinColumn(name="REIMBURSE_TYPE",columnDefinition="varchar(32) COMMENT '报销类型'")
	@ManyToOne
	private PublicDict reimburseType;
	
	//备注
	@Column(name="remarks",columnDefinition="varchar(255) COMMENT '备注'")
	
	private String remarks;

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

	public String getUserNum() {
		return userNum;
	}

	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}

	public PublicDict getUseUnit() {
		return useUnit;
	}

	public void setUseUnit(PublicDict useUnit) {
		this.useUnit = useUnit;
	}

	public PublicDict getUserWay() {
		return userWay;
	}

	public void setUserWay(PublicDict userWay) {
		this.userWay = userWay;
	}

	

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public PublicDict getReimburseType() {
		return reimburseType;
	}

	public void setReimburseType(PublicDict reimburseType) {
		this.reimburseType = reimburseType;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public PublicDict getFreq() {
		return freq;
	}

	public void setFreq(PublicDict freq) {
		this.freq = freq;
	}
	
	
	
}
