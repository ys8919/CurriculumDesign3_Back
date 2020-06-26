package service;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Registration;

public interface RegistrationInterface {
	
	public String registration(HashMap<String, Object> rg);
	
	public String examine( Registration registration);
}
