package com.lc.info.base;

import com.lc.info.exception.AuthException;
import com.lc.info.exception.LoginException;
import com.lc.info.exception.ParamException;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class GlobalExceptionHandler extends BaseController{
	private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler( value = {ParamException.class,IllegalAccessError.class})
	@ResponseBody
	public ResultInfo handlerParamException(ParamException paramException){
		logger.error("参数异常：{}", paramException);
		return failure(paramException);
	}
	
	@ExceptionHandler( value = LoginException.class)
	public ResultInfo handlerLoginException(LoginException loginException) {
		logger.error("登录异常：{}", loginException);
		return failure(loginException.getMessage());
	}
	
	
	@ExceptionHandler( value = AuthException.class)
	public ResultInfo handlerLoginException(AuthException authException) {
		logger.error("权限认证异常：{}", authException);
		return failure(authException.getMessage());
	}
	
	
	@ExceptionHandler( value = Exception.class)
	public ResultInfo handlerException(Exception paramException) {
		logger.error("系统异常：{}", paramException);
		return failure("系统异常");
	}
}
