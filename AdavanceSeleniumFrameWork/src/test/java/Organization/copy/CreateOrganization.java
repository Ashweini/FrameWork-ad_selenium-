//1. Login to vtiger application->click on organizations link->click on create organization lookup image->Enter organisation name,
//phone number and email->click on save Btn->verify whether the organization is created in Organization Information page and Logout from the 
//application 

package Organization.copy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Element_ObjectRepository.Vtiger_LoginPage;
import Element_ObjectRepository.vTigerOrganizationPage;
import Element_ObjectRepository.vTiger_CreateNewOrganization_Page;
import Element_ObjectRepository.vTiger_OrganizationConfirmationPage;
import Element_ObjectRepository.vtiger_HomePage;
import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyFileUtility;
import GenericUtility.WebDriver_Utility;

public class CreateOrganization {

	public static void main(String[] args) throws Throwable {
		
		PropertyFileUtility ProPertyFile = new PropertyFileUtility();
		WebDriver_Utility webDriverUtility = new WebDriver_Utility();
		JavaUtility Jutility = new JavaUtility();
		ExcelUtility ExcelData = new ExcelUtility();
		
		String URL = ProPertyFile.getKeyandVapuePair("url");
		String USERNAME =ProPertyFile.getKeyandVapuePair("username");
		String PASSWORD =ProPertyFile.getKeyandVapuePair("password");
		
		WebDriver driver= new ChromeDriver();
		webDriverUtility.windowMaximize(driver);
		webDriverUtility.waitforElement(driver);
		
		driver.get(URL);
		Vtiger_LoginPage Login = new Vtiger_LoginPage(driver);
		Login.LoginToVtiger(USERNAME, PASSWORD);
		
		vtiger_HomePage vtHomePage = new vtiger_HomePage(driver);
		vtHomePage.clickOnOrganization();
		vTigerOrganizationPage CreateOrg = new vTigerOrganizationPage(driver);
		CreateOrg.clickOnCreateOrganization();
		
		int ranNum = Jutility.getRandomNum();
		String OrgName = ExcelData.Excel_Utility("Organization", 0, 0)+ranNum;
		
		vTiger_CreateNewOrganization_Page CreateOrganizationPage = new vTiger_CreateNewOrganization_Page(driver);
		CreateOrganizationPage.EnterOrganizationName(OrgName);
		System.out.println(OrgName);
//------------------------------------------------------------------------------------------------------

		String phnNum = ExcelData.getExcelDataUsingFormatter("Organization", 1, 0);
		CreateOrganizationPage.EnterPhoneNum(phnNum);
//-----------------------------------------------------------------------------------------------------
		
		String email = ExcelData.getExcelDataUsingFormatter("Organization", 2, 0);
		CreateOrganizationPage.EnterEmail(email);
	
		vtHomePage.SaveCreation();
//-----------------------------------------------------------------------------------------------
		vTiger_OrganizationConfirmationPage OrgConfrmPage = new vTiger_OrganizationConfirmationPage(driver);
		String actData = OrgConfrmPage.ExtractOrgTextField();
		
		if(actData.contains(OrgName))
		{
			System.out.println("Organization name is created");
		}
		else
		{
			System.out.println("Organization name not created");
		}
		
		vtHomePage.signOut();
		

		//package Organization;
		//
		//import java.io.FileInputStream;
		//import java.io.FileNotFoundException;
		//import java.time.Duration;
		//import java.util.Properties;
		//import java.util.Random;
		//
		//import org.apache.poi.ss.usermodel.Cell;
		//import org.apache.poi.ss.usermodel.DataFormatter;
		//import org.apache.poi.ss.usermodel.Row;
		//import org.apache.poi.ss.usermodel.Sheet;
		//import org.apache.poi.ss.usermodel.Workbook;
		//import org.apache.poi.ss.usermodel.WorkbookFactory;
		//import org.openqa.selenium.By;
		//import org.openqa.selenium.WebDriver;
		//import org.openqa.selenium.chrome.ChromeDriver;
		//import org.openqa.selenium.edge.EdgeDriver;
		//import org.openqa.selenium.firefox.FirefoxDriver;
		//
		//import GenericUtility.ExcelUtility;
		//import GenericUtility.JavaUtility;
		//import GenericUtility.PropertyFileUtility;
		//import GenericUtility.WebDriver_Utility;
		//
		//public class CreateOrganization {
		//
//			public static void main(String[] args) throws Throwable {
//				
//				PropertyFileUtility ProPertyFile = new PropertyFileUtility();
//				WebDriver_Utility webDriverUtility = new WebDriver_Utility();
//				JavaUtility Jutility = new JavaUtility();
//				ExcelUtility ExcelData = new ExcelUtility();
//				
//				String URL = ProPertyFile.getKeyandVapuePair("url");
//				String USERNAME =ProPertyFile.getKeyandVapuePair("username");
//				String PASSWORD =ProPertyFile.getKeyandVapuePair("password");
//				
//				WebDriver driver= new ChromeDriver();
//				webDriverUtility.windowMaximize(driver);
//				webDriverUtility.waitforElement(driver);
//				
//				driver.get(URL);
//				driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(USERNAME);
//				driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys(PASSWORD);
//				driver.findElement(By.id("submitButton")).click();
//				
//				driver.findElement(By.cssSelector("[href=\"index.php?module=Accounts&action=index\"]")).click();
//				driver.findElement(By.cssSelector("[src=\"themes/softed/images/btnL3Add.gif\"]")).click();
//				
//				
//				int ranNum = Jutility.getRandomNum();
//				String OrgName = ExcelData.Excel_Utility("Organizatin", 0, 1)+ranNum;
//				System.out.println(OrgName);
		////------------------------------------------------------------------------------------------------------
		//
//				String phnNum = ExcelData.getExcelDataUsingFormatter("Organizatin", 1, 0);
//				driver.findElement(By.cssSelector("[id=\"phone\"]")).sendKeys(phnNum);
		////-----------------------------------------------------------------------------------------------------
//				
//				String email = ExcelData.getExcelDataUsingFormatter("Organizatin", 2, 0);
//				driver.findElement(By.cssSelector("[id=\"email1\"]")).sendKeys(email);
//				driver.findElement(By.cssSelector("[title=\"Save [Alt+S]\"]")).click();	
		////-----------------------------------------------------------------------------------------------
//				String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
//				
//				if(actData.contains(OrgName))
//				{
//					System.out.println("Organization name is created");
//				}
//				else
//				{
//					System.out.println("Organization name not created");
//				}
//				
//				driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
//				driver.findElement(By.linkText("Sign Out")).click();
//				
//						
		//
		//	
		
	}

}
