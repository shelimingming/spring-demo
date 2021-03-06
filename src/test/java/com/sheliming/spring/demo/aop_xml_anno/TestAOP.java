package com.sheliming.spring.demo.aop_xml_anno;

import com.sheliming.spring.demo.aop_xml.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring_aop_xml.xml")
public class TestAOP {

	@Autowired
	private UserService userService;
	
	
	@Test
	public void test() {
		userService.saveUser();
		System.out.println("=================");
		userService.saveUser("lisi");
		System.out.println("=================");
		userService.updateUser();
	}
}
