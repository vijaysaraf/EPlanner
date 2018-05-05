package com.twosri.dev.bean;

import lombok.Data;

@Data
public class Calculation {

	private String id;
	private String productType;
	private int givenManPower;
	private int calculatedManHours;
}
