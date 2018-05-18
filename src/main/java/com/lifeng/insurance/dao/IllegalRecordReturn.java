package com.lifeng.insurance.dao;

import java.util.Date;
/**
 * 
* @ClassName: IllegalRecordReturn 
* @Description: TODO(查询违规记录返回值) 
* @author lifeng
* @date 2018年5月17日 上午11:10:59 
*
 */
public interface IllegalRecordReturn {
	
	String getId();
	String getName();
	String getHospitalName();
	String getRecord();
	Date getCreateTime();

}
