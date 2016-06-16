package com.micro.utils;

// 这里是杭州市文一西路
public class Result {
	// 返回信息
	private boolean success;

	// 失败信息
	private String errorMsg;

	// 存放对象
	private Object object;

	public boolean isSuccess() {
		return success;
	}

	public Result setSuccess(boolean success) {
		this.success = success;
		return this;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public Result setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
		return this;
	}

	public Object getObject() {
		return object;
	}

	public Result setObject(Object object) {
		this.object = object;
		return this;
	}

}
