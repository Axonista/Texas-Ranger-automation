package PageObjectFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class profilePage {

	WebDriver driver;

	public profilePage(WebDriver driver) {
		this.driver = driver;
	}


	public WebElement FullName() {
		return driver.findElement(By.id("name"));
	}

	public WebElement SaveChangesButtonn() {
		return driver.findElement(By.xpath("//*[text()= 'Save Changes']"));
	}

	public void Full_Name_Update()
	{
		//Wait for View Profile button to be visible and then run next command
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement viewprofile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='View Profile']")));

		viewprofile.click();
		
		//Wait for Edit Profile button to be visible and then run next command
		WebElement editprofile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()= 'Edit Profile ']")));

		editprofile.click();

	}
}
