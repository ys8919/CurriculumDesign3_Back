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
	 * 功能：登录
	 * mapping:Controller/login
	 * 参数：userId,passwd
	 * 返回值：msg,token,jurisdiction,flag,userName*/
	@ResponseBody
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(@RequestBody User u)
	{
		return loginRegister.login(u);
		
	}
	
	/**
	 * 功能：注册
	 * mapping:Controller/register
	 * 参数：User
	 * 返回值：msg,userId,flag*/
	@ResponseBody
	@RequestMapping(value="register",method=RequestMethod.POST)
	public String reginster(@RequestBody User u) {
		return loginRegister.register(u);
	}
	
	/**
	 * 功能：验证忘记密码绑定的手机或邮箱
	 * mapping:Controller/forgetPassword
	 * 参数：userId,(email||tel)
	 * 返回值：msg,flag*/
	@ResponseBody
	@RequestMapping("forgetPassword")
	public String forgetPassword(@RequestBody User u)
	{
		
		return loginRegister.forgetPassword(u);
	}

	/**
	 * 功能：修改密码
	 * mapping:Controller/changePassword
	 * 参数：userId,passwd
	 * 返回值：msg,flag*/
	@ResponseBody
	@RequestMapping("changePassword")
	public String changePassword(@RequestBody User u){
		return loginRegister.changePassword(u);
	}
	
	/**
	 * 功能：注销
	 * mapping:Controller/logout
	 * 参数：token
	 * 返回值：*/
	@ResponseBody
	@RequestMapping("logout")
	public void logout(@RequestHeader("token") String token) {
		
		UserTokenUtil.delUserSession(token);
	}
}