//4. Login to vtiger application->mouseOverOn more Link->click on campaigns->click on create campaign lookup image->Enter campaignName->
//Click on Product plus img->Handle the PopUp->Product name should be added to campaign createpage->
//click on save Btn->verify whether the campaign is created in campaign Information page and Logout from the application. 

package Organization.copy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CompaignProduct_multipleScenarios {

	public static void main(String[] args) throws Throwable {
//		//step-1 : create a object of FileInputStream class
//				FileInputStream fis = new FileInputStream("./src/test/resources/PropertiesData.properties");
//				
//				//step 2: do the object creation file and load the keys present in properties file
//				Properties pro = new Properties();
//				pro.load(fis);
//				
//				//step 3 : call key from properties file with the help of getproperties methos
//				String browser = pro.getProperty("browser");
//				String URL = pro.getProperty("url");
//				String USERNAME = pro.getProperty("username");
//				String PASSWORD = pro.getProperty("password");
//				
//				WebDriver driver= new ChromeDriver();
//				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//				
//				driver.get(URL);
//				driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(USERNAME);
//				driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys(PASSWORD);
//				driver.findElement(By.id("submitButton")).click();
//				
//				WebElement MoreLink = driver.findElement(By.linkText("More"));
//				Actions act = new Actions(driver);
//				act.moveToElement(MoreLink).perform();
//				
//				driver.findElement(By.linkText("Campaigns")).click();
//				driver.findElement(By.cssSelector("[title=\"Create Campaign...\"]")).click();
//				
//				Random ran = new Random();
//				int ranNum = ran.nextInt(1000);
//				
//		//fetching data from Excel to fill Product page 
//				FileInputStream fin = new FileInputStream("C:\\Users\\HP\\Downloads\\TestData.xlsx");
//				
//				//step 2 - excel file in read mode
//				Workbook book = WorkbookFactory.create(fin);
//				
//				//step 3 - get control on sheet
//				Sheet sheet = book.getSheet("Campaigns");
//				
//				//step 4: get control on row
//				Row row = sheet.getRow(0);
//				
//				//step 5: get control on cell
//				Cell cell = row.getCell(0);
//				
//				//step6:-fetching the cell value
//				String compaignName = cell.getStringCellValue()+ranNum;
//				
//				driver.findElement(By.cssSelector("[name=\"campaignname\"]")).sendKeys(compaignName);
//				driver.findElement(By.cssSelector("[title=\"Select\"]")).click();
////				System.out.println(driver.getTitle());
//			
//				
//				String mainWin = driver.getWindowHandle();
//				System.out.println(mainWin);
//				
//				Set<String> allId = driver.getWindowHandles();
//				System.out.println(allId);
//				
//				for(String id : allId) {
//					if(!mainWin.equals(id)) {
//						driver.switchTo().window(id);
//						//Thread.sleep(2000);
//				       driver.findElement(By.xpath("//a[@id=\"1\"]")).click();
//					}
//				}
//				
////				driver.findElement(By.cssSelector("[name=\"campaignname\"]")).sendKeys(compaignName);
////				driver.findElement(By.cssSelector("[title=\"Save [Alt+S]\"]")).click();
//				
//				String actData = driver.findElement(By.cssSelector("[name=\"campaignname\"]")).getText();
//				
//				if(actData.contains(compaignName))
//				{
//					System.out.println("Organization name is created");
//				}
//				else
//				{
//					System.out.println("Organization name not created");
//				}
//				
//				driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
//				driver.findElement(By.linkText("Sign Out")).click();
	}

}
