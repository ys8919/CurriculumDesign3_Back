package service.impl;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.swing.plaf.basic.BasicScrollPaneUI.HSBChangeListener;

import org.junit.Test;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import dao.CompetitionDao;
import dao.RegistrationDao;
import dao.UserDao;
import entity.Competition;
import entity.Registration;
import entity.User;
import service.QueryInformationInterface;

@Service
public class QueryInformationServices implements QueryInformationInterface{
	@Resource
	private CompetitionDao competitionDao;
	@Resource
	private UserDao userDao;
	@Resource
	private RegistrationDao registrationDao;
	@Override
	public String queryCompetition(HashMap<String, Object> value) {
		// TODO Auto-generated method stub
		
		if(value.containsKey("limit")&&value.containsKey("page"))
		{
			int limit=Integer.parseInt((String)value.get("limit").toString());
			int page=Integer.parseInt((String)value.get("page").toString());
			PageHelper.startPage(page,limit);
			ArrayList<Competition> competitions=competitionDao.queryCompetition(value);
			PageInfo<Competition> pageinfo=new PageInfo<Competition>(competitions);
			HashMap<String,Object> msg=new HashMap<String, Object>();
			msg.put("code", 0);
			msg.put("msg", "");
			msg.put("count",pageinfo.getTotal());
			msg.put("data",pageinfo.getList());
			return JSON.toJSONString(msg);
		}else
		{
			HashMap<String,Object> msg=new HashMap<String, Object>();
			ArrayList<Competition> competitions=competitionDao.queryCompetition(value);
			if(competitions.size()<=0)
			msg.put("msg", "无数据");
			msg.put("data",competitions);
			return JSON.toJSONString(msg);
		}
		
		
		
		
	}
	@Override
	public String queryCompetitionVague(HashMap<String, Object> value) {
		// TODO Auto-generated method stub
		
		
		if(value.containsKey("limit")&&value.containsKey("page")) {
		int limit=Integer.parseInt((String)value.get("limit").toString());
		int page=Integer.parseInt((String)value.get("page").toString());
		PageHelper.startPage(page,limit);
		ArrayList<Competition> competitions=competitionDao.fuzzyQuery(value);
		HashMap<String,Object> msg=new HashMap<String, Object>();
		PageInfo<Competition> pageinfo=new PageInfo<Competition>(competitions);
		msg.put("count",pageinfo.getTotal());
		msg.put("data",pageinfo.getList());
		msg.put("code", 0);
		msg.put("msg", "");
		return JSON.toJSONString(msg);
		}else
		{
			ArrayList<Competition> competitions=competitionDao.fuzzyQuery(value);
			HashMap<String,Object> msg=new HashMap<String, Object>();
			msg.put("count",competitions.size());
			msg.put("data",competitions);
			msg.put("code", 0);
			msg.put("msg", "");
			return JSON.toJSONString(msg);
		}
		
		
		
		
		
	}
	@Override
	public String queryUser(HashMap<String, Object> u) {
		// TODO Auto-generated method stub
		if(u.containsKey("limit")&&u.containsKey("page"))
		{
			int limit=Integer.parseInt((String)u.get("limit").toString());
			int page=Integer.parseInt((String)u.get("page").toString());
			PageHelper.startPage(page,limit);
			ArrayList<User> users=userDao.queryUser(u);
			PageInfo<User> pageinfo=new PageInfo<User>(users);
			HashMap<String,Object> msg=new HashMap<String, Object>();
			msg.put("code", 0);
			msg.put("msg", "");
			msg.put("count",pageinfo.getTotal());
			msg.put("data",pageinfo.getList());
			return JSON.toJSONString(msg);
		}else
		{
			HashMap<String,Object> msg=new HashMap<String, Object>();
			ArrayList<User> users=userDao.queryUser(u);
			if(users.size()<=0)
			msg.put("msg", "无数据");
			msg.put("data",users);
			return JSON.toJSONString(msg);
		}
	}
	@Override
	public String fuzzyQueryUser(HashMap<String, Object> u) {
		// TODO Auto-generated method stub
		
		if(u.containsKey("limit")&&u.containsKey("page"))
		{
			int limit=Integer.parseInt((String)u.get("limit").toString());
			int page=Integer.parseInt((String)u.get("page").toString());
			PageHelper.startPage(page,limit);
			HashMap<String,Object> msg=new HashMap<String, Object>();
			ArrayList<User> users=userDao.fuzzyQueryUser(u);
			PageInfo<User> pageinfo=new PageInfo<User>(users);
			msg.put("count",pageinfo.getTotal());
			msg.put("data",pageinfo.getList());
			msg.put("code", 0);
			msg.put("msg", "");
			return JSON.toJSONString(msg);
		}else
		{
			HashMap<String,Object> msg=new HashMap<String, Object>();
			ArrayList<User> users=userDao.fuzzyQueryUser(u);
			msg.put("count",users.size());
			msg.put("data",users);
			msg.put("code", 0);
			msg.put("msg", "");
			return JSON.toJSONString(msg);
		}
		
		
		
	
		
	}
	@Override
	public String queryRegistration(HashMap<String, Object> r) {
		// TODO Auto-generated method stub
		
		
		if(r.containsKey("limit")&&r.containsKey("page"))
		{
			if(competitionDao.queryCompetitionType((String)r.get("competitionId"))!=null)
				
				{
					r.put("type", competitionDao.queryCompetitionType((String)r.get("competitionId")));
				
				}else
				{
					r.put("type",0);
				}
		int limit=Integer.parseInt((String)r.get("limit").toString());
		int page=Integer.parseInt((String)r.get("page").toString());
		PageHelper.startPage(page,limit);
		ArrayList<Registration> rgis=registrationDao.queryRegistration(r);
		HashMap<String,Object> msg=new HashMap<String, Object>();
		PageInfo<Registration> pageinfo=new PageInfo<Registration>(rgis);
		msg.put("count",pageinfo.getTotal());
		msg.put("data",pageinfo.getList());
		msg.put("code", 0);
		msg.put("msg", "");
		
		return JSON.toJSONString(msg);
		}else
		{
			ArrayList<Registration> rgis=registrationDao.queryRegistration(r);
			HashMap<String,Object> msg=new HashMap<String, Object>();
			msg.put("count",rgis.size());
			msg.put("data",rgis);
			msg.put("code", 0);
			msg.put("msg", "");
			
			return JSON.toJSONString(msg);
		}
		
		
	}
	@Override
	public String queryUserMyself(User u) {
		// TODO Auto-generated method stub
		HashMap<String,Object> msg=new HashMap<String, Object>();
		User user=userDao.queryMyself(u);
		if(user.getTel()==null)
		{
			user.setTel("");
		}
		if(user.getEmail()==null)
		{
			user.setEmail("");
		}
		msg.put("msg", "");
		msg.put("data",user);
		return JSON.toJSONString(msg);
	}
	@Override
	public String queryPublisher(HashMap<String, Object> u) {
		// TODO Auto-generated method stub
		
		
		
	
		if(u.containsKey("limit")&&u.containsKey("page")) {
		
			int limit=Integer.parseInt((String)u.get("limit").toString());
			int page=Integer.parseInt((String)u.get("page").toString());
			PageHelper.startPage(page,limit);
			ArrayList<User> users=userDao.queryPublish();
			
			HashMap<String,Object> msg=new HashMap<String, Object>();
			PageInfo<User> pageinfo=new PageInfo<User>(users);
			msg.put("count",pageinfo.getTotal());
			msg.put("data",pageinfo.getList());
			msg.put("code", 0);
			msg.put("msg", "");	
			return JSON.toJSONString(msg);
			}
			else
			{
				ArrayList<User> users=userDao.queryPublish();
				HashMap<String,Object> msg=new HashMap<String, Object>();
				msg.put("count",users.size());
				msg.put("data",users);
				msg.put("code", 0);
				msg.put("msg", "");	
				return JSON.toJSONString(msg);
			}	
	
	}
	@Override
	public String fuzzyQueryByState(HashMap<String, Object> value) {
		// TODO Auto-generated method stub
		
		
		if(value.containsKey("limit")&&value.containsKey("page"))
		{
		
		int limit=Integer.parseInt((String)value.get("limit").toString());
		int page=Integer.parseInt((String)value.get("page").toString());
		
		PageHelper.startPage(page,limit);

		ArrayList<Competition> competitions=competitionDao.fuzzyQueryByState(value);
		
		HashMap<String,Object> msg=new HashMap<String, Object>();
		PageInfo<Competition> pageinfo=new PageInfo<Competition>(competitions);
		msg.put("count",pageinfo.getTotal());
		msg.put("data",pageinfo.getList());
		msg.put("code", 0);
		msg.put("msg", "");
		return JSON.toJSONString(msg);
		}
		else
		{
			ArrayList<Competition> competitions=competitionDao.fuzzyQueryByState(value);
			
			HashMap<String,Object> msg=new HashMap<String, Object>();
			msg.put("count",competitions.size());
			msg.put("data",competitions);
			msg.put("code", 0);
			msg.put("msg", "");
			return JSON.toJSONString(msg);
		}	
	
	}
	@Override
	public String queryMyJoinCompetition(HashMap<String, Object> u) {
		// TODO Auto-generated method stub
		
		if(u.containsKey("limit")&&u.containsKey("page")) {
		int limit=Integer.parseInt((String)u.get("limit").toString());
		int page=Integer.parseInt((String)u.get("page").toString());
		PageHelper.startPage(page,limit);
		HashMap<String,Object> msg=new HashMap<String, Object>();
		ArrayList<Competition> competitions=competitionDao.queryMyJoinCompetition(u);
		PageInfo<Competition> pageinfo=new PageInfo<Competition>(competitions);
		msg.put("count",pageinfo.getTotal());
		msg.put("data",pageinfo.getList());
		msg.put("code", 0);
		msg.put("msg", "");
		return JSON.toJSONString(msg);
		}else
		{
			HashMap<String,Object> msg=new HashMap<String, Object>();
			ArrayList<Competition> competitions=competitionDao.queryMyJoinCompetition(u);
			msg.put("count",competitions.size());
			msg.put("data",competitions);
			msg.put("code", 0);
			msg.put("msg", "");
			return JSON.toJSONString(msg);
		}	
		
	
	}
	@Override
	public String queryIsJoinCompetition(HashMap<String, Object> u) {
		// TODO Auto-generated method stub
		HashMap<String,Object> msg=new HashMap<String, Object>();
		if(competitionDao.queryIsJoinCompetition(u)>0)
		{
			msg.put("msg", "您已报名，无法重复报名");
			msg.put("flag",false);
		}else
		{
			msg.put("msg", "您未报名可以报名");
			msg.put("flag", true);
		}
		
		return JSON.toJSONString(msg);
	}
	
	
	
}