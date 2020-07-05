package dao;

import java.util.ArrayList;
import java.util.HashMap;

import entity.Competition;

public interface CompetitionDao {
	/**
	 * 查询比赛*/
	public ArrayList<Competition> queryCompetition(HashMap<String, Object> hsm);
	/**
	 * 修改比赛信息*/
	public int modifyCompetition(Competition competition);
	/**删除比赛*/
	public int deleteCompetition(Competition competition);
	/**添加比赛*/
	public int insertCompetition(Competition competition);
	/** 模糊查询比赛信息*/
	public ArrayList<Competition> fuzzyQuery(String value);
	/**模糊查询已通过审核*/
	public ArrayList<Competition> fuzzyQueryByState(HashMap<String, Object> hsm);
	/**查询已经加入的比赛*/
	public ArrayList<Competition> queryMyJoinCompetition(HashMap<String, Object> hsm);
	public Integer queryCompetitionType(String competitionId);
}
