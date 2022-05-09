package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

public class NegativeTest {
	
	
	/*
	 * @Test(priority = 2, groups = { "negativeTest" }) public void
	 * incorrectPasswordTest() {
	 * System.out.println("Starting incorrectPasswordTest");
	 * 
	 * // Create driver
	 * 
	 * System.setProperty("webdriver.chrome.driver",
	 * "src/main/resources/chromedriver.exe"); WebDriver driver = new
	 * ChromeDriver();
	 * 
	 * // Maximize browser window driver.manage().window().maximize();
	 * 
	 * // Open test page
	 * 
	 * String url = "http://the-internet.herokuapp.com/login"; driver.get(url);
	 * 
	 * System.out.println("The page is open");
	 * 
	 * // Enter username
	 * 
	 * WebElement username = driver.findElement(By.name("username"));
	 * username.sendKeys("tomsmith");
	 * 
	 * // Enter password
	 * 
	 * WebElement password = driver.findElement(By.name("password"));
	 * password.sendKeys("incorrectpassowrd!");
	 * 
	 * // Click Login Button
	 * 
	 * WebElement logInButton = driver.findElement(By.tagName("button"));
	 * 
	 * logInButton.click();
	 * 
	 * // Verifications
	 * 
	 * 
	 * WebElement errorMessage = driver.findElement(By.id("flash")); String
	 * expectedErrorMessage = "Your password is invalid!"; String actualErrorMessage
	 * = errorMessage.getText();
	 * 
	 * Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
	 * "Actual error message does not contain expected. \nActual: " +
	 * actualErrorMessage + "\nExpected: " + expectedErrorMessage);
	 * 
	 * //Close browser
	 * 
	 * driver.quit(); }
	 */

}
