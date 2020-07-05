package dao;

import java.util.ArrayList;
import java.util.HashMap;

import entity.Competition;

public interface CompetitionDao {
	/**
	 * ��ѯ����*/
	public ArrayList<Competition> queryCompetition(HashMap<String, Object> hsm);
	/**
	 * �޸ı�����Ϣ*/
	public int modifyCompetition(Competition competition);
	/**ɾ������*/
	public int deleteCompetition(Competition competition);
	/**��ӱ���*/
	public int insertCompetition(Competition competition);
	/** ģ����ѯ������Ϣ*/
	public ArrayList<Competition> fuzzyQuery(String value);
	/**ģ����ѯ��ͨ�����*/
	public ArrayList<Competition> fuzzyQueryByState(HashMap<String, Object> hsm);
	/**��ѯ�Ѿ�����ı���*/
	public ArrayList<Competition> queryMyJoinCompetition(HashMap<String, Object> hsm);
	public Integer queryCompetitionType(String competitionId);
}
