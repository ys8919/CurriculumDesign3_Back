package service;

import java.util.ArrayList;
import java.util.HashMap;

import entity.Team;

public interface ManagementTeamInterface {
	/**
	 * 加入团队*/
	public String joinTeam(Team team,int userState);
	/**
	 * 退出团队*/
	public String exitTeam(Team team);
	/**
	 * 邀请成员*/
	public  String inviteMembers(HashMap<String, Object> members);
	/**
	 * 查询已加入团队*/
	public String  queryJoinTeam(HashMap<String, Object> t) ;
	/**
	 * 查询团队成员*/
	public String queryMembers(Team team) ;
	/**
	 * 创建团队*/
	public String createTeam(Team team,int userState) ;
	/**查询自己为队长的队伍*/
	public String queryIsTeamLearder(HashMap<String, Object> t);
}
