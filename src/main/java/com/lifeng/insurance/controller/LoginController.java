package com.lifeng.insurance.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.lifeng.insurance.model.Admin;
import com.lifeng.insurance.model.Page;
import com.lifeng.insurance.model.PageReturn;
import com.lifeng.insurance.model.WrapResult;
import com.lifeng.insurance.service.AdminService;
import com.lifeng.insurance.util.Encryption;
import com.lifeng.insurance.util.QueryTool;


@Controller
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
			return WrapResult.error(new Exception("用户名不能为空,或者密码不能为空!!"));
		}
		admin.setPassword(Encryption.getMD5x32(admin.getPassword()));
		if(adminService.existAdmin(admin)){
			session.setAttribute("admin", admin);
			return WrapResult.ok("1");
		}else{
			return WrapResult.ok("0");
		}
		
	}
	/**
	 * 取消登记
	 * @param response
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping("/logout")
	public void logout(HttpServletResponse response,HttpServletRequest request) throws IOException{
		request.getSession().invalidate();
		response.sendRedirect("/insurance/login");
	}
	/**
	 * 根据分页条件获取所有的管理员信息
	 * @param page
	 * @return
	 */
	@RequestMapping("/getAllAdmin")
	@ResponseBody
	public PageReturn getAllAdmin(Page page){
		PageRequest pageRequest=null;
		pageRequest=QueryTool.buildPageRequest(page.getPage()-1, page.getRows());
		return adminService.getAllAmin(pageRequest);
	}
	/**
	 * 插入管理员
	 * @param admin
	 * @return
	 */
	@RequestMapping("/insertAdmin")
	@ResponseBody
	public boolean insertAdmin(Admin admin){
		return adminService.addAmin(admin);
	}
	/**
	 * 通过编号获取管理员信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/getAdmin")
	@ResponseBody
	public Admin insertAdmin(Integer id){
		return adminService.getAdminById(id);
	}
}
