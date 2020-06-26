package service.impl;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import dao.CompetitionDao;
import dao.UserDao;
import entity.Competition;
import entity.User;
import service.ModifyInformationInterface;
@Service
public class ModifyInformationService  implements ModifyInformationInterface{

	@Resource
	private CompetitionDao competitionDao;
	@Resource
	private  UserDao userDao;
	@Override
	public String modifyCompetition(Competition competition) {
		// TODO Auto-generated method stub
		HashMap<String, Object> msg=new HashMap<String, Object>();
		if(competitionDao.modifyCompetition(competition)>0)
		{	
			msg.put("msg", "修改成功");
			msg.put("flag", true);
			return JSON.toJSONString(msg);
			
		}else
		{	
			msg.put("msg", "修改失败");
			msg.put("flag", false);
			return JSON.toJSONString(msg);
			
		}
	}

	@Override
	public String modifyUser(User u) {
		// TODO Auto-generated method stub
		HashMap<String, Object> msg=new HashMap<String, Object>();
		if(userDao.modifyUser(u)>0)
		{	
			msg.put("msg", "修改成功");
			msg.put("flag", true);
			return JSON.toJSONString(msg);
			
		}else
		{	
			msg.put("msg", "修改失败");
			msg.put("flag", false);
			return JSON.toJSONString(msg);
			
		}
	}

}
