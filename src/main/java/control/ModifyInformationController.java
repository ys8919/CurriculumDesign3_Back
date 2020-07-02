package control;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Competition;
import entity.User;
import service.ModifyInformationInterface;

@Controller
@RequestMapping("Controller")
@ResponseBody
public class ModifyInformationController {
	@Resource
	private ModifyInformationInterface modifyInformationService;
	
	/**
	 * 功能：修改比赛信息；
	 * mapping：Controller/modifyCompetition
	 * 参数：Competition(修改什么传什么，必传"competitionId)
	 * 返回值：msg,flag*/
	@RequestMapping("modifyCompetition")
	public String modifyCompetition(@RequestBody Competition competition) {
		return modifyInformationService.modifyCompetition(competition);
	}
	/**
	 * 功能：修改用户信息；
	 * mapping：Controller/modifyCompetition
	 * 参数：User(修改什么传什么，必传"userId)
	 * 返回值：msg,flag*/
	@RequestMapping("modifyUser")
	public String modifyUser(@RequestBody User u) {
		return modifyInformationService.modifyUser(u);
	}
	/**
	 * 功能：登陆后修改密码
	 * mapping：Controller/modifyUserPassword
	 * 参数：token,passwd,newPasswd
	 * 返回值：*/
	@RequestMapping("modifyUserPassword")
	public String modifyUserPassword(@RequestBody HashMap<String, Object> u,@RequestHeader("token") String token)
	{
		u.put("token", token);
		return modifyInformationService.modifyUserPassword(u);
	}
}
