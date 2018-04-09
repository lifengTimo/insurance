package com.lifeng.insurance.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 导航栏
 * @author PA
 *
 */
@Entity
@Table(name="insurance_nav")
public class Nav implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9105123890866932465L;
	@Id
	@Column(name = "id",columnDefinition="bigint COMMENT '主键，自动生成'")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(columnDefinition="varchar(100)  COMMENT '注释'",nullable=false)
	private String text;
	
	@Column(columnDefinition="varchar(10)  COMMENT '导航状态'")
	private String state;
	
	@Column(name="iconCls",columnDefinition="varchar(20)  COMMENT '导航图标'")
	private String iconCls;
	
	@Column(columnDefinition="varchar(50)  COMMENT '导航链接'")
	private String url;
	
	@Column(columnDefinition="varchar(10)  COMMENT '导航节点 ' default 0")
	private String nid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}


	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNid() {
		return nid;
	}

	public void setNid(String nid) {
		this.nid = nid;
	}

	@Override
	public String toString() {
		return "Nav [id=" + id + ", text=" + text + ", state=" + state + ", iconCls=" + iconCls + ", url=" + url
				+ ", nid=" + nid + "]";
	}


	
}
