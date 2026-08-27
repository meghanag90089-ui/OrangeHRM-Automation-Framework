package com.orangehrm.utils;

import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private static Properties properties;
	
	static {
	    try {
	        properties = new Properties();

	        properties.load(
	            ConfigReader.class
	                .getClassLoader()
	                .getResourceAsStream("config.properties")
	        );

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public static String getProperty(String key) {
	    return properties.getProperty(key);
	}

}
