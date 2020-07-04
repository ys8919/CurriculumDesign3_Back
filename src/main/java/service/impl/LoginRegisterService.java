package service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import dao.UserDao;
import entity.User;
import net.sf.jsqlparser.parser.Token;
import service.LoginRegisterInterface;
import util.ConstantValueUtil;
import util.RandIdUtil;
import util.UserTokenUtil;
@Service
public class LoginRegisterService implements LoginRegisterInterface{
	@Resource
	private UserDao userDao;
	@Override
	/**登录*/
	public String login(User u) {
		// TODO Auto-generated method stub
		if(u.getUserId()==null)
		{
			u.setUserId("");
		}
		if(u.getPasswd()==null)
		{
			u.setPasswd("");
		}
		ArrayList<User> userlist=userDao.login(u);
		
		HashMap<String, Object> msg=new HashMap<String, Object>();
		if(userlist.size()>0)
		{
			msg.put("msg", "登陆成功");
			msg.put("flag",true);
			msg.put("jurisdiction", userlist.get(0).getJurisdiction());
			
			String token=RandIdUtil.rangToken();
			HashMap<String, Object> userinfomaintion=new HashMap<String, Object>();
			userinfomaintion.put("userId", u.getUserId());
			userinfomaintion.put("jurisdiction", userlist.get(0).getJurisdiction());
			userinfomaintion.put("state", userlist.get(0).getState());
			UserTokenUtil.setUserSession(token,userinfomaintion);
			msg.put("token",token);
			msg.put("userId", u.getUserId());
			msg.put("userName", userlist.get(0).getUserName());
			msg.put("state", userlist.get(0).getState());
			return JSON.toJSONString(msg);
		}else {
			msg.put("msg", "登陆失败,账号或密码错误");
			msg.put("flag",false);
			return JSON.toJSONString(msg);
		}
	}
/**
 * 注册*/
	@Override
	public String register(User u) {
		// TODO Auto-generated method stub
		
		u.setUserId(RandIdUtil.rangId());
		u.setJurisdiction(ConstantValueUtil.ordinaryUsers);
		u.setState(ConstantValueUtil.user_waitState);
		if(userDao.insertUser(u)>0)
		{
			HashMap<String, Object> msg=new HashMap<String, Object>();
			msg.put("msg", "注册成功，您的账号为："+u.getUserId());
			msg.put("userId",u.getUserId());
			msg.put("flag",true);
			return JSON.toJSONString(msg);
		}else
		{
			HashMap<String, Object> msg=new HashMap<String, Object>();
			
			msg.put("msg", "注册失败，请重新注册");
			msg.put("flag",false);
			return JSON.toJSONString(msg);
		}
	}
	/**
	 * 验证绑定账号*/
	public String forgetPassword(User u)
	{	
		HashMap<String, Object> msg=new HashMap<String, Object>();
		if(userDao.forgetPassword(u)>0)
		{
			msg.put("msg", "验证成功");
			msg.put("flag", true);
			return JSON.toJSONString(msg);
		}else
		{
			msg.put("msg","绑定的邮箱或手机错误");
			msg.put("flag", false);
			return JSON.toJSONString(msg);
		}
		
	}
	
	/**
	 * 修改密码
	 * */
	public String changePassword(User u) {
		HashMap<String, Object> msg=new HashMap<String, Object>();
		if(userDao.changePassword(u)>0)
		{
			msg.put("msg", "修改密码成功");
			msg.put("flag", true);
			return JSON.toJSONString(msg);
		}else {
			msg.put("msg", "修改密码失败");
			msg.put("flag", false);
			return JSON.toJSONString(msg);
		}
	}

}
