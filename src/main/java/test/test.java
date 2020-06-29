package test;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.UserDao;
import entity.User;
import service.impl.QueryInformationServices;

public class test {

	
	
	@Test
	public void test1() {
		//System.out.println(1111);
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		QueryInformationServices serviceimpl=(QueryInformationServices)ac.getBean("queryInformationServices");
	
		User u=new User();
		u.setUserId("1001");
		System.out.println(serviceimpl.queryUserMyself(u));
		//ArrayList<User> userlist=userdao.queryUser(u);
		//System.out.println("==================="+userlist.get(0).toString()+"============");
		
		
		
	}

}
