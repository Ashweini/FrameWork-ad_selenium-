package Element_ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class vTiger_CreateNewOrganization_Page {
	public vTiger_CreateNewOrganization_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * send keys on Organization text field
	 */
	@FindBy(xpath="//input[@name=\"accountname\"]")
	private WebElement OrganizationNameTextField;

	public WebElement getOrganizationNameTextField() {
		return OrganizationNameTextField;
	}
	
	/**
	 * send key on phone number 
	 */
	@FindBy(css="[id=\"phone\"]")
	private WebElement sendPhoneNumber;

	public WebElement getsendPhoneNumber() {
		return sendPhoneNumber;
	}
	
	/**
	 * send email
	 */
	@FindBy(css="[id=\"email1\"]")
	private WebElement sendEmail;

	public WebElement getsendEmail() {
		return sendEmail;
	}
	
	
	public void EnterOrganizationName(String orgName) {
		OrganizationNameTextField.sendKeys(orgName);
	}
	
	public void EnterPhoneNum(String PhoneNum) {
		sendPhoneNumber.sendKeys(PhoneNum);
	}
	
	public void EnterEmail(String Email) {
		sendEmail.sendKeys(Email);
	}

}
