package com.lifeng.insurance;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.junit4.SpringRunner;

import com.lifeng.insurance.dao.AdminRepository;
import com.lifeng.insurance.dao.DrugRepository;
import com.lifeng.insurance.dao.PublicDictRepository;
import com.lifeng.insurance.model.Admin;
import com.lifeng.insurance.model.Nav;
import com.lifeng.insurance.model.PublicDict;
import com.lifeng.insurance.service.AdminService;
import com.lifeng.insurance.service.NavService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = InsuranceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class TestJpa {
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private NavService navService;
	
	@Autowired
	private DrugRepository drugDao;
	
	
	@Autowired
	private PublicDictRepository dictDao;
	
	//@Test
	public void TestExample(){
		Admin admin=new Admin();
		admin.setId(1002);
		admin.setPassword("e10adc3949ba59abbe56e057f20f883e");
		System.out.println("测试结果:"+ adminService.existAdmin(admin));
	}
	
	//@Test
	public void TestExample11(){
		List<Nav> list = navService.selectAllNav("0");
		System.out.println(list);
	}
	
	@Test
	public void TestAminAdd() {
		Admin admin=new Admin();
		admin.setUserName("admin");
		admin.setPassword("123456");
		admin.setId(1001);
		System.out.println("用户增加： "+adminService.addAmin(admin));
	}
	
	@Test
	public void TestAminAget() {
		System.out.println("134132");
		System.out.println("用户查找： "+adminService.getAdminById(1001));
	}
	@Test
	public void TestAminUpdate() {
		Admin admin=new Admin();
		admin.setId(1002);
		admin.setPassword("12341234");
		admin.setUserName("testAdmin1232");
		System.out.println("结果为:"+adminService.updateAdmin(admin));
	}
	@Test
	public void TestAdminDetele() {
		String ids="1026,1025";
		int deleteAmins = adminService.deleteAmins(ids);
		System.out.println("受影响的行数："+deleteAmins);
	}
	
	@Test
	public void getAllDrug() {
		System.out.println(drugDao.getAll("固"));
	}
	
	@Test
	public void getDict() {
		PublicDict dict=new PublicDict();
		dict.setDictCode("SEX_DICT");
		Example<PublicDict> ex=Example.of(dict);
		System.out.println(dictDao.findAll(ex));
	}
}
