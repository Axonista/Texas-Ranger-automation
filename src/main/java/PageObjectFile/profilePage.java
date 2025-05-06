package PageObjectFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class profilePage {

	WebDriver driver;

	public profilePage(WebDriver driver) {
		this.driver = driver;
	}
	// Locators
	public WebElement ViewProfile() {
		return driver.findElement(By.cssSelector("button[class*='hover:text-dark-on-surface   false']"));
	}

	public WebElement EditProfile() {
		return driver.findElement(By.cssSelector("a[href='/account/edit-profile']"));
	}

	public WebElement PerMonth() {
		return driver.findElement(By.cssSelector("span[class*='text-gray-400']"));
	}
}
