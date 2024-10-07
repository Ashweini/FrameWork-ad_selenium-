package Element_ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class vTiger_ProductConfirmationPage {
	public vTiger_ProductConfirmationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[id=\"dtlview_Product Name\"]")
	private WebElement ProductNameExtractText;

	public WebElement getProductNameExtractText() {
		return ProductNameExtractText;
	}
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement clickOnProfietoSignOut;
	
	public WebElement getclickOnProfietoSignOut() {
		return clickOnProfietoSignOut;
	}
	
	@FindBy(linkText = "Sign Out")
	private WebElement clickOnsignOut;
	
	public WebElement getclickOnsignOut() {
		return clickOnsignOut;
	}
	
	/**
	 * click On delete
	 */
	@FindBy(css="[value=\"Delete\"]")
	private WebElement clickOnDelete;
	
	public WebElement getclickOnDelete() {
		return clickOnDelete;
	}
	
	
	
	//Business libraries/Logic 
	public String ProductConfirmationPage() {
		String ProductName = ProductNameExtractText.getText();
		return ProductName;
	}
	
	public void signOut() {
		clickOnProfietoSignOut.click();
		clickOnsignOut.click();
	}
	
	public void dynamicProductName(WebDriver driver,String  productName) {
		driver.findElement(By.xpath("//table[@class=\"lvt small\"]/tbody/tr//td//a[text()='" + productName
				+ "']/../preceding-sibling::td//input[@type=\"checkbox\"]")).click();
	}
	
	public void InterateProductList(WebDriver driver, String productName) {
		List<WebElement> prdList = driver
				.findElements(By.xpath("(//table[@class=\"lvt small\"]/tbody/tr//td[3])[position()>1]"));
		boolean flag = false;

		for (WebElement prdlist1 : prdList) {
			String actData1 = prdlist1.getText();
			if (actData1.contains(productName)) {
				flag = true;
				break;
			}
		}
		if (flag) {
			System.out.println("Product data deleted");
		} else {
			System.out.println("Product data is not deleted");
		}
	}
	
	
	public void clickOnDelete() {
		clickOnDelete.click();
	}
	
}
