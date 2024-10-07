package DatDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FecthingDataFromPropertiesFile {

	public static void main(String[] args) throws Throwable {

//pulling back
		//connection to read the data from property file
		//connection to the physical file path
		//step-1 : create a object of FileInputStream class
		FileInputStream fis = new FileInputStream("./src/test/resources/PropertiesData.properties");
		
		//step 2: do the object creation file and load the keys present in properties file
		Properties pro = new Properties();
		pro.load(fis);
		
		//step 3 : call key from properties file with the help of getproperties methos
		String browser = pro.getProperty("browser");
		String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");
		
		
		WebDriver driver;
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
		
		driver.get(URL);
		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
	}

}
