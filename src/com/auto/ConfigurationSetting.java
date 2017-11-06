package com.auto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ConfigurationSetting {

	// we need to create two thing Configurationsetting.java class and config
	// folder
	// in config folder we need to create the config.txt file
	// config file contains environment parametrses.
	// Configuration setting file is used to read the config.txt file and put it
	// in hashMap

	public static String url;
	public static String browser;
	public static String geckoDriverpath;
	public static String waitinsec;

	public static HashMap<String, String> map = new HashMap<String, String>();

	// create the method to read the file from bufferreader
	public static HashMap readConfigFile() throws IOException {
		FileReader fr = new FileReader("./config/config.txt");
		BufferedReader b = new BufferedReader(fr);
		String line = b.readLine();
		while (line != null) {
			// String x=line;
			String[] linearray = line.split("=");
			map.put(linearray[0], linearray[1]);
			line = b.readLine();

		}

		return map;

	}

	public static String getUrl() {
		return map.get("url");
	}

	public static String getBrowser() {
		return map.get("browser");
	}

	public static String getGeckoDriverpath() {
		return map.get("geckoDriverPath");
	}

	public static String getWaitinsec() {
		return map.get("waitTime");
	}

	public static void main(String[] args) throws IOException {
		ConfigurationSetting.readConfigFile();
		System.out.println(map);

		System.out.println(ConfigurationSetting.getUrl());
	}

}
