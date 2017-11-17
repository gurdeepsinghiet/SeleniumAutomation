package com.auto;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonFuntionsLib {
	final static Logger logger = Logger.getLogger(CommonFuntionsLib.class);
	WebDriver driver;

	CommonFuntionsLib(WebDriver driver) {
		this.driver = driver;
	}

	public boolean performActions(String Keyword, String value,
			String xpathExpression) throws NumberFormatException,
			InterruptedException {
		if (Keyword.equalsIgnoreCase("Click")) {
			driver.findElement(By.xpath(xpathExpression)).click();
			logger.info("Click is performed sucessfully");
			
			return true;
		} else if (Keyword.equalsIgnoreCase("Input")) {
			driver.findElement(By.xpath(xpathExpression)).sendKeys(value);
			logger.info("Input is performed sucessfully");
			return true;
		} else if (Keyword.equalsIgnoreCase("gettext")) {
			driver.findElement(By.xpath(xpathExpression)).getText();
			logger.info("getText is performed sucessfully");
			return true;
		} else if (Keyword.equalsIgnoreCase("url")) {
			driver.get(value);
			logger.info("Url is opened sucessfully");
			return true;
		} else if (Keyword.equalsIgnoreCase("CloseBrowser")) {
			driver.close();
			logger.info("Browser is closed sucessfully");
				return true;
		} else if (Keyword.equalsIgnoreCase("sleep")) {
			if (value.equalsIgnoreCase("level1")) {
				Thread.sleep(3000);
			} else if (value.equalsIgnoreCase("level2")) {
				Thread.sleep(7000);
			} else if (value.equalsIgnoreCase("level3")) {
				Thread.sleep(15000);
			} else if (value.equalsIgnoreCase("level4")) {
				Thread.sleep(20000);
			} else if (value.equalsIgnoreCase("level4")) {
				Thread.sleep(25000);
			} else {
				Thread.sleep(5000);
			}
			logger.info("sleep is done sucessfully");
			return true;
		}
		else if(Keyword.equalsIgnoreCase("VerifyText")){
			
		     if(value.equalsIgnoreCase(driver.findElement(By.xpath(xpathExpression)).getText()))
		     {
		    	 logger.info("verify text true");
		    	 return true;
		     }else{
		    	 logger.info("verify text failed");
		    	 return false;
		     }
			
		}
		else if(Keyword.equalsIgnoreCase("Pop"))
		{
			
		}
	

		return false;
	}

}
