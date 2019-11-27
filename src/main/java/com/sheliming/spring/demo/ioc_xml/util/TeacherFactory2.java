package com.sheliming.spring.demo.ioc_xml.util;

import com.sheliming.spring.demo.ioc_xml.beans.Teacher;

public class TeacherFactory2 {
	 public Teacher createTeacher(){
	      Teacher teacher =    new Teacher();
	      teacher.setTname("Mr");
	      System.out.println("TeacherFactory 负责创建 teacher类实例对象..");
	      return teacher;
 }
}
