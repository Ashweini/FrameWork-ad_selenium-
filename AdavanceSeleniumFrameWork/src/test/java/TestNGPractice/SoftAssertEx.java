package TestNGPractice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertEx {

	@Test
	public void m1() {
		int act=10;
		int exp=0;
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(act, exp, "Failed");
		//Assertion fail also it will execute all lines 
		System.out.println("Asert is pass");
		soft.assertAll();
	}
}
