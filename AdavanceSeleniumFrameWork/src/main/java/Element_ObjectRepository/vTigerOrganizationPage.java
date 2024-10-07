package Element_ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class vTigerOrganizationPage {

	public vTigerOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * click on Organization
	 */
	@FindBy(css="[src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement clickOnCreateOrganizationLink;

	public WebElement getclickOnCreateOrganizationLink() {
		return clickOnCreateOrganizationLink;
	}
	
	public void clickOnCreateOrganization() {
		clickOnCreateOrganizationLink.click();
	}
	
	
	
}
