package Organization.copy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
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
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Element_ObjectRepository.Vtiger_LoginPage;
import Element_ObjectRepository.Vtiger_LoginPage;
import Element_ObjectRepository.vtiger_HomePage;
import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyFileUtility;
import GenericUtility.WebDriver_Utility;

@Listeners(GenericUtility.ListenerImplementation.class)
public class CreateCompaign {

	 @Test(retryAnalyzer = GenericUtility.RetryImp.class)
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
		
		//normal approach
//		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(USERNAME);
//		driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		
		//
//		Vtiger_Login1 Login = new Vtiger_Login1(driver);
//		Login.getUserTextField().sendKeys(USERNAME);
//		Login.getPasswordTextField().sendKeys(PASSWORD);
//		Login.getLoginButton().click();
		
		//Business Logic 
		Vtiger_LoginPage Login = new Vtiger_LoginPage(driver);
		Login.LoginToVtiger(USERNAME, PASSWORD);
		
//		WebElement MoreLink = driver.findElement(By.linkText("More"));
		
		vtiger_HomePage vtHomePage = new vtiger_HomePage(driver);
		WebElement MoreLink = vtHomePage.getClickOnMoreLink();
		
//		Actions act = new Actions(driver);
//		act.moveToElement(MoreLink).perform();
		webDriverUtility.moveMouseToElement(driver, MoreLink);
		
		
		//driver.findElement(By.linkText("Campaigns")).click();
		vtHomePage.getclickOnCampaigns();
		driver.findElement(By.cssSelector("[title=\"Create Campaign...\"]")).click();
		
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
//		Sheet sheet = book.getSheet("Campaigns");
//		
//		//step 4: get control on row
//		Row row = sheet.getRow(0);
//		
//		//step 5: get control on cell
//		Cell cell = row.getCell(0);
//		
//		//step6:-fetching the cell value
//		String compaignName = cell.getStringCellValue()+ranNum;
		
		ExcelUtility ExcelData = new ExcelUtility();
		String compaignName = ExcelData.Excel_Utility("Campaigns", 0, 0)+ranNum;
		System.out.println(compaignName);
		
		driver.findElement(By.cssSelector("[name=\"campaignname\"]")).sendKeys(compaignName);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[title=\"Save [Alt+S]\"]")).click();
		
		String actData = driver.findElement(By.cssSelector("[id=\"dtlview_Campaign Name\"]")).getText();
		
		if(actData.contains(compaignName))
		{
			System.out.println("Organization name is created");
		}
		else
		{
			System.out.println("Organization name not created");
		}
		
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		
	}

}
