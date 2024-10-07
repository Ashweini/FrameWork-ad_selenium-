package GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This method for Excel utility
 * 
 */

public class ExcelUtility {
	
	public  String Excel_Utility(String sheetname, int rowNum, int cellNum) throws Throwable {
	//fetching data from Excel to fill Product page 
	FileInputStream fin = new FileInputStream(IPathConstants.Excelpath);
	
	//step 2 - excel file in read mode
	Workbook book = WorkbookFactory.create(fin);
	
	//step 3 - get control on sheet
	Sheet sheet = book.getSheet(sheetname);
	
	//step 4: get control on row
	Row row = sheet.getRow(rowNum);
	
	//step 5: get control on cell
	Cell cell = row.getCell(cellNum);
	
	//step6:-fetching the cell value
	String ExcelData = cell.getStringCellValue();
	return ExcelData;
	}
	
	public  String getExcelDataUsingFormatter(String sheetname, int rowNum, int cellNum) throws Throwable {
		FileInputStream fin = new FileInputStream(IPathConstants.Excelpath);
		
		//step 2 - excel file in read mode
		Workbook book = WorkbookFactory.create(fin);
		
		//step 3 - get control on sheet
		Sheet sheet = book.getSheet(sheetname);
		
		Row row1 = sheet.getRow(rowNum);
		
		//step5:- get control on cell
		Cell cell1 = row1.getCell(cellNum);
		
		//step6:-fetching the cell value
		DataFormatter format = new DataFormatter();
		String phnNum = format.formatCellValue(cell1);
	
return phnNum;
	}
	
	public Object[][] getDataProviderData(String sheetName) throws Throwable
	{
		
		FileInputStream fis = new FileInputStream(IPathConstants.Excelpath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet(sheetName);
		int lastRow = sheet.getLastRowNum()+1;
		int lastCell = sheet.getRow(0).getLastCellNum();
		
		Object[][] objArr = new Object[lastRow][lastCell];
		
		for (int i = 0; i <lastRow ; i++)
		{
		for (int j = 0; j <lastCell ; j++)
		{
			objArr[i][j]=sheet.getRow(i).getCell(j).toString();
		}	
		}
		
		return objArr;
}
}
