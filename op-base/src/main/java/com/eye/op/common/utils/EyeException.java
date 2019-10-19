package com.eye.op.common.utils;

public class EyeException extends Exception{
	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String errorMsg;
	public EyeException(String errorCode, String errorMsg){
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
