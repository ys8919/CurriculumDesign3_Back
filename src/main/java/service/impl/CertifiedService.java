package service.impl;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import dao.UserDao;
import entity.User;
import service.CertifiedInterface;
import util.ConstantValueUtil;
@Service
public class CertifiedService implements CertifiedInterface{
	@Resource
	private UserDao userDao;
	@Override
	public String authentication(User u) {
		// TODO Auto-generated method stub
		HashMap<String, Object> msg=new HashMap<String,Object>();
		u.setState(ConstantValueUtil.user_waitExamineState);
		if(userDao.modifyUser(u)>0)
		{
			msg.put("msg", "提交认证成功，等待管理员审核");
			msg.put("flag", true);
			return JSON.toJSONString(msg);
		}else
		{
			msg.put("msg", "提交认证失败");
			msg.put("flag", false);
			return JSON.toJSONString(msg);
		}
	}

	@Override
	public String examine(User u) {
		// TODO Auto-generated method stub
		HashMap<String, Object> msg=new HashMap<String,Object>();
		if(userDao.modifyUser(u)>0)
		{
			msg.put("msg", "操作成功");
			msg.put("flag", true);
			return JSON.toJSONString(msg);
		}else
		{
			msg.put("msg", "操作失败");
			msg.put("flag", false);
			return JSON.toJSONString(msg);
		}
	}

	@Override
	public String authenticationPublisher(User u) {
		// TODO Auto-generated method stub
		HashMap<String, Object> msg=new HashMap<String,Object>();
		u.setState(ConstantValueUtil.user_waitExamineState);
		u.setJurisdiction(ConstantValueUtil.competitionPublisher_wait);
		if(userDao.modifyUser(u)>0)
		{
			msg.put("msg", "提交申请为发布者成功，等待管理员审核");
			msg.put("flag", true);
			return JSON.toJSONString(msg);
		}else
		{
			msg.put("msg", "提交认证失败");
			msg.put("flag", false);
			return JSON.toJSONString(msg);
		}
	}

}
