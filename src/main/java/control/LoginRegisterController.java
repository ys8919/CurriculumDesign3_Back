package control;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;

import org.junit.runner.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import dao.UserDao;
import entity.User;
import service.LoginRegisterInterface;


@Controller
@RequestMapping("Controller")
@CrossOrigin
public class LoginRegisterController {
	@Resource
	private LoginRegisterInterface loginRegister;
	
	@ResponseBody
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(@RequestBody User u)
	{	
		return loginRegister.login(u);
	}
	@RequestMapping("reginster")
	@ResponseBody
	public String reginster(@RequestBody User u) {
		return loginRegister.register(u);
	}
	
}