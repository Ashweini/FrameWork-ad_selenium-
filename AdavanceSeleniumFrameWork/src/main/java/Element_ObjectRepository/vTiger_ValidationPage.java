package Element_ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class vTiger_ValidationPage {
	public vTiger_ValidationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void ValidateProduct(String actProductName, String ProductName) {
		Assert.assertEquals(actProductName, ProductName);
		System.out.println("Product name is created");
	}
//		if (actProductName.contains(ProductName)) {
//			System.out.println("Product name is created");
//		} else {
//			System.out.println("Product name not created");
//		}
//	}
	
	public void ValidateOrganization(String actProductName, String ProductName) {
		Assert.assertEquals(actProductName, ProductName);
		System.out.println("Organization name is created");
//		if (actProductName.contains(ProductName)) {
//			System.out.println("Organization name is created");
//		} else {
//			System.out.println("Organization name not created");
//		}
	}
	
	public void ValidateCompaign(String actProductName, String ProductName) {
		Assert.assertEquals(actProductName, ProductName);
		System.out.println("Compaign name is created");
//		if (actProductName.contains(ProductName)) {
//			System.out.println("Compaign name is created");
//		} else {
//			System.out.println("Compaign name not created");
//		}
	}
	
	

	

}
