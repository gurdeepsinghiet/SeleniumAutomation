package com.auto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonFuntionsLib {
	
	WebDriver driver;
	
	CommonFuntionsLib(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public boolean performActions(String Keyword,String value,String xpathExpression)
	{
		if(Keyword.equalsIgnoreCase("Click"))
		{
			driver.findElement(By.xpath(xpathExpression)).click();
			return true;
		}else if(Keyword.equalsIgnoreCase("Input"))
		{
			driver.findElement(By.xpath(xpathExpression)).sendKeys(value);
			return true;
		}else if(Keyword.equalsIgnoreCase("gettext"))
		{
			driver.findElement(By.xpath(xpathExpression)).getText();
			return true;
		}else if(Keyword.equalsIgnoreCase("url"))
		{
			driver.get(value);
		}
		
		return false;
	}
	

}
