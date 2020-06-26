package control;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
}
