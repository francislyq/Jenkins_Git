package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTitle {
	
	@Test
	public void testApplicationTitle() {
		WebDriver app = new FirefoxDriver();
		app.manage().window().maximize();
		app.get("http://www.facebook.com");
		
		String appTitle = app.getTitle();
		
		//String expectedTitle = "Some title";
		
		//Assert.assertEquals(appTitle, expectedTitle);
		Assert.assertTrue(appTitle.contains("-"));
		
		System.out.println("Completed title testing!");
	}

}
