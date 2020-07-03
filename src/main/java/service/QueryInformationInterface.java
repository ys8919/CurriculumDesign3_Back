package service;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import entity.Competition;
import entity.User;

public interface QueryInformationInterface {
	public String queryCompetition(HashMap<String, Object> value) ;
	public String queryCompetitionVague(HashMap<String, Object> value);
	
	public String queryUser(HashMap<String, Object> u);
	public String fuzzyQueryUser(HashMap<String, Object> u);
	public String queryUserMyself(User u);
	public String queryRegistration(HashMap<String, Object> r);
	public String queryPublisher(HashMap<String, Object> u);
	public String fuzzyQueryByState(HashMap<String, Object> value);
}
