package com.wl.common;

public class ResultInfo<T> {

	private boolean suc;
	private T data;
	private String message;
	private String exception;
	private int count;

	public boolean isSuc() {
		return suc;
	}

	public void setSuc(boolean suc) {
		this.suc = suc;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
