package Element_ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class vTiger_CompainConfirmationPage {
	
	public vTiger_CompainConfirmationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[id=\"dtlview_Campaign Name\"]")
	private WebElement CampaignNameExtractTextField;
	
	public WebElement getCampaignNameExtractTextField() {
		return CampaignNameExtractTextField;
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
	
	//Business libraries/Logic
	public String ComainConfirmationPage() {
		String actData = getCampaignNameExtractTextField().getText();  //.click();
		return actData;
	}
	
	public void signOut() {
		clickOnProfietoSignOut.click();
		clickOnsignOut.click();
	}
	

}
