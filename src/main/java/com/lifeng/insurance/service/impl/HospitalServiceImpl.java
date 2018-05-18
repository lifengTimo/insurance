package com.lifeng.insurance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import com.lifeng.insurance.dao.HospitalRepository;
import com.lifeng.insurance.model.Hospital;
import com.lifeng.insurance.service.HospitalService;

@Service
public class HospitalServiceImpl implements HospitalService {

	/**
	 * 医院Dao
	 */
	@Autowired
	private HospitalRepository hospitalDao;

	@Override
	public List<Hospital> getAll(String q) {
		/*Hospital example=new Hospital();
		example.setPinyin(q);
		ExampleMatcher matcher=ExampleMatcher.matching()//构建对象
				.withStringMatcher(StringMatcher.CONTAINING)//改变默认字符串匹配方式：模糊查询
				.withIgnoreCase(true);//改变默认大小写忽略方式：忽略大小写
		
		//创建实例
		Example<Hospital> ex = Example.of(example, matcher);*/
		return hospitalDao.getAllByQ(q);
	}

}
