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
import service.ManagementTeamInterface;
import service.impl.ManagementTeamService;
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
		ManagementTeamInterface serviceimpl=(ManagementTeamInterface) ac.getBean("managementTeamService");
	//	CompetitionDao competitionDao=(CompetitionDao)ac.getBean("competitionDao");
		HashMap<String, Object> hsp=new HashMap<String, Object>();
		
		//hsp.put("auditeason", "³É¹¦");
	//	hsp.put("limit",3);
	//	hsp.put("page",1);
		String memberId[]= {"1123388775","1374939313"};
		//hsp.put("competitionId", "0");
		hsp.put("memberId",memberId);
		hsp.put("teamId", "1949471594");
		//System.out.println(competitionDao.queryCompetitionType("0"));
		System.out.println(serviceimpl.inviteMembers(hsp));
	
	}

}
