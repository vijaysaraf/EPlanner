package com.twosri.dev.bean;

import lombok.Data;

@Data
public class Phase {
	private String id;
	private String name;
	private int defaultManPower;

	public Phase() {
		super();
	}

	public Phase(String id, String name, int defaultManPower) {
		super();
		this.id = id;
		this.name = name;
		this.defaultManPower = defaultManPower;
	}

}
