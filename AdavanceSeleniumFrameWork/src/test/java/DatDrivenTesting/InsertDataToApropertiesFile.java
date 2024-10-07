package DatDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InsertDataToApropertiesFile {

	public static void main(String[] args) throws Throwable {


		Properties pro1 = new Properties();
		pro1.setProperty("browser", "chrome");
		pro1.setProperty("url", "http://localhost:8888/");
		pro1.setProperty("username", "admin");
		pro1.setProperty("password", "admin");
		
		//properties in file in write mode
		FileOutputStream fout = new FileOutputStream("./src/test/resources/PropertiesData.properties");
		pro1.store(fout, "PropertiesData");
		
//-----------------------------------------------------------------------------------------------------------------------
		
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

