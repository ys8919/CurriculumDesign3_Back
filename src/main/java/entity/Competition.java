package entity;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * 竞赛实体*/
public class Competition  implements Serializable{
	private String competitionId;//竞赛ID
	private String competitionName;//竞赛名称
	private String chargePersonId;//竞赛发布者
	private String competitionInfo;//竞赛信息
	private String releaseTime;//生成时间
	private String competitionTime;//比赛时间
	private String registrationTimeStart;//报名开始时间
	private String registrationTimeEnd;//报名结束时间
	private Integer checkUser;//是否需要审核
	private Integer type;//比赛类型
	private Integer state;//状态
	private String auditeason;//审核结果消息
	private String chargePersonName;//竞赛发布者名称

	

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
