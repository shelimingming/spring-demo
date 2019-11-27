package com.sheliming.spring.demo.ioc_anno;

import com.sheliming.spring.demo.ioc_anno.configuration.SpringConfiguration;
import com.sheliming.spring.demo.ioc_anno.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class TestSpringIoC {

	@Test
	public void test1() {
		// 创建纯注解方式的spring容器
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		
		//从容器中获取Bean的实例
		UserService service = context.getBean(UserService.class);
		service.saveUser();
		
		UserService service2 = (UserService) context.getBean("userService");
		service2.saveUser();
	}
}
