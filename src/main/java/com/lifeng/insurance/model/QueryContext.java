package com.lifeng.insurance.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @ClassName: QueryContext
 * @Description: TODO(违规数据查询条件)
 * @author lifeng
 * @date 2018年5月16日 下午10:40:44
 *
 */
public class QueryContext extends Page {

	// 开始时间
	private String startTime = "2001-01-01";
	// 结束时间
	private String endTime;
	// 医院编号
	private String hospitalId = "";
	// 姓名
	private String name = "";
	// 社保卡号
	private String idCard = "";

	public QueryContext() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // 设置当前日期
		c.add(Calendar.DATE, 1); // 日期分钟加1,Calendar.DATE(天),Calendar.HOUR(小时)
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		this.endTime = format.format(c.getTime());
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

}
