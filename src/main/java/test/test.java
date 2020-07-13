	package test;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;

import dao.CompetitionDao;
import dao.UserDao;
import entity.Registration;
import entity.User;
import service.ManagementTeamInterface;
import service.RegistrationInterface;
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
		RegistrationInterface serviceimpl=(RegistrationInterface) ac.getBean("registrationService");
	//	CompetitionDao competitionDao=(CompetitionDao)ac.getBean("competitionDao");
		HashMap<String, Object> hsp=new HashMap<String, Object>();
		Registration registration=new Registration();
		registration.setAuditeason("审核通过");
		registration.setRegistrationId("1606639408");
		registration.setState(1);
		//hsp.put("auditeason", "成功");
		//hsp.put("limit",3);
		//hsp.put("page",1);
		hsp.put("memberId", "1374939313");
		//String memberIds[]= {"1123388775","1374939313"};
		//String memberId=JSON.toJSONString(memberIds);
		
		//hsp.put("competitionId", "0");
		//System.out.println(memberId.toString());
		//hsp.put("memberId",JSON.toJSONString(memberIds));
		//hsp.put("teamId", "1949471594");
		//System.out.println(competitionDao.queryCompetitionType("0"));
		System.out.println(serviceimpl.examine(registration));
	
	}

}
