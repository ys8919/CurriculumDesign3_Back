package util;

public class ConstantValueUtil {

	/**
	 * 普通用户*/
	public final static int ordinaryUsers=1;
	/**
	 * 竞赛发布者*/
	public final static int competitionPublisher=2;
	/**
	 * 管理员*/
	public final static int administrators=3;
	/**
	 * 未审核竞赛发布者*/
	public final static int competitionPublisher_wait=4;
	
	/**
	 * 用户未认证状态*/
	public final static int user_waitState=1;
	/**
	 * 用户认证待审核状态*/
	public final static int user_waitExamineState=2;
	/**
	 * 用户未已认证状态*/
	public final static int user_authenticatedState=3;
	/**
	 * 用户认证不通过*/
	public final static int user_Fail=999;
	/**
	 * 报名需审核*/
	public final static int check=2;
	/**
	 * 不需审核*/
	public final static int noCheck=1;
	
	/**
	 * 队伍等待加入状态*/
	public final static int Team_waitState=1;
	/**已加入队伍状态*/
	public final static int Team_joinState=2;
	/**报名待审核状态*/
	public final static int  Registration_waitState=1;
	/**报名成功状态*/
	public final static int  Registration_successState=2;
	/**已安排考场状态*/
	public final static int  Registration_arrangeState=3;
	
	/**待审核状态*/
	public final static int  Competition_waitState=1;
	/**已审核状态*/
	public final static int Competition_releaseState=2;
	/**停止报名状态*/
	public final static int Competition_StopRegistrationState=3;
	/**比赛结束状态*/
	public final static int Competition_endState=4;
	/**团队成员*/
	public final static int Team_member=1;
	/**队长*/
	public final static int Team_leader=2;
	/**
	 * 队伍类型*/
	public final static int CompetitionType_person=1;
	public final static int CompetitionType_team=2;
	/**
	 * 审核不通过*/
	public final static int Competition_Fail=999;
}
