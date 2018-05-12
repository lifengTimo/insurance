package com.lifeng.insurance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.lifeng.insurance.dao.PublicDictRepository;
import com.lifeng.insurance.model.PublicDict;
import com.lifeng.insurance.service.PublicDictService;
/**
 * 
* @ClassName: PublicDictServiceImpl 
* @Description: TODO(公共字典service) 
* @author lifeng
* @date 2018年5月12日 下午8:53:07 
*
 */
@Service
public class PublicDictServiceImpl implements PublicDictService {

	//字典dao
	@Autowired
	private PublicDictRepository dictDao;
	
	@Override
	public List<PublicDict> getAllByType(String type) {
		PublicDict example=new PublicDict();
		example.setDictCode(type);
		Sort sort = new Sort(Sort.Direction.ASC, "sort");   
		List<PublicDict> list = dictDao.findAll(Example.of(example), sort);
		return list;
	}

}
