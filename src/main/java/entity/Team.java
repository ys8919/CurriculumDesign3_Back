package entity;

import java.io.Serializable;
import java.util.ArrayList;
/**����ʵ��*/
public class Team implements Serializable{
	private String Id;//Ψһ��ʶID
	private String teamId;//����ID
	private String teamName;//��������
	private String memberId;//��ԱID
	private int state;//����״̬
	private int type;//�Ŷ�����
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
