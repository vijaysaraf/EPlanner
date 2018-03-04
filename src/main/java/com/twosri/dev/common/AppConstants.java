package com.twosri.dev.common;

public enum AppConstants {

	WARNING("WARNING"), INFO("INFO"), ERROR("ERROR");

	final String description;

	AppConstants(String desc) {
		this.description = desc;
	}

	public String getDescription() {
		return this.description;
	}

}
