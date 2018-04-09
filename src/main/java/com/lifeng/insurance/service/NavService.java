package com.lifeng.insurance.service;

import java.util.List;

import com.lifeng.insurance.model.Nav;

/**
 * 导航栏service
 * @author PA
 *
 */
public interface NavService {
	
	List<Nav> selectAllNav(String nid);

}
