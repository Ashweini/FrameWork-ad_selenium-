package GenericUtility;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebDriver_Utility {
	/**
	 * THis Method used to maximize windpw
	 * @param driver
	 */
		
		public void windowMaximize(WebDriver driver) {
			driver.manage().window().maximize();
		}
		
		/**
		 * THis method for switching windows
		 * @param driver
		 * @param pagetitle
		 */
		
		public void windowSwitch(WebDriver driver,String pagetitle) {
			Set<String> allWins = driver.getWindowHandles();

			Iterator<String> it = allWins.iterator();

			while (it.hasNext()) {
				String win = it.next();
				driver.switchTo().window(win);
				String title = driver.getTitle();

				if (title.contains(pagetitle)) {
					break;
				}
			}
		}
		
		/**
		 * This method for wait elemtn to display
		 * @param driver
		 */
			
		public void waitforElement(WebDriver driver) {
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		
		/**
		 * This method for Mouse Action
		 * @param driver
		 * @param MoreLink
		 */
		
		public void moveMouseToElement(WebDriver driver, WebElement MoreLink) {
			Actions act = new Actions(driver);
			act.moveToElement(MoreLink).perform();
		}
		
		/**
		 * Alert accept
		 * @param driver
		 */
		
		public void AlertAccept(WebDriver driver) {
			driver.switchTo().alert().accept();
		}
		
		/**
		 * Alert dismiss
		 * @param driver
		 */
			
		public void AlertDismiss(WebDriver driver) {
			driver.switchTo().alert().dismiss();
		}
		
		public static String takeScreenShot1(WebDriver driver, String screenShotName) throws Throwable {
			
			TakesScreenshot takesSceenShot = (TakesScreenshot) driver;
			File src = takesSceenShot.getScreenshotAs(OutputType.FILE);
			File dst = new File("./ScreenShots/" + screenShotName +".png");
			FileUtils.copyFile(src, dst);
			return dst.getAbsolutePath();
		}
			
	}


