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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 医院
 * 
 * @ClassName: Hospital
 * @Description: TODO(医院pojo)
 * @author lifeng
 * @date 2018年5月16日 下午12:19:46
 *
 */
@Entity
@Table(name = "hospital")
public class Hospital implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id", columnDefinition = "bigint COMMENT '主键，自动生成'")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/**
	 * 医院国家编号
	 */
	@Column(name = "hospital_no", columnDefinition = "varchar(50)  COMMENT '医院国家编号'")
	private String hospitalNo;

	/**
	 * 医院国家名称
	 */
	@Column(name = "hospital_name", columnDefinition = "varchar(50)  COMMENT '医院国家名称'")
	private String hospitalName;

	/**
	 *  医院等级
	 */
	@ManyToOne(targetEntity = PublicDict.class, optional = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "type", columnDefinition = "varchar(10)  COMMENT '医院等级'")
	private PublicDict type;
	/**
	 * 拼音
	 */
	@Column(name = "pinyin", columnDefinition = "varchar(50)  COMMENT '拼音'")
	private String pinyin;

	/**
	 * 创建时间
	 */
	@Column(name = "create_time", columnDefinition = "timestamp COMMENT '创建时间' DEFAULT CURRENT_TIMESTAMP ", insertable = false, updatable = false)
	@JSONField(format = "yyyy-MM-dd hh:mm:ss")
	private Timestamp createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHospitalNo() {
		return hospitalNo;
	}

	public void setHospitalNo(String hospitalNo) {
		this.hospitalNo = hospitalNo;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public PublicDict getType() {
		return type;
	}

	public void setType(PublicDict type) {
		this.type = type;
	}

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Hospital [id=" + id + ", hospitalNo=" + hospitalNo + ", hospitalName=" + hospitalName + ", type=" + type
				+ ", pinyin=" + pinyin + ", createTime=" + createTime + "]";
	}
	
	

}
