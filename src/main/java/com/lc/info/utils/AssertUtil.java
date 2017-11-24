package com.lc.info.utils;

import com.lc.info.constant.Constant;
import com.lc.info.exception.ParamException;
import org.apache.commons.lang3.StringUtils;

public class AssertUtil {
	/**
	 * 对象   校验
	 */
	public static void isNotEmpty(Object value,String... msg){
		if(value == null){
			throw new ParamException(loadMsg(msg));
		}
	}
	public static void isNotEmpty(Object value,Integer code,String... msg){
		if(value == null){
			throw new ParamException(code,loadMsg(msg));
		}
	}
	
	
	
	
	/**
	 * String 参数校验
	 */
	public static void isNotEmpty(String value,String... msg){
		if(StringUtils.isBlank(value)){
			throw  new ParamException(loadMsg(msg));
		}
	}
	public static void isNotEmpty(String value,Integer code,String... msg){
		if(StringUtils.isBlank(value)){
			throw  new ParamException(code,loadMsg(msg));
		}
	}
	
	
	
	/**
	 *Integer 参数校验 
	 */
	public static void isNotEmpty(Integer value,String... msg){
		isTrue((value == null || value < 1), msg);
	}
	
	
	public static void isTrue(boolean isTrue,String... msg){
		if(isTrue){
			throw new ParamException(loadMsg(msg));
		}
	}
	
	/**
	 * 处理输入的信息
	 */
	public static String loadMsg(String... msg){
		String message =Constant.OPS_ERROR_MSG;
		if(msg != null){
			message  = msg[0];
		}
		return message;
	}
}
