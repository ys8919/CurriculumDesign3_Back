package service;

import java.util.HashMap;

import entity.Competition;
import entity.User;

public interface ModifyInformationInterface {
	public String modifyCompetition(Competition competition);
	public String modifyUser(User u);
	public String modifyUserPassword(HashMap<String, Object> u);
}
