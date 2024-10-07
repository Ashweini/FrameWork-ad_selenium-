//4. Login to vtiger application->mouseOverOn more Link->click on campaigns->click on create campaign lookup image->Enter campaignName->
//Click on Product plus img->Handle the PopUp->Product name should be added to campaign createpage->
//click on save Btn->verify whether the campaign is created in campaign Information page and Logout from the application. 
package Organization;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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
import Element_ObjectRepository.vTiger_CompaignPage;
import Element_ObjectRepository.vTiger_CompaignWithProduct_Alertpopup;
import Element_ObjectRepository.vTiger_CreateNewCompaign;
import Element_ObjectRepository.vTiger_CreateNewProductPage;
import Element_ObjectRepository.vTiger_ProductPage;
import Element_ObjectRepository.vtiger_HomePage;
import GenericUtility.BaseClass;
import GenericUtility.BaseClass_Mine_disturbed;
import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyFileUtility;
import GenericUtility.WebDriver_Utility;

public class CompaignWithProductTest extends BaseClass{

	@Test(groups = "smokeTest")
//	public static void main(String[] args) throws Throwable {
	public void compaignWithProduct() throws Throwable {
//		WebDriver driver = new ChromeDriver();

		WebDriver_Utility webDriverUtility = new WebDriver_Utility();
		JavaUtility Jutility = new JavaUtility();
		ExcelUtility ExcelData = new ExcelUtility();
		ExcelUtility ExcelData1 = new ExcelUtility();

//		webDriverUtility.windowMaximize(driver);
//		webDriverUtility.waitforElement(driver);
//
//		PropertyFileUtility ProPertyFile = new PropertyFileUtility();
//		String URL = ProPertyFile.getKeyandVapuePair("url");
//		String USERNAME = ProPertyFile.getKeyandVapuePair("username");
//		String PASSWORD = ProPertyFile.getKeyandVapuePair("password");
//
//		driver.get(URL);
//		// Business Logic
//		Vtiger_LoginPage Login = new Vtiger_LoginPage(driver);
//		Login.LoginToVtiger(USERNAME, PASSWORD);

		vtiger_HomePage vtHomePage = new vtiger_HomePage(driver);
		vtHomePage.clickOnProduct();

		vTiger_ProductPage Productpage = new vTiger_ProductPage(driver);
		Productpage.vtiger_HomePage();

		int ranNum = Jutility.getRandomNum();

		String productName = ExcelData.Excel_Utility("Product", 0, 0) + ranNum;
		System.out.println(productName);

		vTiger_CreateNewProductPage creatProduct = new vTiger_CreateNewProductPage(driver);
		creatProduct.vtiger_NewProductPage(productName);

		creatProduct.saveProductn();

// ---------------------------------------------------------------------------------------------------

//Navigating to campaigns module

		WebElement MoreLink = vtHomePage.getClickOnMoreLink();

		webDriverUtility.moveMouseToElement(driver, MoreLink);
		vtHomePage.clickOnCompaign();

		vTiger_CompaignPage compaignPage = new vTiger_CompaignPage(driver);
		compaignPage.CampaignPage();

		String campData = ExcelData1.Excel_Utility("Campaigns", 0, 0) + ranNum;
		System.out.println(campData);

		vTiger_CreateNewCompaign CompainPage = new vTiger_CreateNewCompaign(driver);
		CompainPage.CreateCampaignPage(campData);
// -----------------------------------------------------------------------
		// window switching
		vTiger_CompaignWithProduct_Alertpopup Productpopup = new vTiger_CompaignWithProduct_Alertpopup(driver);
		Productpopup.CompaignWithProduct();

		webDriverUtility.windowSwitch(driver, "Products&action");

		Productpopup.sendProductName(productName);
		Productpopup.clickOnsearchofPrdName();

		Thread.sleep(2000);
		// dynamic xapth - How?? to Optimize?
//		driver.findElement(By.xpath("//a[text()='" + productName + "']")).click();
		Productpopup.selectproductNameFrompopUp(driver, productName);
		
// -------------------------------------------------------------------------------------------------
		// driver switching back to main win

		webDriverUtility.windowSwitch(driver, "Campaigns&action");
		vtHomePage.SaveCreation();
//		vtHomePage.signOut();

	}

}
