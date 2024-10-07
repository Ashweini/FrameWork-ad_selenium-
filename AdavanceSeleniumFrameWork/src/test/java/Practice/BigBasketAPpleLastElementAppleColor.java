package Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BigBasketAPpleLastElementAppleColor {

	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bigbasket.com/");
		
		driver.findElement(By.xpath("(//input[@class=\"flex-1 w-full leading-md lg:text-sm xl:text-md placeholder-silverSurfer-700\"])[2]")).sendKeys("apple");
		
		Thread.sleep(2000);
		List<WebElement> allElements = driver.findElements(By.xpath("//span[@class=\"Label-sc-15v1nk5-0 QuickSearch___StyledLabel2-sc-rtz2vl-7 gJxZPQ gFDEBU\"]"));
	
		Thread.sleep(2000);
		for (WebElement ele : allElements) {
			System.out.println(ele.getText());
			if(ele.getText().contains("Apple - Red Delicious, Regular"))
			{
				Thread.sleep(2000);
				ele.click();
				break;
				
			}
		}
		
		Thread.sleep(2000);
		Thread.sleep(2000);
		//getDomProperty
		WebElement color = driver.findElement(By.xpath("//h1[@class=\"Description___StyledH-sc-82a36a-2 bofYPK\"]"));
		System.out.println(color.getDomProperty("color"));
	}

}

	
