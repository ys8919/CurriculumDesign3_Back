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
	 * 功能：报名
	 * mapping:Controller/registration
	 * 参数：competitionId，applicantId， 是否需要审核 checkUser
	 * 返回值：msg,flag*/
	@RequestMapping("registration")
	 public String registration(@RequestBody HashMap<String, Object> registration)
	 {
		 return registrationService.registration(registration);
	 }
	
	/**
	 * 功能：报名审核
	 * mapping:Controller/registrationExamine
	 * 参数：registrationId,auditeason ,state 不通过为999
	 * 返回值：msg,flag*/
	@RequestMapping("registrationExamine")
	public String examine(@RequestBody Registration registration) {
		return registrationService.examine(registration) ;
	}
}
