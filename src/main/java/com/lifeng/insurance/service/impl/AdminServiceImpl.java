package com.lifeng.insurance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.lifeng.insurance.dao.AdminRepository;
import com.lifeng.insurance.model.Admin;
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

}
