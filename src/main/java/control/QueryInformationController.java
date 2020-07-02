package control;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;

import org.junit.runners.Parameterized.Parameter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Competition;
import entity.User;
import service.QueryInformationInterface;
import service.impl.QueryInformationServices;

@Controller
@ResponseBody
@RequestMapping("Controller")
public class QueryInformationController {
	@Resource
	private QueryInformationInterface queryInformationServices;
	/**
	 * ���ܣ���ѯ������Ϣ
	 * mapping:Controller/queryCompetition
	 * ������ limit,page,competitionId,chargePersonId,type,state(��ѡ)
	 * ����ֵ */
	@RequestMapping("queryCompetition")
	public String queryCompetition(@RequestBody HashMap<String, Object> q) {
		
		return queryInformationServices.queryCompetition(q);
	}
	/**
	 * ���ܣ�������Ϣģ����ѯ
	 * mapping :Controller/queryCompetitionVague
	 * ��������ѯ�ַ��� value,limit,page������value  ȫ��ѡ��
	 * ����ֵ��*/
	@RequestMapping("queryCompetitionVague")
	public String  queryCompetitionVague(@RequestBody HashMap<String, Object> q) {
		
		return queryInformationServices.queryCompetitionVague(q);
	}
	/**
	 * ���ܣ��û���ѯ
	 * mapping:Controller/queryUser
	 * ��������ѡ(userId,schoolName,state��limit,page��
	 * ����ֵ��*/
	@RequestMapping("queryUser")
	public String queryUser(@RequestBody HashMap<String, Object> u){
		return queryInformationServices.queryUser(u);
	}
	
	/**
	 * ���ܣ��û�ģ������
	 * mapping :Controller/fuzzyQueryUser
	 * ��������ѯ�ַ��� value,limit,page ������value  ȫ��ѡ��
	 * ����ֵ��*/
	@RequestMapping("fuzzyQueryUser")
	public String fuzzyQueryUser(@RequestBody HashMap<String, Object> u){
		return queryInformationServices.fuzzyQueryUser(u);
	}
	
	 /** ���ܣ�������ѯ
	 * mapping:Controller/queryRegistration
	 * ��������ѡ(registrationId,competitionId,applicantId,state)  ��ѡ��limit,page,type(�������� 1Ϊ��������2Ϊ�Ŷ���)
	 * ����ֵ��*/
	@RequestMapping("queryRegistration")
	public String queryRegistration(@RequestBody HashMap<String, Object> r){
		return queryInformationServices.queryUser(r);
	}
	/**
	 * ���� ����ѯ�����ֻ�������
	 * mapping��Controller/queryUserMyself
	 * ������userId
	 * ����ֵ��*/
	@RequestMapping("queryUserMyself")
	public String queryUserMyself(@RequestBody User u)
	{
		return queryInformationServices.queryUserMyself(u);
	}
	/**
	 * ���� ����ѯ������
	 * mapping��Controller/queryPublisher
	 * ������page limit
	 * ����ֵ��*/
	@RequestMapping("queryPublisher")
	public String queryPublisher(@RequestBody HashMap<String, Object> u)
	{
		return queryInformationServices.queryPublisher(u);
	}
	
}
