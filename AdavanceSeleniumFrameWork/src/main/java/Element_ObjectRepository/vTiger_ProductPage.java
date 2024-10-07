package Element_ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class vTiger_ProductPage {
	
	public vTiger_ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[title=\"Create Product...\"]")
	private WebElement clickOnCreateProduct;

	public WebElement getclickOnCreateProduct() {
		return clickOnCreateProduct;
	}
	
	//Business libraries/Logic 
	public void vtiger_HomePage() {
		clickOnCreateProduct.click();
	}

}
