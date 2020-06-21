package service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import entity.User;

public interface UserListService {
	public int Save(ArrayList<User> u);
	
}
