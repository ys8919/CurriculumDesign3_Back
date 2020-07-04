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
	/**���ܣ��ύ��֤��Ϣ
	 * mapping:Controller/authentication
	 * ������User 
	 * ����ֵ��*/
	@RequestMapping("authentication")
	public String authentication(@RequestBody User u) {
		return certifiedService.authentication(u);
	}
	/**���ܣ������֤��Ϣ
	 * mapping:Controller/userExamine
	 * ������userId,state("��ͨ��Ϊ999") 
	 * ����ֵ��*/
	@RequestMapping("userExamine")
	public String userExamine(@RequestBody User u) {
		return certifiedService.examine(u);
	}
	/**���ܣ�����Ϊ������
	 * mapping:Controller/authenticationPublisher
	 * ������User 
	 * ����ֵ��*/
	public String authenticationPublisher(@RequestBody User u) {
		return certifiedService.authenticationPublisher(u);
		}
}
