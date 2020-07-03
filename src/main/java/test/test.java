	package test;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.UserDao;
import entity.User;
import service.impl.ModifyInformationService;
import service.impl.QueryInformationServices;

public class test {

	
	
	@Test
	public void test1() {
		//System.out.println(1111);
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		QueryInformationServices serviceimpl=(QueryInformationServices)ac.getBean("queryInformationServices");
	
		HashMap<String, Object> u=new HashMap<String, Object>();
		u.put("limit", 10);
		u.put("page", 1);
		u.put("value", "ACM");
		System.out.println(serviceimpl.queryCompetitionVague(u));
		
		
		
		
	}

}
