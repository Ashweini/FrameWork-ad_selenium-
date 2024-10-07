import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AssignMent_spiceJet {

	public static void main(String[] args) throws Throwable {
		
		
		//Approach1:- close the notification		
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		
		WebDriver driver = new ChromeDriver(opt);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  
		driver.get("https://www.spicejet.com/");
		
		driver.findElement(By.xpath("//div[text()='round trip']")).click();
		driver.findElement(By.xpath("(//input[@class=\"css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu\"])[1]")).sendKeys("hyd");
		driver.findElement(By.xpath("(//input[@class=\"css-1cwyjr8 r-homxoj r-ubezar r-10paoce r-13qz1uu\"])[2]")).sendKeys("ben");


	}

}
