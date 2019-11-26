package com.sheliming.spring.demo.ioc;


import com.sheliming.spring.demo.ioc.beans.Student;
import com.sheliming.spring.demo.ioc.service.BaseService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("spring_config.xml");
		BaseService serviceObj = (BaseService) factory.getBean("isomeService");
		System.out.println(serviceObj.doSome());


		Student student = (Student) factory.getBean("student");

	}

}
