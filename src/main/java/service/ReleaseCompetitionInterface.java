package service;

import java.util.HashMap;

import entity.Competition;

/**
 * 发布竞赛模块
 * */
public interface ReleaseCompetitionInterface {
	/**
	 * 发布竞赛*/
	public String releaseCompetition(Competition competition);
	/**
	 * 竞赛发布信息审核*/
	public String  examine(HashMap<String, Object> hasmap);
}
