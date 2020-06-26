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
	 * 发布竞赛*/
	@Override
	public String releaseCompetition(Competition competition) {
		// TODO Auto-generated method stub
		
		HashMap<String, Object> msg=new HashMap<String, Object>();
		competition.setCompetitionId(RandIdUtil.rangId());
		competition.setReleaseTime(TimeUtil.getTime());
		competition.setState(ConstantValueUtil.Competition_waitState);	
		if(competitionDao.insertCompetition(competition)>0)
		{
			msg.put("msg", "发布成功，等待管理员审核");
			msg.put("flag", true);
			return JSON.toJSONString(msg);
		}else
		{
			msg.put("msg", "发布失败，请仔细审查信息");
			msg.put("flag", false);
			return JSON.toJSONString(msg);
		}
		
	}
	/**
	 * 审核竞赛*/
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
