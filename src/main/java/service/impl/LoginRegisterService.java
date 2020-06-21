package service.impl;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import dao.UserDao;
import entity.User;
import handler.UserTokenUtil;
import service.LoginRegisterInterface;
@Service
public class LoginRegisterService implements LoginRegisterInterface{
	@Resource
	private UserDao userDao;
	@Override
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
		ArrayList<User> userlist=userDao.queryUser(u);
		HashMap<String, Object> msg=new HashMap<String, Object>();
		if(userlist.size()>0)
		{
			msg.put("msg", "µÇÂ½³É¹¦");
			msg.put("flag",true);
			UserTokenUtil.setUserSession(u.getUserId());
			return JSON.toJSONString(msg);
		}else {
			msg.put("msg", "µÇÂ½Ê§°Ü,ÕËºÅ»òÃÜÂë´íÎó");
			msg.put("flag",false);
			return JSON.toJSONString(msg);
		}
	}

	@Override
	public String register(User u) {
		// TODO Auto-generated method stub
		
		HashMap<String, Object> msg=new HashMap<String, Object>();
		HashMap<String, Object> data=new HashMap<String, Object>();
		if(userDao.insertUser(u)>0)
		{
			msg.put("msg", "×¢²á³É¹¦");
			msg.put("flag",true);
			data.put("userId", u.getUserId());
			msg.put("data",data);
			return JSON.toJSONString(msg);
		}else
		{
			msg.put("msg", "×¢²áÊ§°Ü");
			msg.put("flag",false);
			return JSON.toJSONString(msg);
		}
	}

}
