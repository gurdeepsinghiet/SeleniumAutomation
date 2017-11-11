package com.auto;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Automation {
	final static Logger logger = Logger.getLogger(Automation.class);
	public static void main(String[] args) throws FileNotFoundException, IOException {
		  Driver d=new Driver();
		  
		  WebDriver driver=d.InitateDriver();
		  CommonFuntionsLib comlib=new CommonFuntionsLib(driver);
		  Utilities.loadlog4jfile();
		  comlib.performActions("url", "https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin", "");
		// driver.get("https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		 comlib.performActions("Input", "Gurdeep singhiet", "//input[@id='identifierId']");
		// driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("Gurdeepsinghiet");
		 comlib.performActions("click", "", "//span[@class='RveJvd snByac']");
		 //driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).click();
		 logger.info("automation donr");
		 
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		 driver.quit();
	}

}
