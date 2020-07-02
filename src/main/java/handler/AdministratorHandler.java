package handler;

import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.alibaba.fastjson.JSON;

import util.UserTokenUtil;

public class AdministratorHandler implements HandlerInterceptor {
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
			
			HashMap<String, Object> msg=new HashMap<String, Object>();
			
	       
			if(UserTokenUtil.isUserSession(request.getHeader("token"))) {
				if(UserTokenUtil.administratorsUser(request.getHeader("token")))
				{
					response.reset();
					return true;
				}else {
					response.setCharacterEncoding("UTF-8");
			        response.setContentType("application/json;charset=UTF-8");
			        PrintWriter pw=response.getWriter();
					msg.put("msg", "ÄúÃ»ÓÐÈ¨ÏÞ");
					msg.put("jurisdictionFlag", false);
					pw.write(JSON.toJSONString(msg));
					pw.flush();
					return false;
				}
			}else {
				//Î´µÇÂ¼
				response.setCharacterEncoding("UTF-8");
		        response.setContentType("application/json;charset=UTF-8");
		        PrintWriter pw=response.getWriter();
				msg.put("msg", "ÇëµÇÂ¼");
				msg.put("loginFlag", false);
				pw.write(JSON.toJSONString(msg));
				pw.flush();
				return false;
			}
}
}
