package com.eye.op.common.utils;

public class ErrorConstant {
	public static final String GENERATE_ERROR_MSG = "系统错误";
	public static final String ENCRYPTION_FAIL = "加密失败";
	public static final String VERIFY_CODE_FAIL = "验证码不正确";
	public static final String USER_EXIST = "已存在用户";

	public static final EyeException GENERATE_EXCEPTION = new EyeException("1000", "系统错误");
}	
