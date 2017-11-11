package com.auto;

import java.awt.Toolkit;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Driver {
	
	WebDriver driver;
	
	public WebDriver InitateDriver()
	{
		//System.setProperty("webdriver.gecko.driver","E:\\selenium\\geckodriver\\geckodriver.exe");
		  //driver=new FirefoxDriver();
		  System.setProperty("webdriver.chrome.driver","E:\\selenium\\chromedriver\\chromedriver.exe");
	       DesiredCapabilities capabilities = DesiredCapabilities.chrome();
          capabilities.setCapability("chrome.switches", Arrays.asList("--start-maximized"));
          driver=new ChromeDriver();
         // driver.manage().window().setSize(screenResolution);
		  //driver.manage().window().maximize();
		  //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  return driver;

	}
	

}
