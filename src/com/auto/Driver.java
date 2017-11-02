package com.auto;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
	
	WebDriver driver;
	
	public WebDriver InitateDriver()
	{
		System.setProperty("webdriver.gecko.driver","E:\\selenium\\geckodriver\\geckodriver.exe");
		  driver=new FirefoxDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  return driver;

	}
	

}
