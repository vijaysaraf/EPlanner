package com.twosri.dev.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomMessage {
	
	//GENERIC
	public static final String NO_CUSTOMER = "No details found for [0]";
	public static final String GENERIC_ERROR = "Internal server error occurred! Please contact administrator";
	
	//USERS
	public static final String USER_ALREADY_EXIST = "User [0] already exist";
	public static final String USER_ADDED_SUCCESS = "User [0] created successfully";
	public static final String USERID_IS_NOT_VALID = "Please enter valid UserId";
	public static final String PASSWORD_IS_NOT_VALID = "Please enter valid Password";
	public static final String USER_EDITED_SUCCESS = "User [0] updated successfully";
	public static final String USER_DELETED_SUCCESS = "User [0] deleted successfully";
	

	public static String getMessage(String message, final String[] param) {
		if (param != null) {
			for (int i = 0; i < param.length; i++) {
				message = message.replace("[" + i + "]", param[i]);
			}
		}
		log.debug("message {}", message);
		return message;
	}

}
