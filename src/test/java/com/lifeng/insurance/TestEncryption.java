package com.lifeng.insurance;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.lifeng.insurance.util.Encryption;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = InsuranceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class TestEncryption {

	@Test
	public void TestMd5(){
		String pwd="123456";
		System.out.println(Encryption.getSHA1(pwd));
	}
}
