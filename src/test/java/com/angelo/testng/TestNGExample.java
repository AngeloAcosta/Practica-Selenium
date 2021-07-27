package com.angelo.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class TestNGExample {

	WebDriver driver;

	By searchBoxLocator = By.id("search_query_top");
	By resultLocator = By.cssSelector("span.heading-counter");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chrome/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");

	}

	@Test
	public void searchBlouses() {
		WebElement searchbox = driver.findElement(searchBoxLocator);
		searchbox.clear();
		searchbox.sendKeys("blouse");
		searchbox.submit();
		
		WebDriverWait wait = new WebDriverWait(driver, 7);
		wait.until(ExpectedConditions.presenceOfElementLocated(resultLocator));
		
		System.out.println("Resultado: " +driver.findElement(resultLocator).getText());
		
		assertTrue(driver.findElement(resultLocator).isDisplayed(), "The result number is not present");
	}

	@AfterClass
	public void afterClass() {
		//driver.close();
	}

}
