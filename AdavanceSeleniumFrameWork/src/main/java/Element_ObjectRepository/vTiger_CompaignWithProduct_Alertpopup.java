package Element_ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class vTiger_CompaignWithProduct_Alertpopup {
	
	public vTiger_CompaignWithProduct_Alertpopup(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@src=\"themes/softed/images/select.gif\"]")
	private WebElement clickOnSelectProduct;

	public WebElement getclickOnSelectProduct() {
		return clickOnSelectProduct;
	}
	
	@FindBy(name="search_text")
	private WebElement EnterSearchText;

	public WebElement getEnterSearchText() {
		return EnterSearchText;
	}
	
	@FindBy(name="search")
	private WebElement clickOnSearch;

	public WebElement getclickOnSearch() {
		return clickOnSearch;
	}
	

	
	//Business libraries/Logic 
	public void CompaignWithProduct() {
		clickOnSelectProduct.click();
	}
	
	public void selectproductNameFrompopUp(WebDriver driver, String productName) {
		driver.findElement(By.xpath("//a[text()='" + productName + "']")).click();
	}
	
	public void sendProductName(String prdName) {
		EnterSearchText.sendKeys(prdName);

	}
	
	public void clickOnsearchofPrdName() {
		clickOnSearch.click();
	}

}
