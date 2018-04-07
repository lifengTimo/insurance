package com.lifeng.insurance.controller;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.lifeng.insurance.model.Admin;
import com.lifeng.insurance.model.WrapResult;
import com.lifeng.insurance.service.AdminService;
import com.lifeng.insurance.util.Encryption;


@RestController
@RequestMapping("admin")
public class LoginController {
	
	@Autowired
	private AdminService adminService;
	
	/**
	 * 登录验证
	 * @param admin
	 * @return
	 */
	@RequestMapping("/login")
	@ResponseBody
	public WrapResult login(Admin admin,HttpSession session){
		if(admin==null||admin.getUserName()==null||admin.getPassword()==null){
			return WrapResult.error(new Exception("用户名不能为空,或者密码不能为空"));
		}
		admin.setPassword(Encryption.getMD5x32(admin.getPassword()));
		if(adminService.existAdmin(admin)){
			session.setAttribute("admin", admin);
			return WrapResult.ok("1");
		}else{
			return WrapResult.ok("0");
		}
		
	}

}
