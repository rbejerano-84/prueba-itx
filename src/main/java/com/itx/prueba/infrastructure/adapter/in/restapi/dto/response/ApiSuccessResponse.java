package com.itx.prueba.infrastructure.adapter.in.restapi.dto.response;

public class ApiSuccessResponse<T> {
	
	private int status = 200;
	private String msg;
	private T data;
	
	
	public ApiSuccessResponse(String msg, T data) {
		super();
		this.msg = msg;
		this.data = data;
	}

	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public T getData() {
		return data;
	}


	public void setData(T data) {
		this.data = data;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}

}