package com.auto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonFuntionsLib {

	WebDriver driver;

	CommonFuntionsLib(WebDriver driver) {
		this.driver = driver;
	}

	public boolean performActions(String Keyword, String value,
			String xpathExpression) throws NumberFormatException,
			InterruptedException {
		if (Keyword.equalsIgnoreCase("Click")) {
			driver.findElement(By.xpath(xpathExpression)).click();
			return true;
		} else if (Keyword.equalsIgnoreCase("Input")) {
			driver.findElement(By.xpath(xpathExpression)).sendKeys(value);
			return true;
		} else if (Keyword.equalsIgnoreCase("gettext")) {
			driver.findElement(By.xpath(xpathExpression)).getText();
			return true;
		} else if (Keyword.equalsIgnoreCase("url")) {
			driver.get(value);
		} else if (Keyword.equalsIgnoreCase("CloseBrowser")) {
			driver.close();
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
		}

		return false;
	}

}
