package com.job.portal.core;

import org.springframework.http.HttpStatus;

public class ResponseView {

	private int status = HttpStatus.OK.value();
	private ResponseStatus statusType;
	private String message;
	private IPortalView data;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public ResponseStatus getStatusType() {
		return statusType;
	}
	public void setStatusType(ResponseStatus statusType) {
		this.statusType = statusType;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public IPortalView getData() {
		return data;
	}
	public void setData(IPortalView data) {
		this.data = data;
	}
	
	
}
