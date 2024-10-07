package Organization.copy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyFileUtility;

public class dummy {

//	public static void main(String[] args) {
//
////		//step-1 : create a object of FileInputStream class
////		FileInputStream fis = new FileInputStream("./src/test/resources/PropertiesData.properties");
////		
////		//step 2: do the object creation file and load the keys present in properties file
////		Properties pro = new Properties();
////		pro.load(fis);
////		
////		//step 3 : call key from properties file with the help of getproperties methos
////		String browser = pro.getProperty("browser");
////		String URL = pro.getProperty("url");
////		String USERNAME = pro.getProperty("username");
////		String PASSWORD = pro.getProperty("password");
//		
//		PropertyFileUtility ProPertyFile = new PropertyFileUtility();
//		String URL = ProPertyFile.getKeyandVapuePair("url");
//		String USERNAME =ProPertyFile.getKeyandVapuePair("username");
//		String PASSWORD =ProPertyFile.getKeyandVapuePair("password");
//		
//		WebDriver driver= new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		
//		driver.get(URL);
//		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(USERNAME);
//		driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
//		
//		//driver.findElement(By.cssSelector("[src=\"themes/softed/images/btnL3Add.gif\"]")).click();
//		driver.findElement(By.cssSelector("[href=\"index.php?module=Accounts&action=index\"]")).click();
//		driver.findElement(By.cssSelector("[src=\"themes/softed/images/btnL3Add.gif\"]")).click();
//		
////		Random ran = new Random();
////		int ranNum = ran.nextInt(1000);
//		JavaUtility Jutility = new JavaUtility();
//		int ranNum = Jutility.getRandomNum();
//		
//////fetching data from Excel to fill Organization page 
////		FileInputStream fin = new FileInputStream("C:\\Users\\HP\\Downloads\\TestData.xlsx");
////		
////		//step 2 - excel file in read mode
////		Workbook book = WorkbookFactory.create(fin);
////		
////		//step 3 - get control on sheet
////		Sheet sheet = book.getSheet("Organizatin");
////		
////		//step 4: get control on row
////		Row row = sheet.getRow(0);
////		
////		//step 5: get control on cell
////		Cell cell = row.getCell(0);
////		
////		//step6:-fetching the cell value
////		String OrgName = cell.getStringCellValue()+ranNum;
////		
////		driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(OrgName);
//		
//		ExcelUtility ExcelData = new ExcelUtility();
//		String OrgName = ExcelData.Excel_Utility("Organizatin", 0, 0)+ranNum;
//		System.out.println(OrgName);
////------------------------------------------------------------------------------------------------------
//		
////		Row row1 = sheet.getRow(1);
////		
////		//step5:- get control on cell
////		Cell cell1 = row1.getCell(0);
////		
////		//step6:-fetching the cell value
////		DataFormatter format = new DataFormatter();
////		String phnNum = format.formatCellValue(cell1);
//		
//		String phnNum = ExcelData.getExcelDataUsingFormatter("Organizatin", 1, 0);
//		
//		driver.findElement(By.cssSelector("[id=\"phone\"]")).sendKeys(phnNum);
////-----------------------------------------------------------------------------------------------------
//		
////	    Row row2 = sheet.getRow(2);
////		
////		//step5:- get control on cell
////		Cell cell2 = row2.getCell(0);
////		
////		//step6:-fetching the cell value
////		String email = format.formatCellValue(cell2); 
//		
//		String email = ExcelData.getExcelDataUsingFormatter("Organizatin", 2, 0);
//		
//		driver.findElement(By.cssSelector("[id=\"email1\"]")).sendKeys(email);
//		Thread.sleep(2000);
//		driver.findElement(By.cssSelector("[title=\"Save [Alt+S]\"]")).click();
//		
////-----------------------------------------------------------------------------------------------
//		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
//		
//		if(actData.contains(OrgName))
//		{
//			System.out.println("Organization name is created");
//		}
//		else
//		{
//			System.out.println("Organization name not created");
//		}
//		
//		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
//		driver.findElement(By.linkText("Sign Out")).click();
//		
//				
//
//		
//
//	
//
//	}

}
