package Element_ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class vtiger_HomePage {
	
	public vtiger_HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * click on Organization
	 */
	@FindBy(css="[href=\"index.php?module=Accounts&action=index\"]")
	private WebElement clickOnOrganizationLink;

	public WebElement getclickOnOrganizationLink() {
		return clickOnOrganizationLink;
	}
	
	
	/**
	 * click on more Link
	 */
	
	@FindBy(linkText="More")
	private WebElement clickOnMoreLink;

	public WebElement getClickOnMoreLink() {
		return clickOnMoreLink;
	}
	
	/**
	 * click on Compaigns link
	 */
	@FindBy(linkText="Campaigns")
	private WebElement clickOnCampaigns;
	
	public WebElement getclickOnCampaigns() {
		return clickOnCampaigns;
	}
	
	/**
	 * click on Product Link
	 */
	
	
	@FindBy(linkText="Products")
	private WebElement clickOnProducts;
	
	public WebElement getclickOnProducts() {
		return clickOnProducts;
	}
	

	
	
	/**
	 * save
	 */
	@FindBy(css = "[title=\"Save [Alt+S]\"]")
	private WebElement save;
	
	public WebElement getSave() {
		return save;
	}
	
	/**
	 * signOut
	 */
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
	public void vtiger_HomePage() {
		clickOnMoreLink.click();;
	}
	
	public void clickOnProduct() {
		clickOnProducts.click();
	}
	
	public void clickOnCompaign() {
		clickOnCampaigns.click();
	}
	
	public void clickOnMoreLink() {
		clickOnMoreLink.click();
	}
	
	public void clickOnOrganization() {
		clickOnOrganizationLink.click();
	}
	
	
	

	
	public void SaveCreation() {
		getSave().click();
	}
	
	public void signOut() {
		clickOnProfietoSignOut.click();
		clickOnsignOut.click();
	}
	
	
}
