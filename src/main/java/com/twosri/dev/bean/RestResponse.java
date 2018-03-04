package com.twosri.dev.bean;

import com.twosri.dev.common.AppConstants;

import lombok.Data;

@Data
public class RestResponse {
	String message;
	String messageType;
	Object object;

	public void setErrorMessage(String message) {
		this.setMessageType(AppConstants.ERROR.getDescription());
		this.setMessage(message);
	}

	public void setInfoMessage(String message) {
		this.setMessageType(AppConstants.INFO.getDescription());
		this.setMessage(message);
	}

	public void setWarningMessage(String message) {
		this.setMessageType(AppConstants.WARNING.getDescription());
		this.setMessage(message);
	}
}
