package com.sheliming.spring.demo.ioc_xml;


import com.sheliming.spring.demo.ioc_xml.beans.Student;
import com.sheliming.spring.demo.ioc_xml.service.BaseService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("spring_ioc.xml");
		BaseService serviceObj = (BaseService) factory.getBean("isomeService");
		System.out.println(serviceObj.doSome());


		Student student = (Student) factory.getBean("student");

	}

}
