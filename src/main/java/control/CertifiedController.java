package control;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.User;
import service.CertifiedInterface;
import service.impl.CertifiedService;
@Controller
@ResponseBody
@RequestMapping("Controller")
public class CertifiedController {
	@Resource
	private  CertifiedInterface certifiedService;
	/**功能：提交认证信息
	 * mapping:Controller/authentication
	 * 参数：User 
	 * 返回值：*/
	@RequestMapping("authentication")
	public String authentication(@RequestBody User u) {
		return certifiedService.authentication(u);
	}
	/**功能：审核认证信息
	 * mapping:Controller/userExamine
	 * 参数：userId,state("不通过为999") 
	 * 返回值：*/
	@RequestMapping("userExamine")
	public String userExamine(@RequestBody User u) {
		return certifiedService.examine(u);
	}
	/**功能：申请为发布者
	 * mapping:Controller/authenticationPublisher
	 * 参数：User 
	 * 返回值：*/
	public String authenticationPublisher(@RequestBody User u) {
		return certifiedService.authenticationPublisher(u);
		}
}
