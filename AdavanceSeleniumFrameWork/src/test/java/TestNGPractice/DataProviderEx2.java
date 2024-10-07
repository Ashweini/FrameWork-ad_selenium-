package TestNGPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GenericUtility.JavaUtility;
import GenericUtility.WebDriver_Utility;

public class DataProviderEx2 {
	
	@Test(dataProvider = "readData")
	public void OrgCreate(String orgName, String phNo, String email) throws Throwable {
		
		WebDriver driver = new ChromeDriver();
		
		WebDriver_Utility webUtility = new WebDriver_Utility();
		webUtility.windowMaximize(driver);
		webUtility.waitforElement(driver);
		
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();
		
		driver.findElement(By.cssSelector("[name=\"accountname\"]")).sendKeys(orgName);
		driver.findElement(By.cssSelector("[id=\"phone\"]")).sendKeys(phNo);
		driver.findElement(By.id("email1")).sendKeys(email);
		driver.findElement(By.cssSelector("[title=\"Save [Alt+S]\"]")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
		
}
	
	@DataProvider
	
	public Object[][] readData(){
		
		JavaUtility JavaUtil = new JavaUtility();
		int randNum = JavaUtil.getRandomNum();
		Object[][] onjArr = new Object[3][3];
		onjArr[0][0]="AAA"+randNum;
		onjArr[0][1]="12345533";
		onjArr[0][2]="asd@gmail.com";
		
		onjArr[1][0]="BBB"+randNum;
		onjArr[1][1]="23421234";
		onjArr[1][2]="asd@gmail.com";
		
		onjArr[2][0]="CCC"+randNum;
		onjArr[2][1]="2345433";
		onjArr[2][2]="asd@gmail.com";
		return onjArr;
	}
	
	
	}

