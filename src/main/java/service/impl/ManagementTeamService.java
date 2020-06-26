package service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;

import dao.TeamDao;
import dao.UserDao;
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
	 * 加入团队*/
	@Override
	public String joinTeam(Team team,int userState) {
		// TODO Auto-generated method stub
		HashMap<String, Object> msg=new HashMap<String, Object>();
		team.setState(ConstantValueUtil.Team_joinState);
		if(userState==ConstantValueUtil.user_authenticatedState)
		{
			if(teamDao.modifyTeam(team)>0)
			{
				msg.put("msg","加入队伍成功");
				msg.put("flag",true);
				return JSON.toJSONString(msg);
			}else{
				msg.put("msg","加入队伍失败");
				msg.put("flag",false);
				return JSON.toJSONString(msg);	
			}
		}else
		{
			msg.put("msg","用户未认证，请先认证后加入团队");
			msg.put("flag",true);
			return JSON.toJSONString(msg);
		}
	}
	/**
	 * 退出团队*/
	@Override
	public String exitTeam(Team team) {
		// TODO Auto-generated method stub
		HashMap<String, Object> msg=new HashMap<String, Object>();
		if(teamDao.deleteTeam(team)>0)
		{
			msg.put("msg","退出队伍成功");
			msg.put("flag",true);
			return JSON.toJSONString(msg);
		}else{
			msg.put("msg","退出队伍失败");
			msg.put("flag",false);
			return JSON.toJSONString(msg);	
		}
	}
	/**
	 * 邀请成员*/
	@Transactional
	@Override
	public String inviteMembers(ArrayList<Team> teams) {
		
		HashMap<String, Object> msg=new HashMap<String, Object>();
		Iterator<Team> it=teams.iterator();
		try {
			while(it.hasNext())
			{
				Team team=it.next();
				team.setId(RandIdUtil.rangId());
				team.setType(ConstantValueUtil.Team_member);
				team.setState(ConstantValueUtil.Team_waitState);
				teamDao.insertTeam(team);
			}
			msg.put("msg","邀请成功");
			msg.put("flag",true);
			return JSON.toJSONString(msg);
			
		} catch (Exception e) {
			// TODO: handle exception
			msg.put("msg","邀请失败");
			msg.put("flag",false);
			return JSON.toJSONString(msg);	
		}
	}
		/**
		 * 查询已加入团队*/
	@Override
	public String queryJoinTeam(Team team) {
		// TODO Auto-generated method stub
		HashMap<String, Object> msg=new HashMap<String, Object>();
		ArrayList<Team> teams=teamDao.queryTeam(team);
		if(teams.size()>0)
		{
			//msg.put("msg","队伍信息");
			msg.put("flag",true);
			msg.put("data", teams);
			return JSON.toJSONString(msg);
		}else{
			//msg.put("msg","退出队伍失败");
			msg.put("flag",false);
			return JSON.toJSONString(msg);
		}
		
	}
	/**
	 * 查询队伍成员*/
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
			msg.put("msg","暂无加入队伍");
			msg.put("flag",false);
			return JSON.toJSONString(msg);
		}
		
	}
		/**
		 * 创建队伍*/
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
			msg.put("msg","创建队伍成功");
			msg.put("flag",true);
			return JSON.toJSONString(msg);
		}else{
			msg.put("msg","创建队伍失败");
			msg.put("flag",false);
			return JSON.toJSONString(msg);	
		}
		}else
		{
			msg.put("msg","用户未认证，请先认证再创建团队");
			msg.put("flag",true);
			return JSON.toJSONString(msg);
		}
	
	}

}
