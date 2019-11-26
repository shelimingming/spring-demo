package com.sheliming.spring.demo.ioc.util;

import com.sheliming.spring.demo.ioc.beans.Teacher;

public class TeacherFactory2 {
	 public Teacher createTeacher(){
	      Teacher teacher =    new Teacher();
	      teacher.setTname("Mr");
	      System.out.println("TeacherFactory 负责创建 teacher类实例对象..");
	      return teacher;
 }
}
