package com.lifeng.insurance.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lifeng.insurance.dao.DrugBodyLimitRepository;
import com.lifeng.insurance.dao.PublicDictRepository;
import com.lifeng.insurance.model.DrugBodyLimit;
import com.lifeng.insurance.model.PageReturn;
import com.lifeng.insurance.model.PublicDict;
import com.lifeng.insurance.service.DrugBodyLimitService;

@Service
public class DrugBodyLimitServiceImpl implements DrugBodyLimitService {

	
	@Autowired
	private DrugBodyLimitRepository bodyDao;
	//公共字典Dao
	@Autowired
	private PublicDictRepository dictDao;
	
	@Override
	public PageReturn getAll(Pageable pageable) {
		Page<DrugBodyLimit> results = bodyDao.findAll(pageable);
		List<DrugBodyLimit> lists = results.getContent();
		PublicDict dict=new PublicDict();
		dict.setDictCode("AGE_RANGE");
		for(DrugBodyLimit item :lists) {
			dict.setValueCode(item.getBodyLimit());
			Optional<PublicDict> findOne = dictDao.findOne(Example.of(dict));
			item.setBodyLimitName(findOne.get().getValueName());
		}
		return PageReturn.instance((int)results.getTotalElements(), lists);
	}

	@Override
	public int insert(DrugBodyLimit body) {
		DrugBodyLimit save = bodyDao.save(body);
		if(save!=null) {
			return 1;
		}
		return 0;
	}

	@Override
	public DrugBodyLimit getOneById(Integer id) {
		DrugBodyLimit one = bodyDao.getOne(id);
		return one;
	}

	@Override
	public int update(DrugBodyLimit body) {
		DrugBodyLimit old = bodyDao.findById(body.getId()).get();
		old.setBodyLimit(body.getBodyLimit());
		bodyDao.save(old);
		return 1;
	}

	@Override
	public int del(String ids) {
		String[] split = ids.split(",");
		return bodyDao.deleteIds(Arrays.asList(split));
	}

}
