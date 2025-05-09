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
		return driver.findElement(By.xpath("//*[contains(text(),'PREMIUM')]"));
	}

	public WebElement SubscribtionPrice() {
		return driver.findElement(By.xpath("//*[contains(text(), '$')]"));
	}

	public WebElement PerMonth() {
		return driver.findElement(By.xpath("//*[text()='/ per month']"));
	}
	public WebElement SubscribtionPoint1() {
		return driver.findElement(By.xpath("//*[contains(text(), 'Unrestricted')]"));
	}
	public WebElement SubscribtionPoint2() {
		return driver.findElement(By.xpath("//*[contains(text(), 'Game')]"));
	}
	public WebElement SubscribtionPoint3() {
		return driver.findElement(By.xpath("//*[contains(text(), 'News')]"));
	}
	
	public WebElement Shortdesc() {
		return driver.findElement(By.xpath("//*[contains(text(), 'Charged')]"));
	}
	public WebElement ProceedBtn() {
		return driver.findElement(By.xpath("//*[text()='Proceed to Payment']"));
	}
	public WebElement SubscribeLater() {
		return driver.findElement(By.xpath("//*[text()='subscribe later']"));
	}
	
	public void PostSignin_Validations()
	{
		Assert.assertTrue(SubscribtionType().isDisplayed());
		System.out.println("Type of subscription is displayed");
		
		Assert.assertEquals(SubscribtionPrice().getText() , "$9.99");
		System.out.println("Price of subscription is displayed");
		
		Assert.assertEquals(PerMonth().getText() , "/ per month");
		System.out.println("Subscription duration is displayed");
		
		Assert.assertEquals(SubscribtionPoint1().getText() , "Unrestricted access to all Live and On-Demand video content");
		System.out.println("Point 1 of subscription description is displayed");
		
		Assert.assertEquals(SubscribtionPoint2().getText() , "Game highlights and replays");
		System.out.println("Point 2 of subscription description is displayed");
		
		Assert.assertEquals(SubscribtionPoint3().getText() , "News updates stats schedules league standings and more");
		System.out.println("Point 3 of subscription description is displayed");
		
		Assert.assertEquals(Shortdesc().getText() , "*Charged monthly, cancel at anytime");
		System.out.println("Short description is displayed");
		
		Assert.assertTrue(ProceedBtn().isEnabled());
		System.out.println("Proceed to Payment button is displayed");
		
		Assert.assertTrue(SubscribeLater().isDisplayed());
		System.out.println("Subscribe later option is displayed");
		
		SubscribeLater().click();
		
		System.out.println("3rd Test Passed");
	}
	

}
