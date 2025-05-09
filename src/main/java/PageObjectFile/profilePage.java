package PageObjectFile;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class profilePage {

	WebDriver driver;

	public profilePage(WebDriver driver) {
		this.driver = driver;
	}
	// Locators
	//public WebElement ViewProfile() {
	//	return driver.findElement(By.cssSelector("button[class*='hover:text-dark-on-surface   false']"));
	//}

	//public WebElement EditProfile() {
		//return driver.findElement(By.cssSelector("a[href='/account/edit-profile']"));
	//}

	public WebElement FullName() {
		return driver.findElement(By.id("name"));
	}
	
	public WebElement SaveChangesBtn() {
		return driver.findElement(By.xpath("//*[text()= 'Save Changes']"));
	}
	
	public void Profile_Validations()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		 WebElement viewprofile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='View Profile']")));
			
		viewprofile.click();
		 WebElement editprofile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()= 'Edit Profile ']")));
		
		editprofile.click();
		WebElement fullname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
		
	
		new Actions(driver).click(fullname).keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).sendKeys(System.getenv("FullName")).perform();
		SaveChangesBtn().click();
		Assert.assertEquals(fullname.getAttribute("value") , System.getenv("FullName"));
		System.out.println("Full name is updated successfully");
		
		System.out.println("4rd Test Passed");
		}
}
