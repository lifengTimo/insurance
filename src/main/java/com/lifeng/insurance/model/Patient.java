package com.lifeng.insurance.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import com.alibaba.fastjson.annotation.JSONField;
/**
 * 
* @ClassName: Patient 
* @Description: TODO(病人Dao) 
* @author lifeng
* @date 2018年5月13日 上午10:18:30 
*
 */
@Entity
@Table(name="patient")
public class Patient implements Serializable{

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id",columnDefinition="bigint COMMENT '主键，自动生成'")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	//证件号码（身份证号码）
	@Column(name="id_no",columnDefinition="varchar(32)  COMMENT '证件号码（身份证号码）'",unique=true)
	private String idNo;
	//姓名
	@Column(columnDefinition="varchar(32)  COMMENT '姓名'")
	private String name;
	//生日日期
	@Column(name="birthday",columnDefinition="date  COMMENT '生日日期'")
	private Date birthday;
	
	//性别
	@JoinColumn(name="sex",columnDefinition="varchar(10) COMMENT '性别'")
	@ManyToOne(optional=true,cascade=CascadeType.MERGE)
	private PublicDict sex;
	//地址
	@Column(name="address",columnDefinition="varchar(255)  COMMENT '地址'")
	private String address;
	
	//电话号码
	@Column(name="phone",columnDefinition="varchar(32) COMMENT '电话号码'")
	private String phone;
	//年龄
	@Transient
	private int age;
	
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

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public PublicDict getSex() {
		return sex;
	}

	public void setSex(PublicDict sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
