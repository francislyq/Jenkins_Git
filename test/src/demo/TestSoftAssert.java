package demo;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestSoftAssert {

	@Test
	public void testSoftAssert() {
		SoftAssert assertation = new SoftAssert();
		
		assertation.assertEquals(12, 13);
		
		// execute this line
		System.out.println("Soft assertation completed!");
		
		// At last line
		assertation.assertAll();
		
	}
}
