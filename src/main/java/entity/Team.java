package entity;

import java.io.Serializable;
import java.util.ArrayList;
/**����ʵ��*/
public class Team implements Serializable{
	private String Id;//Ψһ��ʶID
	private String teamId;//����ID
	private String teamName;//��������
	private String memberId;//��ԱID
	private Integer state;//����״̬
	private Integer type;//�Ŷ�����
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
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
}
