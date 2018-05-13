package com.lifeng.insurance.service.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lifeng.insurance.dao.DrugDayRepository;
import com.lifeng.insurance.model.DrugDay;
import com.lifeng.insurance.model.PageReturn;
import com.lifeng.insurance.service.DrugDayService;
/**
 * 
* @ClassName: DrugDayServiceImpl 
* @Description: TODO(药品拿药天数限制Service实现) 
* @author lifeng
* @date 2018年5月11日 下午5:39:53 
*
 */
@Service
public class DrugDayServiceImpl implements DrugDayService {

	/**
	 * 药品天数限制Dao
	 */
	@Autowired
	private DrugDayRepository dayDao;
	
	@Override
	public PageReturn getAll(Pageable pageable) {
		Page<DrugDay> findAll = dayDao.findAll(pageable);
		return PageReturn.instance((int)findAll.getTotalElements(), findAll.getContent());
	}

	@Override
	public int insert(DrugDay day) {
		if(day.getId()!=null) {
			DrugDay oldDay=dayDao.getOne(day.getId());
			oldDay.setDay(day.getDay());
			day=oldDay;
		}
		DrugDay save = dayDao.save(day);
		if(save==null) {
			return 0;
		}
		return 1;
	}

	@Override
	public DrugDay getOne(Integer id) {
		
		return dayDao.findById(id).get();
	}

	@Override
	public int del(String ids) {
		String[] split = ids.split(",");
		return dayDao.delIds(Arrays.asList(split));
	}

}
