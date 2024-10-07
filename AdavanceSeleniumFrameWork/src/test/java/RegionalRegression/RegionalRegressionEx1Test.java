package RegionalRegression;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Element_ObjectRepository.vTiger_CompaignPage;
import Element_ObjectRepository.vTiger_CompaignWithProduct_Alertpopup;
import Element_ObjectRepository.vTiger_CreateNewCompaign;
import Element_ObjectRepository.vTiger_CreateNewProductPage;
import Element_ObjectRepository.vTiger_ProductConfirmationPage;
import Element_ObjectRepository.vTiger_ProductPage;
import Element_ObjectRepository.vTiger_ValidationPage;
import Element_ObjectRepository.vtiger_HomePage;
import GenericUtility.BaseClass_Mine_disturbed;
import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import GenericUtility.WebDriver_Utility;

public class RegionalRegressionEx1Test extends BaseClass_Mine_disturbed  {


	@Test(groups = "Sanity")
	public void createProduct() throws Throwable {

		JavaUtility Jutility = new JavaUtility();
		ExcelUtility ExcelData = new ExcelUtility();

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

	}

	@Test(groups = "smokeTest")
	public void compaignWithProduct() throws Throwable {

		WebDriver_Utility webDriverUtility = new WebDriver_Utility();
		JavaUtility Jutility = new JavaUtility();
		ExcelUtility ExcelData = new ExcelUtility();
		ExcelUtility ExcelData1 = new ExcelUtility();

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
		Productpopup.selectproductNameFrompopUp(driver, productName);
		
// -------------------------------------------------------------------------------------------------
		webDriverUtility.windowSwitch(driver, "Campaigns&action");
		vtHomePage.SaveCreation();


	}

}
