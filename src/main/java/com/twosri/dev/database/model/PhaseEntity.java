package com.twosri.dev.database.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "PHASE")
public class PhaseEntity {

	@Id
	private String id;

	@Indexed(unique = true)
	private String name;

	private int defaultManPower;

}
