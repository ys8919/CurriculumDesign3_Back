package entity;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * ����ʵ��*/
public class Registration implements Serializable{
	private String registrationId; //����ID
	private String competitionId;//����ID
	private String applicantId;//������ID�����Ŷ�ID
	private String registrationTime;//����ʱ��
	private int state;//����״̬
	private String auditeason;//�����Ϣ
	private String competitionIdName;//��������
	private String applicantName;//���������ƻ��߶�������
	public String getCompetitionIdName() {
		return competitionIdName;
	}
	public void setCompetitionIdName(String competitionIdName) {
		this.competitionIdName = competitionIdName;
	}
	public String getApplicantName() {
		return applicantName;
	}
	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}
	public String getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}
	public String getCompetitionId() {
		return competitionId;
	}
	public void setCompetitionId(String competitionId) {
		this.competitionId = competitionId;
	}
	public String getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(String applicantId) {
		this.applicantId = applicantId;
	}
	public String getRegistrationTime() {
		return registrationTime;
	}
	public void setRegistrationTime(String registrationTime) {
		this.registrationTime = registrationTime;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getAuditeason() {
		return auditeason;
	}
	public void setAuditeason(String auditeason) {
		this.auditeason = auditeason;
	}
	
}
