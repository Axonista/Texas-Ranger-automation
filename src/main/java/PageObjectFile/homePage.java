package PageObjectFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class homePage {

	WebDriver driver;

	public homePage(WebDriver driver) {
		this.driver = driver;
	}
	// Locators
	public WebElement logo() {
		return driver.findElement(By.cssSelector("svg[class*='w-auto']"));
	}

	public WebElement regionSupported() {
		return driver.findElement(By.cssSelector("h1[class*='mb-[44px]"));
	}

	public WebElement description1() {
		return driver.findElement(By.cssSelector("p[class*='text-gray-400']"));
	}

	public WebElement description2() {
		return driver.findElement(By.cssSelector("p[class*='text-dark-outline-warning']"));
	}

	public WebElement ContinueButton() {
		return driver.findElement(By.cssSelector("button[class*='border-dark-outline']"));
	}

	public WebElement goHomeButton() {
		return driver.findElement(By.cssSelector("a[class*='bg-dark-primary']"));
	}

	// Method to validate homepage
	public void Homepage_Validations() {

		// Asserting that the elements are visible and text matches the expected values
		Assert.assertTrue(logo().isDisplayed());
		Assert.assertEquals(regionSupported().getText(), "OUTSIDE SUPPORTED REGIONS", "Region text is incorrect");
		Assert.assertEquals(description1().getText(), "It looks like you're accessing Lonestar from outside one of our supported regions.", "Description 1 text is incorrect");
		Assert.assertEquals(description2().getText(), "You can still sign up, but you can only access the app when you're in: Texas, Louisiana, Oklahoma, Arkansas, Eastern New Mexico", "Description 2 text is incorrect");
		Assert.assertTrue(ContinueButton().isDisplayed(), "Continue button is not visible");
		Assert.assertTrue(goHomeButton().isDisplayed(), "Go Home button is not visible");

	}
}
