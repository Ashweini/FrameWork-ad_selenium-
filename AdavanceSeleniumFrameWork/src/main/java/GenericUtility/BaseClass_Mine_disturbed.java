package GenericUtility;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


import org.testng.annotations.Parameters;

import Element_ObjectRepository.Vtiger_LoginPage;
import Element_ObjectRepository.vTiger_CompainConfirmationPage;

public class BaseClass_Mine_disturbed {
	
	public WebDriver driver;
	public static WebDriver sdriver;
	@BeforeSuite(groups = {"smokeTest","RegressionTest","Sanity"})
	public void BS() {
		System.out.println("Database open");
	}

	@BeforeTest(groups = {"smokeTest","RegressionTest","Sanity"})
	public void BT() {
		System.out.println("Parallel execution");
	}
	
//	@Parameters("BROWSER")
	@BeforeClass(groups = {"smokeTest","RegressionTest","Sanity"})
//	public void BC(String BROWSER) throws Throwable {
	public void BC() throws Throwable {
		
		PropertyFileUtility flib = new PropertyFileUtility();
		String browser = flib.getKeyandVapuePair("browser");
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else {
			driver = new ChromeDriver();
		}
		System.out.println("Launching browser");
		driver = sdriver;
	}
	
//	@Parameters({"URL", "USERNAME", "PASSWORD"})
//	@BeforeMethod(groups = {"smokeTest","RegressionTest","Sanity"})
//	public void BM(String URL, String USERNAME, String PASSWORD) throws Throwable {
	public void BM() throws Throwable {
		
		PropertyFileUtility ProPertyFile = new PropertyFileUtility();
		WebDriver_Utility webDriverUtility = new WebDriver_Utility();
		
		webDriverUtility.windowMaximize(driver);
		webDriverUtility.waitforElement(driver);
		
		String URL = ProPertyFile.getKeyandVapuePair("url");
		String USERNAME = ProPertyFile.getKeyandVapuePair("username");
		String PASSWORD = ProPertyFile.getKeyandVapuePair("password");
		
		
		driver.get(URL);

		// Business Logic
		Vtiger_LoginPage Login = new Vtiger_LoginPage(driver);
		Login.LoginToVtiger(USERNAME, USERNAME);
		
		System.out.println("Login into App");
	}
//-------------------

	
	@AfterMethod(groups = {"smokeTest","RegressionTest","Sanity"})
	public void AM() {
		vTiger_CompainConfirmationPage CompainConfirmPage = new vTiger_CompainConfirmationPage(driver);
		System.out.println("Logout from App");
		CompainConfirmPage.signOut();
	}
	
//	@AfterClass(groups = {"smokeTest","RegressionTest","Sanity"})
	public void AC() {
		driver.quit();
		System.out.println("closing browser");
	}
	
	@AfterSuite(groups = {"smokeTest","RegressionTest","Sanity"})
	public void AS() {
		System.out.println("Database close");
	}

	@AfterTest(groups = {"smokeTest","RegressionTest","Sanity"})
	public void AT() {
		System.out.println("Parallel execution");
	}
	

	
	
}
