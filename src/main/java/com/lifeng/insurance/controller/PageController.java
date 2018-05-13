package com.lifeng.insurance.controller;


import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lifeng.insurance.model.TestUser;
/**
 * 
* @ClassName: PageController 
* @Description: TODO(跳转控制) 
* @author lifeng
* @date 2018年5月13日 上午10:44:18 
*
 */
@Controller
@RequestMapping("insurance")
public class PageController {

	@RequestMapping("/test")
    @ResponseBody
    public TestUser helloworld() {
		TestUser user=new TestUser();
		user.setUserName("魏攀");
		user.setUserNick("asdasdasd");
		user.setPassWord("timo");
        return user;
    }
	
	@RequestMapping("/login")
    public String hello(Map<String,Object> map) {
        map.put("msg", "Hello Thymeleaf");
        return "login";
    }
	@RequestMapping("/index")
    public String index(HttpServletResponse response,HttpServletRequest request) throws IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("admin")==null){
			response.sendRedirect("/insurance/login");
		}
        return "index";
    }
	@RequestMapping("/manager")
    public String manager(HttpServletResponse response,HttpServletRequest request) throws IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("admin")==null){
			response.sendRedirect("/insurance/login");
		}
        return "manager";
    }
	@RequestMapping("/to{address}")
	public String toAddress(@PathVariable String address) {
		
		return address;
	}
	
}


