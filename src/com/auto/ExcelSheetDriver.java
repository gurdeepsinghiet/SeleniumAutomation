package com.auto;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.log4j.Logger;

//import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelSheetDriver {
	Sheet worksheet;
	Workbook workbook =null;
	Hashtable<Object,Object> dict= new Hashtable<Object,Object>();
	
	Logger logger = Logger.getLogger("ExcelSheetDriver");
	
	public Sheet getWorksheet(String WorkbookPath,String sheetname) throws BiffException, IOException
	{
		//Initialize
		
		workbook = Workbook.getWorkbook(new File(WorkbookPath));
		worksheet = workbook.getSheet(sheetname);
		return worksheet;
		
	}
	
	public void closeworkbook()
	{
		workbook.close();
	}
	
	public void setSheetName(String sheetName)
	{
		if (workbook != null)
			worksheet = workbook.getSheet(sheetName);
		else
			logger.info("Please initialize the Excelsheet Driver");
	}
	
	//Returns the Number of Rows
	public int rowCount()
	{
		return worksheet.getRows();	
	}

	//Returns the Number of Columns
	public int columnCount()
	{
		return worksheet.getColumns();
	}
	
	//Returns the Cell value by taking row and Column values as argument
	public String readCell(Sheet sheet,int column,int row)
	{
		return sheet.getCell(column,row).getContents();
	}
	
	//Create Column Dictionary to hold all the Column Names
	/*public void columnData(Sheet worksheet)
	{
		//Iterate through all the columns in the Excel sheet and store the value in Hashtable
		for(int col=0;col < worksheet.getColumns();col++)
		{
			dict.put(readCell(worksheet,col,0), col);
		}
		logger.info("hasmap dict :"+dict);
	}
	*/
/*	//Create Column Dictionary to hold all the Column Names
	public void rowData(Sheet worksheet)
	{
		//Iterate through all the columns in the Excel sheet and store the value in Hashtable
		for(int row=0; row < worksheet.getRows(); row++)
		{
			dict.put(readCell(worksheet,0, row), row);
			logger.info("dic:="+dict);
		}
		
	}
	
	//Read Column Names
	public int getCell(String colName)
	{
		try {
			int value;
			value = ((Integer) dict.get(colName)).intValue();
			return value;
		} catch (NullPointerException e) {
			return (0);

		}
	}*/
}


