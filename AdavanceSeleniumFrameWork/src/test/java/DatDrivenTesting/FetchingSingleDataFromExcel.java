package DatDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingSingleDataFromExcel {

	public static void main(String[] args) throws Throwable {

		//step1 - path connection
		FileInputStream fin = new FileInputStream("./src/test/resources/TestData.xlsx");
		
		//step 2 - excel file in read mode
		Workbook book = WorkbookFactory.create(fin);
		
		//step 3 - get control on sheet
		Sheet sheet = book.getSheet("Sheet1");
		
		//step 4: get control on row
		Row row = sheet.getRow(3);
		
		//step 5: get control on cell
		Cell cell = row.getCell(2);
		
		//step 6 : fetching the cell value
//		String excelData = cell.getStringCellValue();
//		System.out.println(excelData);
		
//		double excelData = cell.getNumericCellValue();
//		System.out.println(excelData);
		
		//DataFormatter
		DataFormatter format = new DataFormatter();
		String excelData = format.formatCellValue(cell);
		System.out.println(excelData);
		
	}

}
