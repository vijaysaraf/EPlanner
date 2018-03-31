package com.twosri.dev.bean;

import lombok.Data;

@Data
public class ElasticResponse {
	// http://localhost:9200/eplanner/customer/1002
	private String _index;
	private String _type;
	private String _id;
	private int _version;
	private boolean found;
	private Object _source;
	
	/*
	 * { "_index": "eplanner", "_type": "customer", "_id": "1002", "_version": 1,
	 * "found": true, "_source": { "id": "1002", "name": "Aabha Saraf", "address":
	 * "Chinchwad", "contact": "9850255154" } }
	 */
}
