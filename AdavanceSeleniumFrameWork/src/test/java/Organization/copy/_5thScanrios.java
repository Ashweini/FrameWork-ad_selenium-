//5.Login to vtiger application->click on products link->click on create product lookup image->Enter product name->
//click on save Btn->verify whether the product is created in product Information page->click on product link->
//navigate to product table page ->select the product created checkbox->click on delete->
//Handle the Alert popup and verify product deleted or not and Logout from the application 
package Organization.copy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyFileUtility;
import GenericUtility.WebDriver_Utility;

public class _5thScanrios {

	public static void main(String[] args) throws Throwable {
//		//step-1 : create a object of FileInputStream class
//		FileInputStream fis = new FileInputStream("./src/test/resources/PropertiesData.properties");
//		
//		//step 2: do the object creation file and load the keys present in properties file
//		Properties pro = new Properties();
//		pro.load(fis);
//		
//		//step 3 : call key from properties file with the help of getproperties methos
//		String browser = pro.getProperty("browser");
//		String URL = pro.getProperty("url");
//		String USERNAME = pro.getProperty("username");
//		String PASSWORD = pro.getProperty("password");
		
		PropertyFileUtility ProPertyFile = new PropertyFileUtility();
		String URL = ProPertyFile.getKeyandVapuePair("url");
		String USERNAME =ProPertyFile.getKeyandVapuePair("username");
		String PASSWORD =ProPertyFile.getKeyandVapuePair("password");
		
		WebDriver driver= new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriver_Utility webDriverUtility = new WebDriver_Utility();
		webDriverUtility.windowMaximize(driver);
		webDriverUtility.waitforElement(driver);
		
		driver.get(URL);
		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.cssSelector("[title=\"Create Product...\"]")).click();
		
//		Random ran = new Random();
//		int ranNum = ran.nextInt(1000);
		
		JavaUtility Jutility = new JavaUtility();
		int ranNum = Jutility.getRandomNum();
		
//fetching data from Excel to fill Product page 
//		FileInputStream fin = new FileInputStream("C:\\Users\\HP\\Downloads\\TestData.xlsx");
//		
//		//step 2 - excel file in read mode
//		Workbook book = WorkbookFactory.create(fin);
//		
//		//step 3 - get control on sheet
//		Sheet sheet = book.getSheet("Product");
//		
//		//step 4: get control on row
//		Row row = sheet.getRow(0);
//		
//		//step 5: get control on cell
//		Cell cell = row.getCell(0);
//		
//		//step6:-fetching the cell value
//		String productName = cell.getStringCellValue()+ranNum;
		
		ExcelUtility ExcelData = new ExcelUtility();
		String productName = ExcelData.Excel_Utility("Product", 0, 0)+ranNum;
		System.out.println(productName);
		
		driver.findElement(By.xpath("//input[@name=\"productname\"]")).sendKeys(productName);
		driver.findElement(By.cssSelector("[title=\"Save [Alt+S]\"]")).click();
		
		
		
		String actData = driver.findElement(By.cssSelector("[id=\"dtlview_Product Name\"]")).getText();
		
		if(actData.contains(productName))
		{
			System.out.println("Organization name is created");
		}
		else
		{
			System.out.println("Organization name not created");
		}
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//table[@class=\"lvt small\"]/tbody/tr//td//a[text()='"+productName+"']/../preceding-sibling::td//input[@type=\"checkbox\"]")).click();		
		driver.findElement(By.cssSelector("[value=\"Delete\"]")).click();
		//driver.switchTo().alert().accept();
		webDriverUtility.AlertAccept(driver);
		
		List<WebElement> prdList = driver.findElements(By.xpath("(//table[@class=\"lvt small\"]/tbody/tr//td[3])[position()>1]"));
		boolean flag = false;
		
		for (WebElement prdlist1 : prdList) {
			String actData1 = prdlist1.getText();
			if(actData1.contains(productName)) {
				flag = true;
				break;
			}
		}
		if(flag) {
			System.out.println("Product data deleted");
		}
		else {
			System.out.println("Product data is not deleted");
		}
		
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.linkText("Sign Out")).click();

	}

}
