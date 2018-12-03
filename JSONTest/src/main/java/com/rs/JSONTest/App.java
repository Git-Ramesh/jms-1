package com.rs.JSONTest;

import org.json.JSONObject;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		String json = "{\n" + 
				"			\"name\": \"Ramesh\",\n" + 
				"			\"age\": 22\n" + 
				"		}";
		JSONObject  jsonObject = new JSONObject(json);
		System.out.println(jsonObject);
		System.out.println(jsonObject.get("name"));
		System.out.println(jsonObject.get("age"));
		System.out.println(jsonObject.has("name"));
	}
}
