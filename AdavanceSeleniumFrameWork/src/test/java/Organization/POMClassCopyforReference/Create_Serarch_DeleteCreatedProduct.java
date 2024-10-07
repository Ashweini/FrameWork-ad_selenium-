//5.Login to vtiger application->click on products link->click on create product lookup image->Enter product name->
//click on save Btn->verify whether the product is created in product Information page->click on product link->
//navigate to product table page ->select the product created checkbox->click on delete->
//Handle the Alert popup and verify product deleted or not and Logout from the application 
package Organization.POMClassCopyforReference;

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

import Element_ObjectRepository.Vtiger_LoginPage;
import Element_ObjectRepository.vTiger_CreateNewProductPage;
import Element_ObjectRepository.vTiger_ProductConfirmationPage;
import Element_ObjectRepository.vTiger_ProductPage;
import Element_ObjectRepository.vTiger_ValidationPage;
import Element_ObjectRepository.vtiger_HomePage;
import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyFileUtility;
import GenericUtility.WebDriver_Utility;

public class Create_Serarch_DeleteCreatedProduct {

	public static void main(String[] args) throws Throwable {

		PropertyFileUtility ProPertyFile = new PropertyFileUtility();
		WebDriver_Utility webDriverUtility = new WebDriver_Utility();
		JavaUtility Jutility = new JavaUtility();
		ExcelUtility ExcelData = new ExcelUtility();

		String URL = ProPertyFile.getKeyandVapuePair("url");
		String USERNAME = ProPertyFile.getKeyandVapuePair("username");
		String PASSWORD = ProPertyFile.getKeyandVapuePair("password");

		WebDriver driver = new ChromeDriver();

		webDriverUtility.windowMaximize(driver);
		webDriverUtility.waitforElement(driver);

		driver.get(URL);

		Vtiger_LoginPage Login = new Vtiger_LoginPage(driver);
		Login.LoginToVtiger(USERNAME, PASSWORD);

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

		vTiger_ProductConfirmationPage ProductConfirmPage = new vTiger_ProductConfirmationPage(driver);
		String actData = ProductConfirmPage.ProductConfirmationPage();

		vTiger_ValidationPage Validation = new vTiger_ValidationPage(driver);
		Validation.ValidateProduct(actData, productName);
		
		
		vtHomePage.clickOnProduct();
		Thread.sleep(2000);
		//dynamic 
		ProductConfirmPage.dynamicProductName(driver, productName);
		
		
		ProductConfirmPage.clickOnDelete();

		webDriverUtility.AlertAccept(driver);

		ProductConfirmPage.InterateProductList(driver, productName);
		

		Thread.sleep(2000);
		vtHomePage.signOut();

	}

}
