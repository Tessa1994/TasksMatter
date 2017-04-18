package com.xuan.controller;

public class ResponseInfo {
	public String message = "";
	public int code = 0;
	public Object data;
	
	public ResponseInfo(int code, String message, Object data){
		this.code=code;
		this.message=message;
		this.data = data;
	}
	public ResponseInfo(int code, String message){
		this.code=code;
		this.message=message;
	}

}
