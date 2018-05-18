package com.lifeng.insurance.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lifeng.insurance.dao.IllegalRecordRepository;
import com.lifeng.insurance.dao.IllegalRecordReturn;
import com.lifeng.insurance.model.IllegalRecord;
import com.lifeng.insurance.model.PageReturn;
import com.lifeng.insurance.model.QueryContext;
import com.lifeng.insurance.service.IllegalRecordService;

/**
 * 
 * @ClassName: IllegalRecordServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author lifeng
 * @date 2018年5月16日 下午11:23:35
 *
 */
@Service
public class IllegalRecordServiceImpl implements IllegalRecordService {

	/**
	 * 违规记录dao
	 */
	@Autowired
	private IllegalRecordRepository recordDao;


	@Override
	public PageReturn getAll(Pageable pageable,QueryContext query) {
		Page<IllegalRecordReturn> results = getReturn(query, pageable);
		return PageReturn.instance((int) results.getTotalElements(), results.getContent());
	}
	/**
	 * 
	* @Title: getReturn 
	* @Description: TODO(通过条件，或者分页信息查询) 
	* @param @param query
	* @param @param pageable
	* @param @return  参数说明 
	* @return Page<IllegalRecordReturn>    返回类型 
	* @throws
	 */
	private Page<IllegalRecordReturn> getReturn(QueryContext query,Pageable pageable){
		
		return recordDao.getAllByI(query.getStartTime(),query.getEndTime(),
				query.getHospitalId(), query.getName(),  query.getIdCard(),pageable);
	}

	@Override
	public IllegalRecord getOne(Integer id) {
		IllegalRecord one = recordDao.findById(id).get();
		return one;
	}

}
