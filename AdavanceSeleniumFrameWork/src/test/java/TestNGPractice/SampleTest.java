package TestNGPractice;

import org.testng.annotations.Test;

//@Test
public class SampleTest {
	
//	@Test(priority = 0)
	@Test(invocationCount = 2, priority = 0)
	public void createContact() {
		
		System.out.println("Contact created");
	}
	
	//@Test(priority = -1)
	@Test(dependsOnMethods = "createContact", invocationCount = 2, priority = 0)
	public void modifyContact() {
		System.out.println("Contact modify");
	}

//	@Test(dependsOnMethods = "createContact")
	//@Test(priority = 0)
//	@Test(enabled  = false)
	@Test
	public void deleteContact() {
		System.out.println("Contact deleted");
	}
}
