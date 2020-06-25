package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.User;



public interface UserDao {
	public int insertUser(User u);
	public int modifyUser(User u);
	public int deleteUser(User u);
	public int changePassword(User u);
	public int forgetPassword(User u);
	public ArrayList<User> queryUser(HashMap<String, Object> u);
	public ArrayList<User> fuzzyQueryUser(HashMap<String, Object> u);

	public ArrayList<User> login(User u);
	public int queryUserTotal(HashMap<String, Object> u);
	public int fuzzyQueryUserTotal(HashMap<String, Object> u);
}
