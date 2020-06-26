package service.impl;

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
		int limit=Integer.parseInt((String)value.get("limit").toString());
		int page=Integer.parseInt((String)value.get("page").toString());
		
		HashMap<String, Object> hs=new HashMap<String, Object>();
		value.put("limit", limit);
		value.put("page", (page-1)*limit);
		ArrayList<Competition> competitions=competitionDao.queryCompetition(value);
		HashMap<String,Object> msg=new HashMap<String, Object>();
		msg.put("code", 0);
		msg.put("msg", "");
		msg.put("count",competitionDao.getTotal(hs));
		msg.put("data",competitions);
		return JSON.toJSONString(msg);
	}
	@Override
	public String queryCompetitionVague(HashMap<String, Object> value) {
		// TODO Auto-generated method stub
		
		int limit=Integer.parseInt((String)value.get("limit").toString());
		int page=Integer.parseInt((String)value.get("page").toString());
		HashMap<String, Object> hs=new HashMap<String, Object>();
		value.put("limit", limit);
		value.put("page", (page-1)*limit);
		ArrayList<Competition> competitions=competitionDao.queryCompetition(value);
		HashMap<String,Object> msg=new HashMap<String, Object>();
		msg.put("code", 0);
		msg.put("msg", "");
		msg.put("count",competitionDao.getfuzzyQueryCount((String)value.get("value")));
		msg.put("data",competitions);
		return JSON.toJSONString(msg);
	}
	@Override
	public String queryUser(HashMap<String, Object> u) {
		// TODO Auto-generated method stub
		int limit=Integer.parseInt((String)u.get("limit").toString());
		int page=Integer.parseInt((String)u.get("page").toString());
		HashMap<String, Object> hs=new HashMap<String, Object>();
		u.put("limit", limit);
		u.put("page", (page-1)*limit);
		ArrayList<User> users=userDao.queryUser(u);
		HashMap<String,Object> msg=new HashMap<String, Object>();
		msg.put("code", 0);
		msg.put("msg", "");
		msg.put("count",userDao.queryUserTotal(u));
		msg.put("data",users);
		return JSON.toJSONString(msg);
	}
	@Override
	public String fuzzyQueryUser(HashMap<String, Object> u) {
		// TODO Auto-generated method stub
		int limit=Integer.parseInt((String)u.get("limit").toString());
		int page=Integer.parseInt((String)u.get("page").toString());
		HashMap<String, Object> hs=new HashMap<String, Object>();
		u.put("limit", limit);
		u.put("page", (page-1)*limit);
		ArrayList<User> users=userDao.fuzzyQueryUser(u);
		HashMap<String,Object> msg=new HashMap<String, Object>();
		msg.put("code", 0);
		msg.put("msg", "");
		msg.put("count",userDao.fuzzyQueryUserTotal(u));
		msg.put("data",users);
		return JSON.toJSONString(msg);
	}
	@Override
	public String queryRegistration(HashMap<String, Object> r) {
		// TODO Auto-generated method stub
		int limit=Integer.parseInt((String)r.get("limit").toString());
		int page=Integer.parseInt((String)r.get("page").toString());
		HashMap<String, Object> hs=new HashMap<String, Object>();
		r.put("limit", limit);
		r.put("page", (page-1)*limit);
		ArrayList<Registration> users=registrationDao.queryRegistration(r);
		HashMap<String,Object> msg=new HashMap<String, Object>();
		msg.put("code", 0);
		msg.put("msg", "");
		msg.put("count",registrationDao.queryRegistrationTotal(r));
		msg.put("data",users);
		return JSON.toJSONString(msg);
	}

	
}
