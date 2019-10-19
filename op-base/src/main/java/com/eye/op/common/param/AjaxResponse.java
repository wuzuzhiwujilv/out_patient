package com.eye.op.common.param;


public class AjaxResponse {
	public AjaxResponse(){
		this.msg="";
		this.success=true;
	}
	
	public AjaxResponse(String msg){
		this.msg=msg;
		this.success=true;
	}
	
	public AjaxResponse(Boolean success, String msg){
		this.msg=msg;
		this.success=success;
	}
	
	private boolean success;
	private String msg;
	private Object data;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Object getData() {
		return data;
	}
	
}
