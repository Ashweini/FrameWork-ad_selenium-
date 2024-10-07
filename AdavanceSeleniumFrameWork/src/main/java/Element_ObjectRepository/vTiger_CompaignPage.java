package Element_ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class vTiger_CompaignPage {

	public vTiger_CompaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[title=\"Create Campaign...\"]")
	private WebElement clickOnCreateCampaign;
	
	public WebElement getclickOnCreateCampaign() {
		return clickOnCreateCampaign;
	}
	
	//Business libraries/Logic
	public void CampaignPage() {
		clickOnCreateCampaign.click();
	}
	

	
}
