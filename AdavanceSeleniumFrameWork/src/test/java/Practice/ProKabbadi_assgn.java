package Practice;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProKabbadi_assgn {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.prokabaddi.com/standings");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		////p[text()='Puneri Paltan']/ancestor::div[@class='table-row-wrap']/descendant::p[@class="count"]
		List<WebElement> matches = driver.findElements(By.xpath("//p[text()='Jaipur Pink Panthers']/ancestor::div[@class='table-row-wrap']/descendant::p[@class=\"count\"]"));
		for (WebElement match : matches) {
			System.out.println(match.getText());
		}
	
		////p[text()='Puneri Paltan']/ancestor::div[@class='table-row-wrap']/descendant::li[@class="form-item win"]
		List<WebElement> forms = driver.findElements(By.xpath("//p[text()='Jaipur Pink Panthers']/ancestor::div[@class='table-row-wrap']/descendant::li[@class=\"form-item win\"]"));
		for (WebElement form : forms) {
			System.out.println(form.getText());
		}
	}

}
