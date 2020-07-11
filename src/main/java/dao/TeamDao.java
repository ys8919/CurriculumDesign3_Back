package dao;

import java.util.ArrayList;
import java.util.HashMap;

import entity.Team;
import entity.User;

public interface TeamDao {
	/**
	 * ��ѯ����*/
	public ArrayList<Team> queryTeam(HashMap<String, Object> t);
	/**
	 * �޸Ķ�����Ϣ*/
	public int modifyTeam(Team team) ;
	/**
	 * ɾ��Team������*/
	public int deleteTeam(Team team);
	/**
	 * ���Team����*/
	public int insertTeam(Team team);
	/**
	 * ���Ҷ����Ա��Ϣ*/
	public ArrayList<User> queryMembers(Team team);
	
	
}
