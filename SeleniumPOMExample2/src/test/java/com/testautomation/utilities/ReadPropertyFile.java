package com.testautomation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadPropertyFile {
	
	Properties prop;

	public ReadPropertyFile() {
		//read config.properties file
		  File src = new File("./src/test/java/com/testautomation/properties/config.properties");
		  
		  try {
		  FileInputStream fis = new FileInputStream(src);
		  prop = new Properties();
		  prop.load(fis);
		  }catch(Exception e) {
			  System.out.println("Unable to read properties file due to: "+e.getMessage());
		  }
	}
	
	public String getProperty(String key) {
		
		return prop.getProperty(key);
	}
	
}
