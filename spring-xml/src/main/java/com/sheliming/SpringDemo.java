package com.sheliming;

import com.sheliming.domain.Student;
import com.sheliming.service.HelloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo {
    public static void main(String[] args) {
        ApplicationContext factory = new ClassPathXmlApplicationContext("spring.xml");

        HelloService helloService = (HelloService) factory.getBean("helloService");
        System.out.println(helloService.sayHello());


        Student student = (Student) factory.getBean("student");
        System.out.println(student);
    }
}
