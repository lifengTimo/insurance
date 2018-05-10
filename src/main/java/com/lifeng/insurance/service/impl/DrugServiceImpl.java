package com.lifeng.insurance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lifeng.insurance.dao.DrugRepository;
import com.lifeng.insurance.model.Drug;
import com.lifeng.insurance.service.DrugService;

@Service
public class DrugServiceImpl implements DrugService {

	@Autowired
	private DrugRepository drugRepository;
	
	@Override
	public List<Drug> getAll(String q) {
		
		if(q==null) q="";
		return drugRepository.getAll(q);
	}

}
