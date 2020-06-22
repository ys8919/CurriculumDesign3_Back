package service;

import entity.User;

public interface LoginRegisterInterface {

	public  String login(User u);
	public  String register(User u);
	public String forgetPassword(User u);
	public String changePassword(User u);
}
