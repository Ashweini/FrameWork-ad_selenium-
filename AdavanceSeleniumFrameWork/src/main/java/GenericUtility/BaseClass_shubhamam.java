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

import Element_ObjectRepository.Vtiger_LoginPage;
import Element_ObjectRepository.vTiger_CompainConfirmationPage;

public class BaseClass_shubhamam {
	
	public WebDriver driver;
	//public static WebDriver sdriver;


	@BeforeSuite(groups = {"smokeTest","regressionTest","sanityTest"})
	public void BS() {
		System.out.println("DataBase Open");
	}

	@BeforeTest(groups = {"smokeTest","regressionTest","sanityTest"})
	public void BT() {
		System.out.println("parallel execution");
	}

//	@Parameters("BROWSER")
	@BeforeClass(groups = {"smokeTest","regressionTest","sanityTest"})
//	public void BC(String BROWSER) throws Throwable {
	public void BC() throws Throwable {
		
		PropertyFileUtility flib = new PropertyFileUtility();
		//File_Utility flib = new File_Utility();
		String BROWSER = flib.getKeyandVapuePair("Browser");

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new FirefoxDriver();
		}

		System.out.println("Launching Browser");
		//sdriver=driver;
	}

//	@Parameters({"URL","USERNAME","PASSWORD"})
	
	@BeforeMethod(groups = {"smokeTest","regressionTest","sanityTest"})
//	public void BM(String URL,String USERNAME,String PASSWORD)  throws Throwable {
	public void BM() throws Throwable {
		//Webdriver_Utility wlib = new Webdriver_Utility();
		WebDriver_Utility wlib = new WebDriver_Utility();
		//File_Utility file = new File_Utility();
		PropertyFileUtility file = new PropertyFileUtility();

		wlib.windowMaximize(driver);

		String URL = file.getKeyandVapuePair("url");
		String USERNAME = file.getKeyandVapuePair("username");
		String PASSWORD = file.getKeyandVapuePair("password");

		
		driver.get(URL);

		// Business Logics
		//VtigerLoginPage login = new VtigerLoginPage(driver);
		Vtiger_LoginPage login = new Vtiger_LoginPage(driver);
		login.LoginToVtiger(USERNAME, PASSWORD);

		System.out.println("Login To App");
	}

//	@AfterMethod(groups = {"smokeTest","regressionTest","sanityTest"})
//	public void AM() {
//		//HomePage home = new HomePage(driver);
////		vTiger_CompainConfirmationPage home = new vTiger_CompainConfirmationPage(driver);
////		home.clickOnAdmLink();
////		home.ClickSignOutLink();
////		vTiger_CompainConfirmationPage CompainConfirmPage = new vTiger_CompainConfirmationPage(driver);
////		System.out.println("Logout from App");
////		CompainConfirmPage.signOut();
//		//System.out.println("logout from App");
//	}

	@AfterClass(groups = {"smokeTest","regressionTest","sanityTest"})
	public void AC() {
		driver.quit();
		System.out.println("close browser");
	}

	@AfterTest(groups = {"smokeTest","regressionTest","sanityTest"})
	public void AT() {
		System.out.println("parallel execution");
	}

	@AfterSuite(groups = {"smokeTest","regressionTest","sanityTest"})
	public void AS() {
		System.out.println("close DataBase");

	}


}
