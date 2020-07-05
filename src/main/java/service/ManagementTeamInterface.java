package service;

import java.util.ArrayList;
import java.util.HashMap;

import entity.Team;

public interface ManagementTeamInterface {
	/**
	 * �����Ŷ�*/
	public String joinTeam(Team team,int userState);
	/**
	 * �˳��Ŷ�*/
	public String exitTeam(Team team);
	/**
	 * �����Ա*/
	public  String inviteMembers(ArrayList<Team> teams);
	/**
	 * ��ѯ�Ѽ����Ŷ�*/
	public String  queryJoinTeam(HashMap<String, Object> t) ;
	/**
	 * ��ѯ�Ŷӳ�Ա*/
	public String queryMembers(Team team) ;
	/**
	 * �����Ŷ�*/
	public String createTeam(Team team,int userState) ;
}
