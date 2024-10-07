package Element_ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class vTiger_CreateNewCompaign {

	public vTiger_CreateNewCompaign(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[name=\"campaignname\"]")
	private WebElement CampaignNameTextField;
	
	public WebElement getCampaignNameTextField() {
		return CampaignNameTextField;
	}
	
	@FindBy(css = "[title=\"Save [Alt+S]\"]")
	private WebElement saveCampaign;
	
	public WebElement getsaveCampaign() {
		return saveCampaign;
	}
	

	
	//Business libraries/Logic
		public void CreateCampaignPage(String CompaignName) {
			getCampaignNameTextField().sendKeys(CompaignName);;  //.click();
		}
		
		
		
		public void saveCampaignn() {
			getsaveCampaign().click();
		}

}
