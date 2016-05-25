package demo;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestErrorMsg {
	
	@Test
	public void testErrorMsg() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/liuyuqi/java/web_drivers/chromedriver");
		
		WebDriver chromeDriver = new ChromeDriver();
		
		chromeDriver.get("http://gmail.com");
		
		chromeDriver.manage().window().maximize();
		
		chromeDriver.findElement(By.id("next")).click();
		
		Thread.sleep(2000);
		
		String actualErrorMsg = chromeDriver.findElement(By.id("errormsg_0_Email")).getText();
		//String actualErrorMsg = chromeDriver.findElement(By.id("errormsg_0_Email")).getAttribute("innerHTML");
		
		String expectErrorMsg = "Please enter your email. ";
		
		// Type 1
		Assert.assertEquals(actualErrorMsg, expectErrorMsg);
		
		// Type 1
		Assert.assertTrue(actualErrorMsg.contains(expectErrorMsg));
		
		System.out.println("Completed error msg testing!");
	}
	
	
}
