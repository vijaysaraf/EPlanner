package com.twosri.dev.util;

public enum AppEnum {
	
	// Customers
	_PATH_CUSTOMER_LIST("/admin/customer/list"),
	_PATH_CUSTOMER_MODIFY("/admin/customer/modify"),
	_PATH_CUSTOMER_EDIT("/admin/customer/edit"),
	
	// Users
	_PATH_USER("/admin/user");

	private String value;

	AppEnum(String value) {
		this.value = value;
	}
	public String getValue() {
		return this.value;
	}

}
