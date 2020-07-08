	package test;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.CompetitionDao;
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
		RegistrationService serviceimpl=(RegistrationService)ac.getBean("registrationService");
		CompetitionDao competitionDao=(CompetitionDao)ac.getBean("competitionDao");
		HashMap<String, Object> hsp=new HashMap<String, Object>();
		
		hsp.put("auditeason", "�ɹ�");
	//	hsp.put("limit",3);
	//	hsp.put("page",1);
		
		hsp.put("competitionId", "0");
		//System.out.println(competitionDao.queryCompetitionType("0"));
		System.out.println(serviceimpl.registration(hsp));
	
	}

}
