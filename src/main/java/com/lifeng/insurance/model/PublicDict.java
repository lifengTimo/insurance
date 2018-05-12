package com.lifeng.insurance.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
* @ClassName: PublicDict 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author lifeng
* @date 2018年5月9日 下午8:48:15 
*
 */
@Entity
@Table(name="public_dict")
public class PublicDict implements Serializable {

	/** 
	* @Fields serialVersionUID : TODO(序列号) 
	*/ 
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id",columnDefinition="bigint COMMENT '主键，自动生成'")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	//字典名称编码
	@Column(name="dict_Code",columnDefinition="varchar(20) COMMENT '字典名称编码'")
	private String dictCode;
	//字典名称
	@Column(name="dict_Name",columnDefinition="varchar(60) COMMENT '字典名称'")
	private String dictName;
	//字典表对应的id编码
	@Column(name="value_Code",columnDefinition="varchar(4) COMMENT '字典表对应的id编码'")
	private String valueCode;
	//字典表对应的id名称
	@Column(name="value_Name",columnDefinition="varchar(40) COMMENT '字典表对应的id编码'")
	private String valueName;
	//字典表对应的id拼音
	@Column(name="pingyin",columnDefinition="varchar(10) COMMENT '字典表对应的id编码'")
	private String pinyin;
	//排序规则
	@Column(name="sort",columnDefinition="varchar(10) COMMENT '排序规则'")
	private String sort;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDictCode() {
		return dictCode;
	}
	public void setDictCode(String dictCode) {
		this.dictCode = dictCode;
	}
	public String getDictName() {
		return dictName;
	}
	public void setDictName(String dictName) {
		this.dictName = dictName;
	}
	public String getValueCode() {
		return valueCode;
	}
	public void setValueCode(String valueCode) {
		this.valueCode = valueCode;
	}
	public String getValueName() {
		return valueName;
	}
	public void setValueName(String valueName) {
		this.valueName = valueName;
	}
	public String getPinyin() {
		return pinyin;
	}
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	@Override
	public String toString() {
		return "PublicDict [id=" + id + ", dictCode=" + dictCode + ", dictName=" + dictName + ", valueCode=" + valueCode
				+ ", valueName=" + valueName + ", pinyin=" + pinyin + ", sort=" + sort + "]";
	}
	
	
}
