package control;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Registration;
import service.RegistrationInterface;
import service.impl.RegistrationService;

@Controller
@ResponseBody
@RequestMapping("Controller")
public class RegistrationController {
	
	@Resource
	private RegistrationInterface registrationService;
	/**
	 * ���ܣ�����
	 * mapping:Controller/registration
	 * ������competitionId��applicantId�� �Ƿ���Ҫ��� checkUser
	 * ����ֵ��msg,flag*/
	@RequestMapping("registration")
	 public String registration(@RequestBody HashMap<String, Object> registration)
	 {
		 return registrationService.registration(registration);
	 }
	
	/**
	 * ���ܣ��������
	 * mapping:Controller/registrationExamine
	 * ������registrationId,auditeason ,state ��ͨ��Ϊ999
	 * ����ֵ��msg,flag*/
	@RequestMapping("registrationExamine")
	public String examine(@RequestBody Registration registration) {
		return registrationService.examine(registration) ;
	}
}
