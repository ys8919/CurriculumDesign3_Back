	package test;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.UserDao;
import entity.Registration;
import entity.User;
import service.impl.ModifyInformationService;
import service.impl.QueryInformationServices;
import service.impl.RegistrationService;
import service.impl.ReleaseCompetitionService;
import util.ConstantValueUtil;
import util.RandIdUtil;
import util.TimeUtil;

public class test {

	
	
	@Test
	public void test1() {
		//System.out.println(1111);
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		ReleaseCompetitionService serviceimpl=(ReleaseCompetitionService)ac.getBean("releaseCompetitionService");
	
		HashMap<String, Object> hsp=new HashMap<String, Object>();
		//hsp.put("auditeason", "³É¹¦");
		hsp.put("competitionId","1093982643");
		hsp.put("state","2");
		
		//u.put("value", "A");
		System.out.println(serviceimpl.examine(hsp));
	}

}
