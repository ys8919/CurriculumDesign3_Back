package dao;

import java.util.ArrayList;
import java.util.HashMap;

import entity.Registration;

public interface RegistrationDao {
	public int modifyRegistration(Registration registration);
	public int deleteRegistration(Registration registration);
	public int insertRegistration(Registration registration);
	public int queryRegistrationTotal(HashMap<String, Object> r);
	public ArrayList<Registration> queryRegistration(HashMap<String, Object> r);
}
