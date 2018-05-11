package com.lifeng.insurance.service.impl;


import java.util.Arrays;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.lifeng.insurance.dao.DiseaseGenderRepository;
import com.lifeng.insurance.model.DiseaseGender;
import com.lifeng.insurance.model.PageReturn;
import com.lifeng.insurance.service.DiseaseGenderService;

@Service
public class DiseaseGenderServiceImpl implements DiseaseGenderService{

	//疾病性别等级限制dao
	@Autowired
	private DiseaseGenderRepository genderDao;
	
	@Override
	public PageReturn getAll(Pageable pageable) {
		Page<DiseaseGender> results = genderDao.findAll(pageable);
		System.out.println(results.getContent());
		return PageReturn.instance((int)results.getTotalElements(), results.getContent());
	}

	@Override
	public int insert(DiseaseGender gender) {
		genderDao.save(gender);
		return 1;
	}

	@Override
	public DiseaseGender getOne(Integer id) {
		Optional<DiseaseGender> results = genderDao.findById(id);
		return results.get();
	}

	@Override
	public int del(String ids) {
		String[] split = ids.split(",");	
		return genderDao.deleteIds(Arrays.asList(split));
	}

}
