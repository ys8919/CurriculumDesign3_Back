package dao;

import java.util.ArrayList;

import entity.Team;
import entity.User;

public interface TeamDao {
	/**
	 * 查询队伍*/
	public ArrayList<Team> queryTeam(Team team);
	/**
	 * 修改队伍信息*/
	public int modifyTeam(Team team) ;
	/**
	 * 删除Team表数据*/
	public int deleteTeam(Team team);
	/**
	 * 添加Team数据*/
	public int insertTeam(Team team);
	/**
	 * 查找队伍成员信息*/
	public ArrayList<User> queryMembers(Team team);
}
