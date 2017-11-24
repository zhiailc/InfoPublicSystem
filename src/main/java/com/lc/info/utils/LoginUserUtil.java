package com.lc.info.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

public class LoginUserUtil {


	/**
	 * 从cookie中获取userId
	 * @param request
	 * @return
	 */
	public static Integer releaseUserIdFromCookie(HttpServletRequest request) {
		String userIdString = CookieUtil.getCookieValue(request, "userId");
		if (StringUtils.isBlank(userIdString)) {
			return null;
		}
		Integer userId = UserIDBase64.decoderUserID(userIdString);
		return userId;
	}

	/**
	 * 从cookie中获取userId
	 * @param request
	 * @return
	 */
	public static String releaseUserNameFromCookie(HttpServletRequest request) {
		String userName = CookieUtil.getCookieValue(request, "userName");
		return userName;
	}

}
