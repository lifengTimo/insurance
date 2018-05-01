package com.lifeng.insurance.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lifeng.insurance.model.Admin;
import com.lifeng.insurance.model.PageReturn;
/**
 * 管理员操作Service
 * @author PA
 *
 */
public interface AdminService {
	
	boolean existAdmin(Admin admin);
	
	PageReturn getAllAmin(Pageable pageable);
	
	boolean addAmin(Admin admin);
	
	Admin getAdminById(int id);
	/**
	 * 更新admin
	 * @param admin
	 * @return
	 */
	int updateAdmin(Admin admin);
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	int deleteAmins(String ids);

}
