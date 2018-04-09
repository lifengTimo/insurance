package com.lifeng.insurance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;


import com.lifeng.insurance.dao.NavRepository;
import com.lifeng.insurance.model.Nav;
import com.lifeng.insurance.service.NavService;

@Service
public class NavServiceImpl implements NavService {

	@Autowired
	private NavRepository navRepository;
	@Override
	public List<Nav> selectAllNav(String nid) {
		
		Nav nav=new Nav();
		nav.setNid(nid);
		Example<Nav> example=Example.of(nav);
		List<Nav> list = navRepository.findAll(example);
		return list;
	}

}
