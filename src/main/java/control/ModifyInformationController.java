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
	 * ���ܣ��޸ı�����Ϣ��
	 * mapping��Controller/modifyCompetition
	 * ������Competition(�޸�ʲô��ʲô���ش�"competitionId)
	 * ����ֵ��msg,flag*/
	@RequestMapping("modifyCompetition")
	public String modifyCompetition(@RequestBody Competition competition) {
		return modifyInformationService.modifyCompetition(competition);
	}
	/**
	 * ���ܣ��޸��û���Ϣ��
	 * mapping��Controller/modifyCompetition
	 * ������User(�޸�ʲô��ʲô���ش�"userId)
	 * ����ֵ��msg,flag*/
	@RequestMapping("modifyUser")
	public String modifyUser(@RequestBody User u) {
		return modifyInformationService.modifyUser(u);
	}
	/**
	 * ���ܣ���½���޸�����
	 * mapping��Controller/modifyUserPassword
	 * ������token,passwd,newPasswd
	 * ����ֵ��*/
	@RequestMapping("modifyUserPassword")
	public String modifyUserPassword(@RequestBody HashMap<String, Object> u,@RequestHeader("token") String token)
	{
		u.put("token", token);
		return modifyInformationService.modifyUserPassword(u);
	}
}
