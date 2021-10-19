package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.Student;
import com.service.StudentService;

public class DemoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ApplicationContext ac  = new ClassPathXmlApplicationContext("beans.xml");
Student std = (Student)ac.getBean("student");
std.setSid(10);
std.setName("Dinesh");
std.setAge(32);
StudentService ss = (StudentService)ac.getBean("studentService");
String res = ss.storeStudentInfo(std);
System.out.println(res);
	}

}


