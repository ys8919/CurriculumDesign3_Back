package service;

import entity.User;

public interface CertifiedInterface {
	public String authentication(User u);
	public String examine(User u);
	public String authenticationPublisher(User u);
}
