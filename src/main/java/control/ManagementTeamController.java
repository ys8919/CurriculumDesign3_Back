package control;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Team;
import service.ManagementTeamInterface;
import util.UserTokenUtil;

@Controller
@ResponseBody
@RequestMapping("Controller")
public class ManagementTeamController {
	@Resource
	private ManagementTeamInterface managementTeam;
	/**
	 * ���ܣ������Ŷ�
	 * mapping:Controller/joinTeam
	 * ������id,token
	 * ����ֵ��msg,flag*/
	@RequestMapping("joinTeam")
	public String joinTeam(@RequestBody Team team,@RequestHeader("token") String token) {
		
		return managementTeam.joinTeam(team,UserTokenUtil.getUserState(token));
	}
	/**
	 * ���ܣ��˳��Ŷ�
	 * mapping:Controller/exitTeam
	 * ������id
	 * ����ֵ��msg,flag*/
	@RequestMapping("exitTeam")
	public String exitTeam(@RequestBody Team team) {
		return managementTeam.exitTeam(team);
	}
	
	/**
	 * ���ܣ��˳��Ŷ�
	 * mapping:Controller/inviteMembers
	 * �������������飬�������˾Ͷ���˴�ÿ���˶��� memberId��teamId
	 * ����ֵ��msg,flag*/
	@RequestMapping("inviteMembers")
	public  String inviteMembers(@RequestBody ArrayList<Team> teams) {
		return managementTeam.inviteMembers(teams);
	}
	/**
	 * ���ܣ��˳��Ŷ�
	 * mapping:Controller/queryJoinTeam
	 * ������ memberId
	 * ����ֵ��msg,flag,�����������data*/
	@RequestMapping("queryJoinTeam")
	public String  queryJoinTeam(@RequestBody Team team) {
		return managementTeam.queryJoinTeam(team);
	}
	/**
	 * ���ܣ���ѯ�����Ա
	 * mapping:Controller/queryMembers
	 * ������ teamId
	 * ����ֵ��msg,flag,��Ա��������data*/
	@RequestMapping("queryMembers")
	public String queryMembers(@RequestBody Team team) {

		return managementTeam.queryMembers(team);
	}
	/**
	 * ���ܣ������Ŷ�
	 * mapping:Controller/createTeam
	 * ������ memberId��teamName
	 * ����ֵ��msg,flag,��Ա��������data*/
	@RequestMapping("createTeam")
	public String createTeam(@RequestBody Team team,@RequestHeader("token") String token) {
		return managementTeam.createTeam(team,UserTokenUtil.getUserState(token));
	}
}
