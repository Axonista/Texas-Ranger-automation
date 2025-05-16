package PageObjectFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		
		ContinueButton().click();
		
		

	}
}
