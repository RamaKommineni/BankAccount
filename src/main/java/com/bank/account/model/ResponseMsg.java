package com.bank.account.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ResponseMsg {
	
	private int returnCode;
	private String response;
	private Object data;
	private String status;
	private String id;
	private String message;
	
	public ResponseMsg(int returnCode, String response, Object data, String status, String id, String message) {
		super();
		this.returnCode = returnCode;
		this.response = response;
		this.data = data;
		this.status = status;
		this.id = id;
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
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ResponseMsg [returnCode=" + returnCode + ", response=" + response + ", data=" + data + ", status="
				+ status + ", id=" + id + ", message=" + message + "]";
	}

	
}
