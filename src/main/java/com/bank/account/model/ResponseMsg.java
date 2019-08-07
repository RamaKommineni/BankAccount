package com.bank.account.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ResponseMsg {
	
	private int returnCode;
	private String response;
	private Object data;
	private String message;
	
	public ResponseMsg(int returnCode, String response, Object data, String message) {
		super();
		this.returnCode = returnCode;
		this.response = response;
		this.data = data;
		this.message = message;
	}
	
	public ResponseMsg() {
		// TODO Auto-generated constructor stub
	}

	public int getReturnCode() {
		return returnCode;
	}
	
	public void setReturnCode(int returnCode) {
		this.returnCode = returnCode;
	}
	
	public String getResponse() {
		return response;
	}
	
	public void setResponse(String response) {
		this.response = response;
	}
	
	public Object getData() {
		return data;
	}
	
	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ResponseMsg [returnCode=" + returnCode + ", response=" + response + ","
				+ " data=" + data +  ", message=" + message + "]";
	}

	
}
