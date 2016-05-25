package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestFacebookRegistration {

	public static void main(String[] args) {
		// Firefox
		WebDriver firefoxDriver = new FirefoxDriver();
		
		firefoxDriver.get("http://www.facebook.com");
		
		firefoxDriver.manage().window().maximize();
		
		// First Name
		firefoxDriver.findElement(By.id("u_0_1")).sendKeys("Francis");
		
		// Male
		firefoxDriver.findElement(By.id("u_0_f")).click();
		
		// Month
		Select month = new Select(firefoxDriver.findElement(By.id("month")));
		
		month.selectByVisibleText("Apr");
		
		// Day
		Select day = new Select(firefoxDriver.findElement(By.id("day")));
		
		day.selectByIndex(22);
		
		// Year
		Select year = new Select(firefoxDriver.findElement(By.id("year")));
		
		year.selectByValue("1991");
		
		// Sign Up
		firefoxDriver.findElement(By.id("u_0_j")).click();
		
		// Chrome
		System.setProperty("webdriver.chrome.driver", "/Users/liuyuqi/java/web_drivers/chromedriver");
		
		WebDriver chromeDriver = new ChromeDriver();
		
		chromeDriver.get("http://www.twitter.com");
		
		chromeDriver.manage().window().maximize();
		
	}
}
