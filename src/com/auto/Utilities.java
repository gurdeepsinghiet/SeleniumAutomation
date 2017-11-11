package com.auto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;


public class Utilities {
	
	
	public static Properties loadlog4jfile()
			throws FileNotFoundException, IOException {
		Properties log4j = new Properties();
		log4j.load(new FileInputStream("./config/log4j.properties"));
		//log4j.setProperty("log4j.appender.FA.File", "./logs/automation.log");
		PropertyConfigurator.configure(log4j);
		return log4j;
	}

}
