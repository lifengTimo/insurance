package com.lifeng.insurance.model;

public class WrapResult {
	
	private int errorcode;
	private String errorMsg;
	private Object Context;
	public int getErrorcode() {
		return errorcode;
	}
	public void setErrorcode(int errorcode) {
		this.errorcode = errorcode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public Object getContext() {
		return Context;
	}
	public void setContext(Object context) {
		Context = context;
	}
	public WrapResult() {
		// TODO Auto-generated constructor stub
	}
	public static WrapResult ok(Object object){
		WrapResult result=new WrapResult();
		result.setContext(object);
		result.setErrorcode(0);
		result.setErrorMsg("");
		return result;
	}
	public static WrapResult error(Exception e){
		WrapResult result=new WrapResult();
		result.setErrorcode(500);
		result.setErrorMsg(e.getMessage());
		return result;
	}

}
