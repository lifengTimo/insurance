package com.lifeng.insurance.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import com.lifeng.insurance.dao.AdminRepository;
import com.lifeng.insurance.model.Admin;
import com.lifeng.insurance.model.PageReturn;
import com.lifeng.insurance.service.AdminService;
import com.lifeng.insurance.util.Encryption;

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
	@Override
	public boolean addAmin(Admin admin) {
		try {
			admin.setPassword(Encryption.getMD5x32(admin.getPassword()));
			Admin result = adminRepository.save(admin);
			if(result==null) {
				return false;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public Admin getAdminById(int id) {
		Optional<Admin> result = adminRepository.findById(id);
		return result.get();
	}
	@Override
	public int updateAdmin(Admin admin) {
		Admin oldAdmin = adminRepository.findById(admin.getId()).get();
		if(oldAdmin==null) {
			return 0;
		}
		if(admin.getPassword()!=null) {
			if(!admin.getPassword().equals("")) {
				 admin.setPassword(Encryption.getMD5x32(admin.getPassword()));
			}else {
				admin.setPassword(oldAdmin.getPassword());
			}
			
		}else {
			admin.setPassword(oldAdmin.getPassword());
		}
		adminRepository.saveAndFlush(admin);
		return 1;
		
		
	}
	@Override
	public int deleteAmins(String ids) {
		String[] split = ids.split(",");
		List<String> list=Arrays.asList(split);
		int result = adminRepository.deleteIds(list);
		return result;
	}

}
