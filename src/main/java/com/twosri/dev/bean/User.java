package com.twosri.dev.bean;

import lombok.Data;

@Data
public class User {
	private String id;
	private String userId;
	private String passcode;
	private boolean active;
}
