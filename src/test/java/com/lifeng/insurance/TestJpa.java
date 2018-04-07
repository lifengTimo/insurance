package com.lifeng.insurance;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lifeng.insurance.dao.AdminRepository;
import com.lifeng.insurance.model.Admin;
import com.lifeng.insurance.service.AdminService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = InsuranceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class TestJpa {
	@Autowired
	private AdminService adminService;
	
	@Test
	public void TestExample(){
		Admin admin=new Admin();
		admin.setId(1002);
		admin.setPassword("e10adc3949ba59abbe56e057f20f883e");
		System.out.println("测试结果:"+ adminService.existAdmin(admin));
	}
}
