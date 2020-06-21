package handler;

import java.io.PrintWriter;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.HandlerInterceptor;

import com.alibaba.fastjson.JSON;

public class LoginHandler implements HandlerInterceptor {
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
			PrintWriter  pw=response.getWriter();
			HashMap<String, Object> msg=new HashMap<String, Object>();
			if(UserTokenUtil.isUserSession(request.getParameter("token"))) {
				if(UserTokenUtil.getUserSession(request.getParameter("token")))
				{
					return true;
				}else {
					//µÇÂ¼³¬Ê±
					UserTokenUtil.delUserSession(request.getParameter("token"));
					response.setCharacterEncoding("UTF-8");
			        response.setContentType("application/json;charset=UTF-8");
					msg.put("msg", "µÇÂ¼³¬Ê±£¬ÇëÖØÐÂµÇÂ¼");
					msg.put("flag", false);
					pw.write(JSON.toJSONString(msg));
					return false;
				}
			}else {
				//Î´µÇÂ¼
				msg.put("msg", "ÇëµÇÂ¼");
				msg.put("flag", false);
				pw.write(JSON.toJSONString(msg));
				return false;
			}
	}

}
