package TestNGPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertMethods {
	@Test
	public void m1() {
		int a=10;
		int b=10;
		Assert.assertEquals(a, b); //both actual and expected shhould br same/true
	}
	
	@Test
	public void m2() {
		int exp=10;
		int act=10;
		Assert.assertEquals(act, exp, "Not Equal");
		System.out.println("Equal values");
	}
	
	@Test
	public void m3() {
		int exp=10;
		int act=20;
		Assert.assertNotEquals(act, exp, "it is equal");
		System.out.println("Not qual");
	}
	
	@Test
	public void m4() {
		String s="hello";
		Assert.assertTrue(s.contains("e"), "False=");
		System.out.println("true");
	}
	
	@Test
	public void m5() {
		String s = "Hello";
		String ss = "Hello";
		Assert.assertTrue(s.equalsIgnoreCase(ss), "False==");
		System.out.println("AssertPass");
	}
	
	@Test
	public void m6() {
		int act = 10;
		int exp = 10;
		Assert.assertSame(act, exp, "not_same_so_printed");
		System.out.println("Same so printed");
	}
	
	@Test
	public void m7() {
		String s = null;
		Assert.assertNull(s, "not_null");
		System.out.println("it_is_null");
		
		Assert.fail("I am failing"); //intensionally failing the script we use this
	}
	
//AssertFail	
	
}
