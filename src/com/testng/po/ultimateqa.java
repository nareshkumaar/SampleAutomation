package com.testng.po;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ultimateqa {

	public static WebDriver driver;

	
	public static void browserSetup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\prokarma\\eclipse-workspace\\SampleAutomation\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.ultimateqa.com/simple-html-elements-for-automation/");
		driver.manage().window().maximize();
		System.out.println("Selenium Webdriver Script in Chrome browser");
	}
	
	
	@Test
	public static void buttonClick1() {
		String text = "Button Success";
		driver.findElement(By.xpath("//a[@class='et_pb_promo_button et_pb_button']")).click();
		System.out.println("Button clicked");
		
		//List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + text + "')]"));
		Assert.assertEquals("Button success", driver.findElement(By.xpath("//h1[contains(text(),'Button success')]")).getText());
		
		driver.navigate().back();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,900)");



		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
}
