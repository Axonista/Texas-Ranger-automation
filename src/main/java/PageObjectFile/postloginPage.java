package PageObjectFile;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class postloginPage {

	WebDriver driver;

	public postloginPage(WebDriver driver) {
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
	public WebElement ProceedButtn() {
		return driver.findElement(By.xpath("//*[text()='Proceed to Payment']"));
	}
	public WebElement SubscribeLater() {
		return driver.findElement(By.xpath("//*[text()='subscribe later']"));
	}
	public WebElement AcoountCreatedSuccessfully() {
		return driver.findElement(By.xpath("//*[text()='ACCOUNT CREATED SUCCESSFULLY']"));
	}
	
}
