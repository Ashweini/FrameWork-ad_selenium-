package Organization.POMClassCopyforReference;

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
import org.testng.annotations.Test;

import Element_ObjectRepository.Vtiger_LoginPage;
import Element_ObjectRepository.Vtiger_LoginPage;
import Element_ObjectRepository.vTiger_CompaignPage;
import Element_ObjectRepository.vTiger_CompainConfirmationPage;
import Element_ObjectRepository.vTiger_CreateNewCompaign;
import Element_ObjectRepository.vTiger_ValidationPage;
import Element_ObjectRepository.vtiger_HomePage;
import GenericUtility.BaseClass_Mine_disturbed;
import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyFileUtility;
import GenericUtility.WebDriver_Utility;

public class CreateCompaign extends BaseClass_Mine_disturbed{

//	public static void main(String[] args) throws Throwable {
	
	@Test
	public void CreateCompaign() throws Throwable {

//		PropertyFileUtility ProPertyFile = new PropertyFileUtility();
		WebDriver_Utility webDriverUtility = new WebDriver_Utility();
		JavaUtility Jutility = new JavaUtility();
		ExcelUtility ExcelData = new ExcelUtility();

//		String URL = ProPertyFile.getKeyandVapuePair("url");
//		String USERNAME = ProPertyFile.getKeyandVapuePair("username");
//		String PASSWORD = ProPertyFile.getKeyandVapuePair("password");

//		WebDriver driver = new ChromeDriver();
		webDriverUtility.windowMaximize(driver);
		webDriverUtility.waitforElement(driver);

//		driver.get(URL);
//
//		// Business Logic
//		Vtiger_LoginPage Login = new Vtiger_LoginPage(driver);
//		Login.LoginToVtiger(USERNAME, PASSWORD);

		vtiger_HomePage vtHomePage = new vtiger_HomePage(driver);
		WebElement MoreLink = vtHomePage.getClickOnMoreLink();

		webDriverUtility.moveMouseToElement(driver, MoreLink);
		vtHomePage.clickOnCompaign();

		vTiger_CompaignPage compaignPage = new vTiger_CompaignPage(driver);
		compaignPage.CampaignPage();

		int ranNum = Jutility.getRandomNum();

		String compaignName = ExcelData.Excel_Utility("Campaigns", 0, 0) + ranNum;
		System.out.println(compaignName);

		vTiger_CreateNewCompaign CompainPage = new vTiger_CreateNewCompaign(driver);
		CompainPage.CreateCampaignPage(compaignName);
		Thread.sleep(2000);
		CompainPage.saveCampaignn();

		vTiger_CompainConfirmationPage CompainConfirmPage = new vTiger_CompainConfirmationPage(driver);
		String actData = CompainConfirmPage.ComainConfirmationPage();
		
		vTiger_ValidationPage Validation = new vTiger_ValidationPage(driver);
		Validation.ValidateCompaign(actData, compaignName);

//		CompainConfirmPage.signOut();
	}

}
