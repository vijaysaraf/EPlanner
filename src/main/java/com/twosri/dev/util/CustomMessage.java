package com.twosri.dev.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomMessage {
	public static final String NO_CUSTOMER = "No details found for [0]";

	public static String getDescription(String message, final String[] param) {
		for (int i = 0; i < param.length; i++) {
			message = message.replace("[" + i + "]", param[i]);
		}
		log.debug("message {}", message);
		return message;
	}

}
