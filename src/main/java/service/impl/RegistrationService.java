package service.impl;


import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import dao.CompetitionDao;
import dao.RegistrationDao;
import entity.Registration;
import service.RegistrationInterface;
import util.ConstantValueUtil;
import util.RandIdUtil;
import util.TimeUtil;
@Service
public class RegistrationService implements RegistrationInterface{

	@Resource
	private RegistrationDao registrationDao;
	@Resource
	private CompetitionDao competitionDao;
	@Override
	public String registration(HashMap<String, Object> rg) {
		// TODO Auto-generated method stub
		HashMap<String, Object> msg=new HashMap<String, Object>();
		Registration registration=new Registration();
		registration.setApplicantId((String)rg.get("applicantId").toString());
		registration.setCompetitionId((String)rg.get("competitionId").toString());
		registration.setRegistrationId(RandIdUtil.rangId());
		registration.setRegistrationTime(TimeUtil.getTime());
		int checkUser=Integer.parseInt((String)rg.get("checkUser").toString());
		if(competitionDao.queryIsJoinCompetition(rg)>0)
		{
			msg.put("msg", "报名失败,您已报名");
			msg.put("flag", false);
			return JSON.toJSONString(msg);
		}else
		{
		if(checkUser==ConstantValueUtil.check)
		{
			registration.setState(ConstantValueUtil.Registration_waitState);
		}else
		{
			registration.setState(ConstantValueUtil.Registration_successState);
		}
		if(registrationDao.insertRegistration(registration)>0)
		{
			if(checkUser==ConstantValueUtil.check)
			{
				msg.put("msg", "报名成功，等待主办方审核");
			}else
			{
				msg.put("msg", "报名成功");
			}
			msg.put("flag", true);
			return JSON.toJSONString(msg);
		}else
		{
			msg.put("msg", "报名失败");
			msg.put("flag", false);
			return JSON.toJSONString(msg);
		}
		}
	}

	@Override
	public String examine(Registration registration) {
		// TODO Auto-generated method stub
		HashMap<String, Object> msg=new HashMap<String, Object>();
		if(registrationDao.modifyRegistration(registration)>0)
		{
			msg.put("msg", "操作成功");
			msg.put("flag", true);
			return JSON.toJSONString(msg);
		}else
		{
			msg.put("msg", "操作失败");
			msg.put("flag", false);
			return JSON.toJSONString(msg);
		}
		
	}

}
