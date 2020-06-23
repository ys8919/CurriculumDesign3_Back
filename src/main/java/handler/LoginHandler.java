package handler;

import java.io.PrintWriter;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.HandlerInterceptor;

import com.alibaba.fastjson.JSON;

import util.UserTokenUtil;

public class LoginHandler implements HandlerInterceptor {
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
			
			HashMap<String, Object> msg=new HashMap<String, Object>();
			response.setCharacterEncoding("UTF-8");
	        response.setContentType("application/json;charset=UTF-8");
	        PrintWriter  pw=response.getWriter();
	       
			if(UserTokenUtil.isUserSession(request.getHeader("token"))) {
				if(UserTokenUtil.getUserSession(request.getHeader("token")))
				{
					response.reset();
					return true;
				}else {
					//��¼��ʱ
					UserTokenUtil.delUserSession(request.getHeader("token"));
					msg.put("msg", "��¼��ʱ�������µ�¼");
					msg.put("loginFlag", false);
					pw.write(JSON.toJSONString(msg));
					pw.flush();
					return false;
				}
			}else {
				//δ��¼
				msg.put("msg", "���¼");
				msg.put("loginFlag", false);
				pw.write(JSON.toJSONString(msg));
				pw.flush();
				return false;
			}
	}

}
