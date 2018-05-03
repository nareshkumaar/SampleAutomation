package com.learn.po;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.learn.dto.Associates;

public class ultimateqa {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		browserSetup();
		buttonClick1();
		radioButton();
		checkbox();
		gridData();
		closeBrowser();
	}

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

		// Find element by link text and store in variable "Element"
		// WebElement Element = driver.findElement(By.linkText("Linux"));

		// This will scroll the page till the element is found
		// js.executeScript("arguments[0].scrollIntoView();", Element);
		// https://www.guru99.com/scroll-up-down-selenium-webdriver.html

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public static void radioButton() {
		WebElement radioButton1 = driver.findElement(By.xpath("//input[@type='radio' and @name='gender']"));
		radioButton1.click();
	}

	public static void checkbox() {
		WebElement checkBox = driver
				.findElement(By.xpath("//input[@type='checkbox' and @name='vehicle' and @value='Bike']"));
		checkBox.click();
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("arguments[0].scrollIntoView();", checkBox);

	}

	public static void gridData() {
		List<Associates> a = new ArrayList<Associates>();

		WebElement a1 = driver.findElement(By.xpath("//table[@id=\"htmlTableId\"]/tbody/tr[2]/td[1]"));
		String designation = a1.getText();

		WebElement a2 = driver.findElement(By.xpath("//table[@id=\"htmlTableId\"]/tbody/tr[2]/td[2]"));
		String role = a2.getText();

		WebElement a3 = driver.findElement(By.xpath("//table[@id=\"htmlTableId\"]/tbody/tr[2]/td[3]"));
		String salary = a3.getText();

		for (int i = 0; i < 1; i++) {
			Associates associates = new Associates();
			associates.setDesgination(designation);
			associates.setRole(role);
			associates.setSalary(salary);
			a.add(associates);
		}

		System.out.println(a);
	}

	public static void closeBrowser() {
		// driver.quit();
	}

}
