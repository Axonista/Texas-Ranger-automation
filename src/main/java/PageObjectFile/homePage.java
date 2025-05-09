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
		return driver.findElement(By.cssSelector("a[href='/']"));
	}

	public WebElement regionSupported() {
		return driver.findElement(By.xpath("//*[text()='OUTSIDE SUPPORTED REGIONS']"));
	}

	public WebElement description1() {
		return driver.findElement(By.xpath("//*[contains(text(),\"It looks like you're accessing Lonestar\")]"));
	}

	public WebElement description2() {
		return driver.findElement(By.xpath("//*[contains(text(),\"You can still sign up, but you can only access the app\")]"));
	}

	public WebElement ContinueButton() {
		return driver.findElement(By.xpath("//*[text() = 'Continue']"));
	}    

	public WebElement goHomeButton() {
		return driver.findElement(By.xpath("//*[text() = 'Go Home']"));
	}

	// Method to validate homepage
	public void Homepage_Validations() {

		// Asserting that the elements are visible and text matches the expected values
		Assert.assertTrue(logo().isDisplayed() , "Logo is not displayed");
		System.out.println("Logo is displayed");
		
		Assert.assertEquals(regionSupported().getText(), "OUTSIDE SUPPORTED REGIONS", "Region text is incorrect");
		System.out.println("OUTSIDE SUPPORTED REGIONS is displayed");
		
		Assert.assertEquals(description1().getText(), "It looks like you're accessing Lonestar from outside one of our supported regions.", "Description 1 text is incorrect");
		System.out.println("Description1 is displayed");
		
		Assert.assertEquals(description2().getText(), "You can still sign up, but you can only access the app when you're in: Texas, Louisiana, Oklahoma, Arkansas, Eastern New Mexico", "Description 2 text is incorrect");
		System.out.println("Description2 is displayed");
		
		Assert.assertTrue(ContinueButton().isDisplayed(), "Continue button is not visible");
		System.out.println("Continue Button is displayed");
		
		Assert.assertTrue(goHomeButton().isDisplayed(), "Go Home button is not visible");
		System.out.println("Go Home button is displayed");
		
		System.out.println("1st Test Passed");
		

	}
}
