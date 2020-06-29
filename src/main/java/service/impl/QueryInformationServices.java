package service.impl;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.swing.plaf.basic.BasicScrollPaneUI.HSBChangeListener;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
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
		
		int limit=Integer.parseInt((String)value.get("limit").toString());
		int page=Integer.parseInt((String)value.get("page").toString());
		PageHelper.startPage(page,limit);
		ArrayList<Competition> competitions=competitionDao.fuzzyQuery((String)value.get("value"));
		PageInfo<Competition> pageinfo=new PageInfo<Competition>(competitions);
		HashMap<String,Object> msg=new HashMap<String, Object>();
		msg.put("code", 0);
		msg.put("msg", "");
		msg.put("count",pageinfo.getTotal());
		msg.put("data",pageinfo.getList());
		return JSON.toJSONString(msg);
		
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
		int limit=Integer.parseInt((String)u.get("limit").toString());
		int page=Integer.parseInt((String)u.get("page").toString());
		PageHelper.startPage(page,limit);
		ArrayList<User> users=userDao.fuzzyQueryUser(u);
		PageInfo<User> pageinfo=new PageInfo<User>(users);
		HashMap<String,Object> msg=new HashMap<String, Object>();
		msg.put("code", 0);
		msg.put("msg", "");
		msg.put("count",pageinfo.getTotal());
		msg.put("data",pageinfo.getList());
		return JSON.toJSONString(msg);
	}
	@Override
	public String queryRegistration(HashMap<String, Object> r) {
		// TODO Auto-generated method stub
		int limit=Integer.parseInt((String)r.get("limit").toString());
		int page=Integer.parseInt((String)r.get("page").toString());
		PageHelper.startPage(page,limit);
		ArrayList<Registration> rgis=registrationDao.queryRegistration(r);
		PageInfo<Registration> pageinfo=new PageInfo<Registration>(rgis);
		HashMap<String,Object> msg=new HashMap<String, Object>();
		msg.put("code", 0);
		msg.put("msg", "");
		msg.put("count",pageinfo.getTotal());
		msg.put("data",pageinfo.getList());
		return JSON.toJSONString(msg);
	}
	@Override
	public String queryUserMyself(User u) {
		// TODO Auto-generated method stub
		HashMap<String,Object> msg=new HashMap<String, Object>();
		User user=userDao.queryMyself(u);
		msg.put("msg", "");
		msg.put("data",user);
		return JSON.toJSONString(msg);
	}

	
}
