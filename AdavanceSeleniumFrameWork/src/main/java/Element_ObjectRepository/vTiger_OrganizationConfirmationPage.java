package Element_ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class vTiger_OrganizationConfirmationPage {
	public vTiger_OrganizationConfirmationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Extract org name 
	 */
	@FindBy(xpath="//span[@id='dtlview_Organization Name']")
	private WebElement ExtractOrganizationNameTextField;

	public WebElement getExtractOrganizationNameTextField() {
		return ExtractOrganizationNameTextField;
	}
	
	public String ExtractOrgTextField() {
		String actData = ExtractOrganizationNameTextField.getText();
		return actData;
	}
}
