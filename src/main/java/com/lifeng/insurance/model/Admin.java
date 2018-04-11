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

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import com.alibaba.fastjson.annotation.JSONField;
/**
 * 用户管理员
 * @author PA
 *
 */
@Entity
@Table(name="insurance_admin")
public class Admin  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2937185882834602144L;
	
	@Id
	@Column(name = "id",columnDefinition="bigint COMMENT '主键，自动生成'")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="user_name",columnDefinition="varchar(100) COMMENT '用户姓名'")
	private String userName;
	
	@Column(name="password",columnDefinition="varchar(100) COMMENT '用户密码'")
	private String password;
	
	@Column(name="create_time",columnDefinition="timestamp COMMENT '创建时间'",insertable=false, updatable=false)
	@Generated(GenerationTime.INSERT)
	@JSONField(format="yyyy-MM-dd hh:mm:ss")
	private  Timestamp createTime;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}
