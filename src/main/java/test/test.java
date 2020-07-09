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
		QueryInformationServices serviceimpl=(QueryInformationServices) ac.getBean("queryInformationServices");
	//	CompetitionDao competitionDao=(CompetitionDao)ac.getBean("competitionDao");
		HashMap<String, Object> hsp=new HashMap<String, Object>();
		
		//hsp.put("auditeason", "³É¹¦");
		hsp.put("limit",3);
		hsp.put("page",1);
		hsp.put("userId", "1002");
		//String memberIds[]= {"1123388775","1374939313"};
		//String memberId=JSON.toJSONString(memberIds);
		
		//hsp.put("competitionId", "0");
		//System.out.println(memberId.toString());
		//hsp.put("memberId",JSON.toJSONString(memberIds));
		//hsp.put("teamId", "1949471594");
		//System.out.println(competitionDao.queryCompetitionType("0"));
		System.out.println(serviceimpl.queryMyJoinCompetition(hsp));
	
	}

}
