package entity;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * 报名实体*/
public class Registration implements Serializable{
	private String registrationId; //报名ID
	private String competitionId;//竞赛ID
	private String applicantId;//报名人ID或者团队ID
	private String registrationTime;//报名时间
	private int state;//报名状态
	private String auditeason;//审核消息
	private String competitionIdName;//竞赛名称
	private String applicantName;//报名人名称或者队伍名称
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
