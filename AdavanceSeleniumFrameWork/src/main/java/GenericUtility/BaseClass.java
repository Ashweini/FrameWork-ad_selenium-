package GenericUtility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
import Element_ObjectRepository.vtiger_HomePage;

public class BaseClass {
	
	public  static WebDriver driver;
	//public static WebDriver sdriver;
	@BeforeSuite(groups = {"smokeTest","RegressionTest","Sanity"})
	public void BS()
	{
		System.out.println("DataBase Open");
	}
	
	@BeforeTest(groups = {"smokeTest","RegressionTest","Sanity"})
	public void BT()
	{
		System.out.println("parallel execution");
	}
	
	@BeforeClass(groups = {"smokeTest","RegressionTest","Sanity"})
	public void BC() throws Throwable
	{
		//File_Utility flib = new File_Utility();
		PropertyFileUtility flib = new PropertyFileUtility();
		String BROWSER = flib.getKeyandVapuePair("browser");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if (BROWSER.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			driver=new FirefoxDriver();
		}
		
		System.out.println("Launching Browser");
		//driver = sdriver;
	}
	
	@BeforeMethod(groups = {"smokeTest","RegressionTest","Sanity"})
	public void BM() throws Throwable
	{
		//Webdriver_Utility wlib = new Webdriver_Utility();
		WebDriver_Utility wlib = new WebDriver_Utility();
		  //File_Utility file = new File_Utility();
		PropertyFileUtility file = new PropertyFileUtility();

		wlib.windowMaximize(driver);

		String URL = file.getKeyandVapuePair("url");
		String USERNAME = file.getKeyandVapuePair("username");
		String PASSWORD = file.getKeyandVapuePair("password");
		
//reading url from command line
//		String URL = System.getProperty("url");
//		String USERNAME = System.getProperty("username");
//		String PASSWORD = System.getProperty("password");

		driver.get(URL);

		// Business Logics
	//	VtigerLoginPage login = new VtigerLoginPage(driver);
		Vtiger_LoginPage login = new Vtiger_LoginPage(driver);
		login.LoginToVtiger(USERNAME, PASSWORD);

		System.out.println("Login To App");
	}
	@AfterMethod(groups = {"smokeTest","RegressionTest","Sanity"})
	public void AM()
	{
		vtiger_HomePage home = new vtiger_HomePage(driver);
//		home.clickOnAdmLink();
//		home.ClickSignOutLink();
		home.signOut();
		System.out.println("logout from App");
	}
	
	@AfterClass(groups = {"smokeTest","RegressionTest","Sanity"})
	public void AC()
	{
		driver.quit();
		System.out.println("close browser");
	}
	
	@AfterTest(groups = {"smokeTest","RegressionTest","Sanity"})
	public void AT()
	{
		System.out.println("parallel execution");
	}
	
	@AfterSuite(groups = {"smokeTest","RegressionTest","Sanity"})
	public void AS()
	{
		System.out.println("close DataBase");
	
	}	
	


}
