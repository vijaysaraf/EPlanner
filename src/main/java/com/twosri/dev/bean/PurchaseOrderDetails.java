package com.twosri.dev.bean;

import java.util.Date;

import lombok.Data;

@Data
public class PurchaseOrderDetails {

	private Customer customer;
	private double width;
	private double height;
	private long quantity;
	private String remarks;
}
