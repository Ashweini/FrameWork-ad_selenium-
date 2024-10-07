package TestNGPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import GenericUtility.WebDriver_Utility;

public class DataProviderEx3 {
	
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
	public Object[][] readData() throws Throwable{
		JavaUtility JavaUtil = new JavaUtility();
		int randNum = JavaUtil.getRandomNum();
		Object[][] onjArr = new Object[3][3];
		
		ExcelUtility exlUtil = new ExcelUtility();
		Object[][] value = exlUtil.getDataProviderData("DataProvider");
		return value;
		
		
	}

}
