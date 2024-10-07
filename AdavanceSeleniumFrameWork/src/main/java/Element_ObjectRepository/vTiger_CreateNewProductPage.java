package Element_ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class vTiger_CreateNewProductPage {
	
	public vTiger_CreateNewProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name=\"productname\"]")
	private WebElement ProductNameInputText;

	public WebElement getProductNameInputText() {
		return ProductNameInputText;
	}
	
	@FindBy(css = "[title=\"Save [Alt+S]\"]")
	private WebElement saveProduct;
	
	public WebElement getsaveProduct() {
		return saveProduct;
	}
	
	//Business libraries/Logic 
	public void vtiger_NewProductPage(String productName) {
		ProductNameInputText.sendKeys(productName);
	}
	
	
	
	public void saveProductn() {
		getsaveProduct().click();
	}
	



}
