package entity;

import java.io.Serializable;
/**用户实体*/
public class User implements Serializable{
private String userId;
private String userName;
private String passwd;
private String address;
private String tel;
private String schoolName;
private String stuNumber;
private String realName;
private String education;
private int jurisdiction;
private String email;
private int state;//认证状态

public int getState() {
	return state;
}
public void setState(int state) {
	this.state = state;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPasswd() {
	return passwd;
}
public void setPasswd(String passwd) {
	this.passwd = passwd;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getTel() {
	return tel;
}
public void setTel(String tel) {
	this.tel = tel;
}
public String getSchoolName() {
	return schoolName;
}
public void setSchoolName(String schoolName) {
	this.schoolName = schoolName;
}
public String getStuNumber() {
	return stuNumber;
}
public void setStuNumber(String stuNumber) {
	this.stuNumber = stuNumber;
}
public String getRealName() {
	return realName;
}
public void setRealName(String realName) {
	this.realName = realName;
}
public String getEducation() {
	return education;
}
public void setEducation(String education) {
	this.education = education;
}
public int getJurisdiction() {
	return jurisdiction;
}
public void setJurisdiction(int jurisdiction) {
	this.jurisdiction = jurisdiction;
}
@Override
public String toString() {
	return "User [userId=" + userId + ", userName=" + userName + ", passwd=" + passwd + ", address=" + address
			+ ", tel=" + tel + ", schoolName=" + schoolName + ", stuNumber=" + stuNumber + ", realName=" + realName
			+ ", education=" + education + ", jurisdiction=" + jurisdiction + ", email=" + email + "]";
}


}
