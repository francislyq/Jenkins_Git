package demo;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestScrollPageDown {

	@Test
	public void scrollPageDown() {
		System.setProperty("webdriver.chrome.driver", "/Users/liuyuqi/java/web_drivers/chromedriver");
		
		WebDriver chromeDriver = new ChromeDriver();
		
		chromeDriver.get("http://www.twitter.com");
		
		chromeDriver.manage().window().maximize();
		
		// Create JS executor
		JavascriptExecutor je = (JavascriptExecutor) chromeDriver;
		
		je.executeScript("scroll(0, 300)");
		
		//
		//WebElement element = chromeDriver.findElement(By.id(""));
		//je.executeScript("arguments[0].scrollIntoView(true);", element);
	}
}
