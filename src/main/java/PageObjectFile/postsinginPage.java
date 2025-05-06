package PageObjectFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class postsinginPage {

	WebDriver driver;

	public postsinginPage(WebDriver driver) {
		this.driver = driver;
	}
	// Locators
	public WebElement SubscribtionType() {
		return driver.findElement(By.cssSelector("h1[class*='lg:leading']"));
	}

	public WebElement SubscribtionPrice() {
		return driver.findElement(By.cssSelector("span[class*='lg:text-2xl']"));
	}

	public WebElement PerMonth() {
		return driver.findElement(By.cssSelector("span[class*='text-gray-400']"));
	}
	public WebElement SubscribtionPoint1() {
		return driver.findElement(By.cssSelector("ul > li:nth-child(1) > span"));
	}
	public WebElement SubscribtionPoint2() {
		return driver.findElement(By.cssSelector("ul > li:nth-child(2) > span"));
	}
	public WebElement SubscribtionPoint3() {
		return driver.findElement(By.cssSelector("ul > li:nth-child(3) > span"));
	}
	
	public WebElement Shortdesc() {
		return driver.findElement(By.cssSelector("div[class*='mb-6']"));
	}
	public WebElement ProceedBtn() {
		return driver.findElement(By.cssSelector("button[class*='bg-dark-primary']"));
	}
	public WebElement SubscribeLater() {
		return driver.findElement(By.cssSelector("a[class*='brightness-90']"));
	}
	
	public void PostSignin_Validations()
	{
		Assert.assertTrue(SubscribtionType().isDisplayed());
		Assert.assertEquals(SubscribtionPrice().getText() , "$9.99");
		Assert.assertEquals(PerMonth().getText() , "/ per month");
		Assert.assertEquals(SubscribtionPoint1().getText() , "Unrestricted access to all Live and On-Demand video content");
		Assert.assertEquals(SubscribtionPoint2().getText() , "Game highlights and replays");
		Assert.assertEquals(SubscribtionPoint3().getText() , "News updates stats schedules league standings and more");
		Assert.assertEquals(Shortdesc().getText() , "*Charged monthly, cancel at anytime");
		Assert.assertTrue(ProceedBtn().isEnabled());
		Assert.assertTrue(SubscribeLater().isDisplayed());
		SubscribeLater().click();
	}
	

}
