package com.auto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Automation {
	
	public static void main(String[] args) {
		
		 System.setProperty("webdriver.gecko.driver","E:\\selenium\\geckodriver\\geckodriver.exe");
		 WebDriver driver=new FirefoxDriver();
		 driver.get("https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		 driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("Gurdeepsinghiet");
		 driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).click();
	
		 
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		 driver.quit();
	}

}
