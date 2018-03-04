package com.twosri.dev.bean;

import lombok.Data;

@Data
public class CustomException {
	
	String errorCode;
	String displayMessage;
	String stackTrace;

}
