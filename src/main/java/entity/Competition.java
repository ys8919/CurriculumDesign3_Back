package entity;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * ����ʵ��*/
public class Competition  implements Serializable{
	private String competitionId;//����ID
	private String competitionName;//��������
	private String chargePersonId;//����������
	private String competitionInfo;//������Ϣ
	private String releaseTime;//����ʱ��
	private String competitionTime;//����ʱ��
	private String registrationTimeStart;//������ʼʱ��
	private String registrationTimeEnd;//��������ʱ��
	private Integer checkUser;//�Ƿ���Ҫ���
	private Integer type;//��������
	private Integer state;//״̬
	private String auditeason;//��˽����Ϣ
	private String chargePersonName;//��������������

	

	public String getCompetitionId() {
		return competitionId;
	}
	public void setCompetitionId(String competitionId) {
		this.competitionId = competitionId;
	}
	public String getCompetitionName() {
		return competitionName;
	}
	public void setCompetitionName(String competitionName) {
		this.competitionName = competitionName;
	}
	public String getChargePersonId() {
		return chargePersonId;
	}
	public void setChargePersonId(String chargePersonId) {
		this.chargePersonId = chargePersonId;
	}
	public String getCompetitionInfo() {
		return competitionInfo;
	}
	public void setCompetitionInfo(String competitionInfo) {
		this.competitionInfo = competitionInfo;
	}
	public String getReleaseTime() {
		return releaseTime;
	}
	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}
	public String getCompetitionTime() {
		return competitionTime;
	}
	public void setCompetitionTime(String competitionTime) {
		this.competitionTime = competitionTime;
	}
	public String getRegistrationTimeStart() {
		return registrationTimeStart;
	}
	public void setRegistrationTimeStart(String registrationTimeStart) {
		this.registrationTimeStart = registrationTimeStart;
	}
	public String getRegistrationTimeEnd() {
		return registrationTimeEnd;
	}
	public void setRegistrationTimeEnd(String registrationTimeEnd) {
		this.registrationTimeEnd = registrationTimeEnd;
	}
	public Integer getCheckUser() {
		return checkUser;
	}
	public void setCheckUser(Integer checkUser) {
		this.checkUser = checkUser;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getAuditeason() {
		return auditeason;
	}
	public void setAuditeason(String auditeason) {
		this.auditeason = auditeason;
	}
	public String getChargePersonName() {
		return chargePersonName;
	}
	public void setChargePersonName(String chargePersonName) {
		this.chargePersonName = chargePersonName;
	}
	
}
