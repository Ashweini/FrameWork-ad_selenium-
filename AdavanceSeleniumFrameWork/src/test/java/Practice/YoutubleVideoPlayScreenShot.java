package Practice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class YoutubleVideoPlayScreenShot {

	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.youtube.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//input[@id = 'search']")).sendKeys("Selenium with java");
		driver.findElement(By.id("search-icon-legacy")).click();
		
		driver.findElement(By.xpath("//span[@title='Selenium with Java (Full Crash Course)- 2024 Series']")).click();
		
		Thread.sleep(2000);
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./YouTubeScreenshotImg.png");
		
		FileUtils.copyFile(src, dest);


	}

}
