package control;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;

import org.junit.runner.Request;
import org.junit.runners.Parameterized.Parameter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import dao.UserDao;
import entity.User;
import service.LoginRegisterInterface;
import util.ConstantValueUtil;
import util.UserTokenUtil;


@Controller
@RequestMapping("Controller")
@CrossOrigin
public class LoginRegisterController {
	@Resource
	private LoginRegisterInterface loginRegister;
	
	
	/**
	 * ���ܣ���¼
	 * mapping:Controller/login
	 * ������userId,passwd
	 * ����ֵ��msg,token,jurisdiction,flag,userName*/
	@ResponseBody
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(@RequestBody User u)
	{
		return loginRegister.login(u);
		
	}
	
	/**
	 * ���ܣ�ע��
	 * mapping:Controller/register
	 * ������User
	 * ����ֵ��msg,userId,flag*/
	@ResponseBody
	@RequestMapping(value="register",method=RequestMethod.POST)
	public String reginster(@RequestBody User u) {
		return loginRegister.register(u);
	}
	
	/**
	 * ���ܣ���֤��������󶨵��ֻ�������
	 * mapping:Controller/forgetPassword
	 * ������userId,(email||tel)
	 * ����ֵ��msg,flag*/
	@ResponseBody
	@RequestMapping("forgetPassword")
	public String forgetPassword(@RequestBody User u)
	{
		
		return loginRegister.forgetPassword(u);
	}

	/**
	 * ���ܣ��޸�����
	 * mapping:Controller/changePassword
	 * ������userId,passwd
	 * ����ֵ��msg,flag*/
	@ResponseBody
	@RequestMapping("changePassword")
	public String changePassword(@RequestBody User u){
		return loginRegister.changePassword(u);
	}
	
	/**
	 * ���ܣ�ע��
	 * mapping:Controller/logout
	 * ������token
	 * ����ֵ��*/
	@ResponseBody
	@RequestMapping("logout")
	public void logout(@RequestHeader("token") String token) {
		
		UserTokenUtil.delUserSession(token);
	}
}