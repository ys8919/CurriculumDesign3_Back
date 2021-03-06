package control;

import java.util.ArrayList;
import java.util.HashMap;

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
	 * 功能：加入团队
	 * mapping:Controller/joinTeam
	 * 参数：id,token
	 * 返回值：msg,flag*/
	@RequestMapping("joinTeam")
	public String joinTeam(@RequestBody Team team,@RequestHeader("token") String token) {
		
		return managementTeam.joinTeam(team,UserTokenUtil.getUserState(token));
	}
	/**
	 * 功能：退出团队
	 * mapping:Controller/exitTeam
	 * 参数：id
	 * 返回值：msg,flag*/
	@RequestMapping("exitTeam")
	public String exitTeam(@RequestBody Team team) {
		return managementTeam.exitTeam(team);
	}
	
	/**
	 * 功能：邀请人加入团队
	 * mapping:Controller/inviteMembers
	 * 参数：对象数组，邀请多个人就多个人传每个人都传 memberId，teamId
	 * 返回值：msg,flag*/
	@RequestMapping("inviteMembers")
	public  String inviteMembers(@RequestBody HashMap<String, Object> members) {
		return managementTeam.inviteMembers(members);
	}
	/**
	 * 功能：查询团队
	 * mapping:Controller/queryJoinTeam
	 * 参数： memberId
	 * 返回值：msg,flag,队伍对象数组data*/
	@RequestMapping("queryJoinTeam")
	public String  queryJoinTeam(@RequestBody HashMap<String, Object> t) {
		return managementTeam.queryJoinTeam(t);
	}
	/**
	 * 功能：查询队伍成员
	 * mapping:Controller/queryMembers
	 * 参数： teamId
	 * 返回值：msg,flag,队员对象数组data*/
	@RequestMapping("queryMembers")
	public String queryMembers(@RequestBody Team team) {

		return managementTeam.queryMembers(team);
	}
	/**
	 * 功能：创建团队
	 * mapping:Controller/createTeam
	 * 参数： memberId，teamName
	 * 返回值：msg,flag,队员对象数组data*/
	@RequestMapping("createTeam")
	public String createTeam(@RequestBody Team team,@RequestHeader("token") String token) {
		return managementTeam.createTeam(team,UserTokenUtil.getUserState(token));
	}
	/**
	 * 功能：查询已自己为队长团队
	 * mapping:Controller/queryIsTeamLearder
	 * 参数： memberId
	 * 返回值：msg,flag,队员对象数组data*/
	@RequestMapping("queryIsTeamLearder")
	public String queryIsTeamLearder(@RequestBody HashMap<String, Object> t) {
		return managementTeam.queryIsTeamLearder(t);
		
	}
}
