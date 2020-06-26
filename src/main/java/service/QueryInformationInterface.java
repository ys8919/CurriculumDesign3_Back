package service;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import entity.Competition;

public interface QueryInformationInterface {
	public String queryCompetition(HashMap<String, Object> value) ;
	public String queryCompetitionVague(HashMap<String, Object> value);
	
	public String queryUser(HashMap<String, Object> u);
	public String fuzzyQueryUser(HashMap<String, Object> u);
	
	public String queryRegistration(HashMap<String, Object> r);
}
