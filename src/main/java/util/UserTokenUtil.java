package util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.Test;
import org.springframework.scheduling.annotation.Scheduled;

public class UserTokenUtil {
	private static HashMap<String, String> userMap = new HashMap<>();
	private static String lifeCylce = "1800";// �����

	public static void setUserSession(String userid) {
		// ���ɹ���ʱ��
		long expireTime = System.currentTimeMillis() + Integer.parseInt(lifeCylce) * 1000;
		userMap.put(userid, expireTime + "");
		// ����ѹ���user
		long nowTime = System.currentTimeMillis();
		if (System.currentTimeMillis() % 1800000 == 0) {
			cleanExpireSession();
		}
	}

	public static void delUserSession(String userid) {
		userMap.remove(userid);
	}
	public static boolean isUserSession(String userid)
	{
		return userMap.containsKey(userid);
	}
	public static boolean getUserSession(String userid) {
		boolean flag = false;
		// ��ȡ����ʱ��
		String userExpireTime = userMap.get(userid);
		if (userExpireTime != null) {
			long expireTime = Long.parseLong(userExpireTime);
			// �жϵ�ǰ�û��Ƿ����
			if (System.currentTimeMillis() > expireTime) {
				flag = false;
			} else {
				flag = true;
			}
		}
		return flag;
	}

	@Test
	public void testget() {
		String userid = "1001";
		//long nowtime = System.currentTimeMillis();
		setUserSession(userid);
		System.out.println(getUserSession("1001"));
	}
	@Scheduled(cron=" */30 * * * * *")
	public static void cleanExpireSession() {
		for (Iterator<Map.Entry<String, String>> it = userMap.entrySet().iterator(); it.hasNext();) {
			Map.Entry<String, String> item = it.next();
			long expireTime = Long.parseLong(userMap.get(item.getKey()));
			if (System.currentTimeMillis() > expireTime) {
				it.remove();
			}
		}
	}
}