package com.twosri.dev.util;

public enum AppEnum {
	
	_PATH_USER("/admin/user"),
	_PATH_CUSTOMER("/admin/customer"),
	_PATH_PHASE("/admin/phase"),
	_PATH_REFERENCE("/admin/reference");

	private String value;

	AppEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

}
