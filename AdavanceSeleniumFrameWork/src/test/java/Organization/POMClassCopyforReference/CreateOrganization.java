//1. Login to vtiger application->click on organizations link->click on create organization lookup image->Enter organisation name,
//phone number and email->click on save Btn->verify whether the organization is created in Organization Information page and Logout from the 
//application 

package Organization.POMClassCopyforReference;

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
import Element_ObjectRepository.vTiger_ValidationPage;
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
		String USERNAME = ProPertyFile.getKeyandVapuePair("username");
		String PASSWORD = ProPertyFile.getKeyandVapuePair("password");

		WebDriver driver = new ChromeDriver();
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
		String OrgName = ExcelData.Excel_Utility("Organization", 0, 0) + ranNum;

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
		
		vTiger_ValidationPage Validation = new vTiger_ValidationPage(driver);
		Validation.ValidateProduct(actData, OrgName);

		vtHomePage.signOut();

	}

}
