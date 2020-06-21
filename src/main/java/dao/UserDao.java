package dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.User;



public interface UserDao {
	public int insertUser(User u);
	public int modifyUser(User u);
	public int deleteUser(User u);
	public ArrayList<User> queryUser(User u);
}
