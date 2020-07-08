package service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import dao.TeamDao;
import dao.UserDao;
import entity.Competition;
import entity.Team;
import entity.User;
import service.ManagementTeamInterface;
import util.ConstantValueUtil;
import util.RandIdUtil;
@Service
public class ManagementTeamService implements ManagementTeamInterface{
	@Resource
	private TeamDao teamDao;
	/**
	 * �����Ŷ�*/
	@Override
	public String joinTeam(Team team,int userState) {
		// TODO Auto-generated method stub
		HashMap<String, Object> msg=new HashMap<String, Object>();
		team.setState(ConstantValueUtil.Team_joinState);
		if(userState==ConstantValueUtil.user_authenticatedState)
		{
			if(teamDao.modifyTeam(team)>0)
			{
				msg.put("msg","�������ɹ�");
				msg.put("flag",true);
				return JSON.toJSONString(msg);
			}else{
				msg.put("msg","�������ʧ��");
				msg.put("flag",false);
				return JSON.toJSONString(msg);	
			}
		}else
		{
			msg.put("msg","�û�δ��֤��������֤������Ŷ�");
			msg.put("flag",true);
			return JSON.toJSONString(msg);
		}
	}
	/**
	 * �˳��Ŷ�*/
	@Override
	public String exitTeam(Team team) {
		// TODO Auto-generated method stub
		HashMap<String, Object> msg=new HashMap<String, Object>();
		if(teamDao.deleteTeam(team)>0)
		{
			msg.put("msg","�˳�����ɹ�");
			msg.put("flag",true);
			return JSON.toJSONString(msg);
		}else{
			msg.put("msg","�˳�����ʧ��");
			msg.put("flag",false);
			return JSON.toJSONString(msg);	
		}
	}
	/**
	 * �����Ա*/
	@Transactional
	@Override
	public String inviteMembers(HashMap<String, Object> members) {
		
		HashMap<String, Object> msg=new HashMap<String, Object>();
		
		
		String teamId=(String) members.get("teamId");
		HashMap<String, Object> t=new HashMap<String, Object>();
		t.put("teamId", teamId);
		ArrayList<Team> ts=teamDao.queryTeam(t);
		String teamName=ts.get(0).getTeamName();
		List<String> mebersId=Arrays.asList((String[])members.get("memberId"));
		Iterator<String> it=null;
		if(mebersId!=null) {
			it=mebersId.iterator();
		}
	
		try {
			
			while(it.hasNext())
			{
				
				Team team=new Team();
				team.setTeamId(teamId);
				team.setMemberId(it.next());
				team.setId(RandIdUtil.rangId());
				team.setTeamName(teamName);
				team.setType(ConstantValueUtil.Team_member);
				team.setState(ConstantValueUtil.Team_waitState);
				teamDao.insertTeam(team);
			}
			
			msg.put("msg","����ɹ�");
			msg.put("flag",true);
			return JSON.toJSONString(msg);
			
		} catch (Exception e) {
			// TODO: handle exception
			msg.put("msg","����ʧ��");
			msg.put("flag",false);
			msg.put("Exception", e.toString());
			return JSON.toJSONString(msg);	
		}
		
	}
		/**
		 * ��ѯ�Ѽ����Ŷ�*/
	@Override
	public String queryJoinTeam(HashMap<String, Object> t) {
		// TODO Auto-generated method stub
		int limit=Integer.parseInt((String)t.get("limit").toString());
		int page=Integer.parseInt((String)t.get("page").toString());
		PageHelper.startPage(page,limit);
		HashMap<String, Object> msg=new HashMap<String, Object>();
		ArrayList<Team> teams=teamDao.queryTeam(t);
		PageInfo<Team> pageinfo=new PageInfo<Team>(teams);
		
		msg.put("count",pageinfo.getTotal());
		msg.put("data",pageinfo.getList());
		msg.put("code", 0);
		msg.put("msg", "");
		return JSON.toJSONString(msg);
		
	}
	/**
	 * ��ѯ�����Ա*/
	@Override
	public String queryMembers(Team team) {
		// TODO Auto-generated method stub
		HashMap<String, Object> msg=new HashMap<String, Object>();
		ArrayList<User> users=teamDao.queryMembers(team);
		if(users.size()>0)
		{
			msg.put("flag",true);
			msg.put("data", users);
			return JSON.toJSONString(msg);
		}else
		{
			msg.put("msg","���޼������");
			msg.put("flag",false);
			return JSON.toJSONString(msg);
		}
		
	}
		/**
		 * ��������*/
	@Override
	public String createTeam(Team team,int userState) {
		// TODO Auto-generated method stub
		HashMap<String, Object> msg=new HashMap<String, Object>();
		User u=new User();
		u.setUserId(team.getMemberId());
		team.setType(ConstantValueUtil.Team_leader);
		team.setId(RandIdUtil.rangId());
		team.setTeamId(RandIdUtil.rangId());
		team.setState(ConstantValueUtil.Team_joinState);
		if(userState==ConstantValueUtil.user_authenticatedState)
		{
		if(teamDao.insertTeam(team)>0)
		{
			msg.put("msg","��������ɹ�");
			msg.put("flag",true);
			msg.put("id", team.getId());
			return JSON.toJSONString(msg);
		}else{
			msg.put("msg","��������ʧ��");
			msg.put("flag",false);
			return JSON.toJSONString(msg);	
		}
		}else
		{
			msg.put("msg","�û�δ��֤��������֤�ٴ����Ŷ�");
			msg.put("flag",false);
			return JSON.toJSONString(msg);
		}
	
	}

}
