package com.lc.info.base;

public class ResultInfo {
	private Integer resultCode;
	private String resultMsg;
	private Object result;
	
	public ResultInfo() {
		super();
	}
	
	public ResultInfo(Integer resultCode, String resultMsg, Object result) {
		super();
		this.resultCode = resultCode;
		this.resultMsg = resultMsg;
		this.result = result;
	}

	public Integer getResultCode() {
		return resultCode;
	}
	public void setResultCode(Integer resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultMsg() {
		return resultMsg;
	}
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	

}
