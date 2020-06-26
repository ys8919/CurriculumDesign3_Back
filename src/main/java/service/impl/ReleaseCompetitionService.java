package service.impl;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import dao.CompetitionDao;
import dao.UserDao;
import entity.Competition;
import entity.User;
import service.ReleaseCompetitionInterface;
import util.ConstantValueUtil;
import util.RandIdUtil;
import util.TimeUtil;
@Service
public class ReleaseCompetitionService implements ReleaseCompetitionInterface{

	@Resource
	private CompetitionDao competitionDao;
	@Resource
	private UserDao userDao;
	/**
	 * ��������*/
	@Override
	public String releaseCompetition(Competition competition) {
		// TODO Auto-generated method stub
		
		HashMap<String, Object> msg=new HashMap<String, Object>();
		competition.setCompetitionId(RandIdUtil.rangId());
		competition.setReleaseTime(TimeUtil.getTime());
		competition.setState(ConstantValueUtil.Competition_waitState);	
		if(competitionDao.insertCompetition(competition)>0)
		{
			msg.put("msg", "�����ɹ����ȴ�����Ա���");
			msg.put("flag", true);
			return JSON.toJSONString(msg);
		}else
		{
			msg.put("msg", "����ʧ�ܣ�����ϸ�����Ϣ");
			msg.put("flag", false);
			return JSON.toJSONString(msg);
		}
		
	}
	/**
	 * ��˾���*/
	@Override
	public String examine(HashMap<String, Object> hasmap) {
		// TODO Auto-generated method stub
		
		HashMap<String, Object> msg=new HashMap<String, Object>();
		Competition competition=new Competition();
		competition.setAuditeason((String)hasmap.get("auditeason"));
		int state =Integer.parseInt((String)hasmap.get("state").toString());
		competition.setState(state);
		if(competitionDao.modifyCompetition(competition)>0)
		{
			msg.put("msg", "�����ɹ�");
			msg.put("flag", true);
			return JSON.toJSONString(msg);
		}else
		{
			msg.put("msg", "����ʧ��");
			msg.put("flag", false);
			return JSON.toJSONString(msg);
		}
	}
		

}
