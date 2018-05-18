package com.lifeng.insurance.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @ClassName: IllegalRecord
 * @Description: TODO(单挑记录违法记录表)
 * @author lifeng
 * @date 2018年5月16日 下午3:14:05
 *
 */
@Entity
@Table(name = "insurance_Illegal_Record")
public class IllegalRecord implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id", columnDefinition = "bigint COMMENT '主键，自动生成'")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/**
	 * 报销费用id
	 */
	@JoinColumn(name = "outp_id", columnDefinition = "varchar(32) COMMENT '报销费用id'")
	@OneToOne
	private OutpMaster outp;

	/**
	 * 违规记录
	 */
	@Column(name = "record", columnDefinition = "text COMMENT '违规记录'")
	private String record;

	
	
	/**
	 * 创建时间
	 */
	@Column(name = "createtime", columnDefinition = "timestamp COMMENT '创建时间' DEFAULT CURRENT_TIMESTAMP ", insertable = false, updatable = false)
	@JSONField(format = "yyyy-MM-dd hh:mm:ss")
	private Timestamp createTime;



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public OutpMaster getOutp() {
		return outp;
	}



	public void setOutp(OutpMaster outp) {
		this.outp = outp;
	}



	public String getRecord() {
		return record;
	}



	public void setRecord(String record) {
		this.record = record;
	}



	public Timestamp getCreateTime() {
		return createTime;
	}



	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	
	
}
