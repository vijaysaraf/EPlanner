package com.twosri.dev.converter;

import java.beans.Statement;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.xcontent.ToXContent;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class Converter {

	public List<Object> convertResponseList(SearchResponse response) throws Exception {
		{
			List<Object> list = new ArrayList<>();
			XContentBuilder builder = XContentFactory.jsonBuilder();
			response.toXContent(builder, ToXContent.EMPTY_PARAMS);
			System.out.println(builder.toString());
			JSONObject json = new JSONObject(builder.string());
			JSONObject hits = json.getJSONObject("hits");
			JSONArray array = hits.getJSONArray("hits");
			for (int i = 0; i < array.length(); i++) {
				JSONObject source = array.getJSONObject(i).getJSONObject("_source");
				String id = (String) array.getJSONObject(i).get("_id");
				list.add(genericMapper(source, id));
			}
			return list;
		}
	}

	private Object genericMapper(JSONObject source, String id) throws Exception {
		Object obj = getInstance();
		Field[] fields = obj.getClass().getDeclaredFields();
		Statement stmt;
		
		for (int i = 0; i < fields.length; i++) {
			System.out.println(fields[i]);
			String property = fields[i].getName();
			if (!property.equals("id")) {
				String replacer = String.valueOf(property.charAt(0));
				stmt = new Statement(obj, "set".concat(property.replaceFirst(replacer, replacer.toUpperCase())),
						new Object[] { source.getString(property) });
				
			}else {
				stmt = new Statement(obj, "setId", new Object[] { id });
			}
			stmt.execute();
		}
		return obj;
	}

	protected abstract Object getInstance();

}
