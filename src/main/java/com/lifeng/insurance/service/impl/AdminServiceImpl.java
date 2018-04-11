package com.lifeng.insurance.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import com.lifeng.insurance.dao.AdminRepository;
import com.lifeng.insurance.model.Admin;
import com.lifeng.insurance.model.PageReturn;
import com.lifeng.insurance.service.AdminService;

/**
 * 
 * @author PA
 *
 */
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;
	@Override
	public boolean existAdmin(Admin admin) {
		Admin result= adminRepository.exitsAdmin(admin.getUserName(), admin.getPassword());
		if(result!=null){
			return true;
		}
		return false;
	}
	@Override
	public PageReturn getAllAmin(Pageable pageable) {
		Page<Admin> results = adminRepository.findAll(pageable);
		List<Admin> list = results.getContent();
		return PageReturn.instance((int)results.getTotalElements(), list);
	}

}
