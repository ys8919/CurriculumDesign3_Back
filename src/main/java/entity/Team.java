package entity;

import java.io.Serializable;
import java.util.ArrayList;
/**队伍实体*/
public class Team implements Serializable{
	private String Id;//唯一标识ID
	private String teamId;//队伍ID
	private String teamName;//队伍名称
	private String memberId;//成员ID
	private int state;//报名状态
	private int type;//团队类型
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
}
