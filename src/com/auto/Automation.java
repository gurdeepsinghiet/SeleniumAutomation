package com.auto;

import java.io.FileNotFoundException;
import java.io.IOException;

import jxl.Sheet;
import jxl.read.biff.BiffException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Automation {
	final static Logger logger = Logger.getLogger(Automation.class);
	public static void main(String[] args) throws FileNotFoundException, IOException, BiffException, NumberFormatException, InterruptedException {
		  Driver d=new Driver();
		  ExcelSheetDriver Es=new ExcelSheetDriver();
		  ExcelSheetDriver Es1=new ExcelSheetDriver();
		  ExcelSheetDriver Es2=new ExcelSheetDriver();
		  Sheet TestSuitsheet=Es.getWorksheet("./TestCases/TestSuit.xls", "Sheet1");
		   // WebDriver driver=d.InitateDriver();
		 
		  //driver.get("https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=13&ct=1510644152&rver=6.7.6640.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fnlp%3d1%26RpsCsrfState%3d02d9a83a-4a66-dba6-f710-5248efde97fc&id=292841&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=90015");
		  Utilities.loadlog4jfile();
		  int c=Es.columnCount();
		  int r=Es.rowCount();
		   
		   for(int i=1;i<r;i++)
		   {
			 String SNo=Es.readCell(TestSuitsheet,0, i);
			
			 String Description=Es.readCell(TestSuitsheet,1, i);
			 String ExecutionFlag=Es.readCell(TestSuitsheet,2, i);
			 System.out.println("TestSuit:"+SNo);
			 System.out.println("TestSuit:"+Description);
			 System.out.println("TestSuit:"+ExecutionFlag);
			
			 if(ExecutionFlag.equalsIgnoreCase("Y")){
				 Sheet TestCasesheet= Es1.getWorksheet("./TestCases/TestCase.xls", Description);
				  int rTestcase=Es1.rowCount();
				  int cTestCase=Es1.columnCount();
				  
				for(int k=1;k<rTestcase;k++)
				{
					String snoTestCase=Es1.readCell(TestCasesheet,0, k);
					String TestCaseNumber=Es1.readCell(TestCasesheet,1, k);
					String testcaseDescription=Es1.readCell(TestCasesheet,2, k);
					String testcaseExecutionFlag=Es1.readCell(TestCasesheet,3, k);
					 System.out.println("TestCases:"+snoTestCase);
					 System.out.println("TestCases:"+TestCaseNumber);
					 System.out.println("TestCases:"+testcaseDescription);
					 System.out.println("TestCases:"+testcaseExecutionFlag);
					 
					
					if(testcaseExecutionFlag.equalsIgnoreCase("y"))
					{
						 Sheet TestStepsheet=Es2.getWorksheet("./TestCases/TestStep.xls", Description);
						 int rTestSteps=Es2.rowCount();
						 int cTestSteps=Es2.columnCount();
						 WebDriver driver=d.InitateDriver();
						 CommonFuntionsLib comlib=new CommonFuntionsLib(driver);
						 for(int w=1;w<rTestSteps;w++)
						 {
							String snoTestSteps=Es.readCell(TestStepsheet,0, w);
							String TestStepcaseNumber=Es.readCell(TestStepsheet,1, w);
							String desTestSteps=Es.readCell(TestStepsheet,2, w);
							String xpathTestSteps=Es.readCell(TestStepsheet,3, w);
							String value=Es.readCell(TestStepsheet,4, w);
							String keywordTestSteps=Es.readCell(TestStepsheet,5, w);
							if(TestCaseNumber.equalsIgnoreCase(TestStepcaseNumber)){
							 System.out.println(snoTestSteps);
							 System.out.println(desTestSteps);
							 System.out.println(xpathTestSteps);
							 System.out.println(value);
							 System.out.println(keywordTestSteps);
						
							 comlib.performActions(keywordTestSteps, value, xpathTestSteps);
							 }
							
						 }
						 
					}
				}
						  
			 }
		   }
		   
		   Es.closeworkbook();
		   Es2.closeworkbook();
		   Es1.closeworkbook();
		/*  comlib.performActions("url", "https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin", "");
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
		
		 driver.quit();*/
	}

}
