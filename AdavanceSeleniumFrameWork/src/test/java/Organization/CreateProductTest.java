package Organization;

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
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Element_ObjectRepository.Vtiger_LoginPage;
import Element_ObjectRepository.vTiger_CreateNewProductPage;
import Element_ObjectRepository.vTiger_ProductConfirmationPage;
import Element_ObjectRepository.vTiger_ProductPage;
import Element_ObjectRepository.vTiger_ValidationPage;
import Element_ObjectRepository.vtiger_HomePage;
import GenericUtility.BaseClass;
import GenericUtility.BaseClass_Mine_disturbed;
import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyFileUtility;
import GenericUtility.WebDriver_Utility;

//@Listeners(GenericUtility.ListenerImplementation.class)
@Listeners(GenericUtility.ExtendsReportsImp.class)
public class CreateProductTest extends BaseClass {

//	public static void main(String[] args) throws Throwable {
	//@Test(groups = "Sanity")
	@Test(retryAnalyzer =GenericUtility.RetryImp.class) 
	public void createProduct() throws Throwable {

//		WebDriver driver = new ChromeDriver();
//		WebDriver_Utility webDriverUtility = new WebDriver_Utility();
//		PropertyFileUtility ProPertyFile = new PropertyFileUtility();
		JavaUtility Jutility = new JavaUtility();
		ExcelUtility ExcelData = new ExcelUtility();

//		webDriverUtility.windowMaximize(driver);
//
//		String URL = ProPertyFile.getKeyandVapuePair("url");
//		String USERNAME = ProPertyFile.getKeyandVapuePair("username");
//		String PASSWORD = ProPertyFile.getKeyandVapuePair("password");
//
//		webDriverUtility.waitforElement(driver);
//
//		driver.get(URL);
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

		//Assert.fail("im failing the script");
		creatProduct.saveProductn();

		vTiger_ProductConfirmationPage ProductConfirmPage = new vTiger_ProductConfirmationPage(driver);
		String actData = ProductConfirmPage.ProductConfirmationPage();
		
		vTiger_ValidationPage Validation = new vTiger_ValidationPage(driver);
		Validation.ValidateProduct(actData, productName);

//		ProductConfirmPage.signOut();

	}
	
	@Test
	public void m1() {
		System.out.println("I am dummy method");
	}

}
