package GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass1 {
	
	public static WebDriver driver;


	@BeforeSuite(groups = {"smokeTest","regressionTest","sanityTest"})
	public void BS() {
		System.out.println("DataBase Open");
	}

	@BeforeTest(groups = {"smokeTest","regressionTest","sanityTest"})
	public void BT() {
		System.out.println("parallel execution");
	}
	
//	@Parameters("BROWSER")
	@BeforeClass(groups = {"smokeTest","RegressionTest","Sanity"})
//	public void BC(String BROWSER) throws Throwable {
	public void BC() throws Throwable {
		
		PropertyFileUtility flib = new PropertyFileUtility();
		String browser = flib.getKeyandVapuePair("browser");
		
//		if(BROWSER.equalsIgnoreCase("chrome")) {
//			driver = new ChromeDriver();
//		}
//		else if(BROWSER.equalsIgnoreCase("firefox")){
//			driver = new FirefoxDriver();
//		}
//		else if(BROWSER.equalsIgnoreCase("edge")) {
//			driver = new EdgeDriver();
//		}
//		else {
//			driver = new ChromeDriver();
//		}
//		System.out.println("Launching browser");
//		driver = sdriver;
	}
	
	

}
