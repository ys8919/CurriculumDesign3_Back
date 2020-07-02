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
	 * 功能：查询竞赛信息
	 * mapping:Controller/queryCompetition
	 * 参数： limit,page,competitionId,chargePersonId,type,state(可选)
	 * 返回值 */
	@RequestMapping("queryCompetition")
	public String queryCompetition(@RequestBody HashMap<String, Object> q) {
		
		return queryInformationServices.queryCompetition(q);
	}
	/**
	 * 功能：竞赛信息模糊查询
	 * mapping :Controller/queryCompetitionVague
	 * 参数：查询字符串 value,limit,page（除啦value  全必选）
	 * 返回值：*/
	@RequestMapping("queryCompetitionVague")
	public String  queryCompetitionVague(@RequestBody HashMap<String, Object> q) {
		
		return queryInformationServices.queryCompetitionVague(q);
	}
	/**
	 * 功能：用户查询
	 * mapping:Controller/queryUser
	 * 参数：可选(userId,schoolName,state，limit,page）
	 * 返回值：*/
	@RequestMapping("queryUser")
	public String queryUser(@RequestBody HashMap<String, Object> u){
		return queryInformationServices.queryUser(u);
	}
	
	/**
	 * 功能：用户模糊查明
	 * mapping :Controller/fuzzyQueryUser
	 * 参数：查询字符串 value,limit,page （除啦value  全必选）
	 * 返回值：*/
	@RequestMapping("fuzzyQueryUser")
	public String fuzzyQueryUser(@RequestBody HashMap<String, Object> u){
		return queryInformationServices.fuzzyQueryUser(u);
	}
	
	 /** 功能：报名查询
	 * mapping:Controller/queryRegistration
	 * 参数：可选(registrationId,competitionId,applicantId,state)  必选：limit,page,type(比赛类型 1为个人赛，2为团队赛)
	 * 返回值：*/
	@RequestMapping("queryRegistration")
	public String queryRegistration(@RequestBody HashMap<String, Object> r){
		return queryInformationServices.queryUser(r);
	}
	/**
	 * 功能 ：查询个人手机和邮箱
	 * mapping：Controller/queryUserMyself
	 * 参数：userId
	 * 返回值：*/
	@RequestMapping("queryUserMyself")
	public String queryUserMyself(@RequestBody User u)
	{
		return queryInformationServices.queryUserMyself(u);
	}
	/**
	 * 功能 ：查询发布者
	 * mapping：Controller/queryPublisher
	 * 参数：page limit
	 * 返回值：*/
	@RequestMapping("queryPublisher")
	public String queryPublisher(@RequestBody HashMap<String, Object> u)
	{
		return queryInformationServices.queryPublisher(u);
	}
	
}
