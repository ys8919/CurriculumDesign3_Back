package service;

import java.util.HashMap;

import entity.Competition;

/**
 * ��������ģ��
 * */
public interface ReleaseCompetitionInterface {
	/**
	 * ��������*/
	public String releaseCompetition(Competition competition);
	/**
	 * ����������Ϣ���*/
	public String  examine(HashMap<String, Object> hasmap);
}
