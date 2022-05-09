package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTests {

	private WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	private void setUp() {
		// Create driver

		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

		driver = new ChromeDriver();

		// Maximize browser window

		driver.manage().window().maximize();

	}

	@Test(priority = 1, groups = { "positiveTest", "smokeTests" })
	public void positiveLoginTest() {
		System.out.println("Starting loginTest");

		// Open Test page

		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);

		// sleep for 3 seconds

		sleep(3000);

		System.out.print("Page is opened.");

		// Enter user name

		WebElement username = driver.findElement(By.id("username"));

		username.sendKeys("tomsmith");

		// Enter password

		WebElement password = driver.findElement(By.name("password"));

		password.sendKeys("SuperSecretPassword!");

		// Click login button

		WebElement logInButton = driver.findElement(By.tagName("button"));

		logInButton.click();

		// Verifications

		// New URL

		String expectedUrl = "https://the-internet.herokuapp.com/secure";

		String actualURL = driver.getCurrentUrl();

		Assert.assertEquals(actualURL, expectedUrl, "Actual page url is not the same as expected");

		// Logout button is visible

		WebElement logOutButton = driver.findElement(By.xpath("//a[@class = 'button secondary radius']"));

		Assert.assertTrue(logOutButton.isDisplayed(), "Log out button is not visible");

		// WebElement logOutButton = driver.findElement(By.xpath("//a[@class = 'button
		// secondary radius broken']"));

		// Successful login message

		// WebElement successMessage = driver.findElement(By.cssSelector("#flash"));

		WebElement successMessage = driver.findElement(By.xpath("//div[@id= 'flash']"));
		// System.out.println(successMessage);
		String expectedMessage = "You logged into a secure area!";
		String actualMessage = successMessage.getText();
		// Assert.assertEquals(actualMessage, successMessage, "Actual message is not the
		// same as expected");
		Assert.assertTrue(actualMessage.contains(expectedMessage),
				"Actual message does not contain expected message.\nActual Message " + actualMessage
						+ "\nExpected Message" + expectedMessage);

	}

	@Parameters({ "username", "password", "expectedMessage" })
	@Test(priority = 2, groups = { "negativeTest", "smokeTests" })
	public void negativeLoginTest(String username, String password, String expectedErrorMessage) {

		System.out.println("Starting negativeLoginTest with " + username + "and" + password);

		// Open test page

		String url = "http://the-internet.herokuapp.com/login";
		driver.get(url);

		System.out.println("The page is open");

		// Enter username

		WebElement usernameElement = driver.findElement(By.name("username"));
		usernameElement.sendKeys(username);

		// Enter password

		WebElement passwordElement = driver.findElement(By.name("password"));
		passwordElement.sendKeys(password);

		// Click Login Button

		WebElement logInButton = driver.findElement(By.tagName("button"));

		logInButton.click();

		// Verifications

		WebElement errorMessage = driver.findElement(By.id("flash"));
		String actualErrorMessage = errorMessage.getText();
		Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
				"Actual error message does not contain expected. \nActual: " + actualErrorMessage + "\nExpected: "
						+ expectedErrorMessage);

		// Close browser

	}

	private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterMethod(alwaysRun = true)
	private void tearDown() {
		// Close browser

		driver.quit();
	}
}
