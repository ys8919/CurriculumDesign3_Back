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
	public ArrayList<Competition> getTotal(HashMap<String, Object> hsm);
	public int getfuzzyQueryCount(String value);
}
