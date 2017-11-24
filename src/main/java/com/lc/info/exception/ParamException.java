package com.lc.info.exception;

import com.lc.info.constant.Constant;

@SuppressWarnings("serial")
public class ParamException extends RuntimeException{
	private Integer errorCode;

	public ParamException() {
		super();
	}
	
	public ParamException(String errorMsg){
		super(errorMsg);
		this.errorCode = Constant.OPS_ERROR_CODE;
	}
	
	public ParamException(Integer errorCode, String errorMsg){
		super(errorMsg);
		this.errorCode = errorCode;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
}
