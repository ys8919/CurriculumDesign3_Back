package util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;
import org.springframework.scheduling.annotation.Scheduled;

import net.sf.jsqlparser.parser.Token;

public class UserTokenUtil {
	private static HashMap<String, HashMap<String,Object>> userMap = new HashMap<String, HashMap<String,Object>>();
	private static String lifeCylce = "1800";// 半个钟
	public static void setUserSession(String token,HashMap<String, Object> userHashMap) {
		// 生成过期时间
		long expireTime = System.currentTimeMillis() + Integer.parseInt(lifeCylce) * 1000;
		userHashMap.put("expireTime", expireTime);
		userMap.put(token,userHashMap);
		// 清除已过期user
		long nowTime = System.currentTimeMillis();
		if (System.currentTimeMillis() % 1800000 == 0) {
			cleanExpireSession();
		}
	}

	public static void delUserSession(String token) {
		userMap.remove(token);
	}
	public static boolean isUserSession(String token)
	{
		return userMap.containsKey(token);
	}
	public static boolean getUserSession(String token) {
		boolean flag = false;
		// 获取过期时间
		String userExpireTime = userMap.get(token).get("expireTime").toString();
		if (userExpireTime != null) {
			long expireTime = Long.parseLong(userExpireTime);
			// 判断当前用户是否过期
			if (System.currentTimeMillis() > expireTime) {
				flag = false;
			} else {
				flag = true;
			}
		}
		return flag;
	}
	public static boolean competitionPublisherUser(String token) {
		if(Integer.parseInt(userMap.get(token).get("jurisdiction").toString())==ConstantValueUtil.competitionPublisher)
		{
			return true;
		}else
		{
			return false;
		}
		
	}
	
	public static boolean administratorsUser(String token) {
		
		if(Integer.parseInt(userMap.get(token).get("jurisdiction").toString())==ConstantValueUtil.administrators)
		{
			return true;
		}else
		{
			return false;
		}
	}
	public static String getUserId(String token)
	{
		return userMap.get(token).get("userId").toString();
	}
	public static int getUserState(String token)
	{
		return Integer.parseInt(userMap.get(token).get("state").toString());
	}
	@Scheduled(cron=" */30 * * * * *")
	public static void cleanExpireSession() {
		for (Iterator<Entry<String, HashMap<String, Object>>> it = userMap.entrySet().iterator(); it.hasNext();) {
			Entry<String, HashMap<String, Object>> item = it.next();
			long expireTime = Long.parseLong((String)userMap.get(item.getKey()).get("expireTime"));
			if (System.currentTimeMillis() > expireTime) {
				it.remove();
			}
		}
	}
}