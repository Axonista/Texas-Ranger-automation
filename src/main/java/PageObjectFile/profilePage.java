package PageObjectFile;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import io.github.cdimascio.dotenv.Dotenv;

public class profilePage {
	private static final Logger logger = LoggerFactory.getLogger(profilePage.class);
	private static final Dotenv dotenv = Dotenv.load();
	public static final String EMAIL = dotenv.get("EMAIL");
	public static final String PASSWORD = dotenv.get("PASSWORD");
	public static final String WRONGPASSWORD = dotenv.get("WRONGPASSWORD");
	public static final String NEWFULLNAME = dotenv.get("NEWFULLNAME");
	public static final String NEWPASSWORD = dotenv.get("NEWPASSWORD");
	WebDriver driver;

	public profilePage(WebDriver driver) {
		this.driver = driver;
	}

	//Use WebElements to locate elements in variables
	public WebElement FullName() {
		return driver.findElement(By.id("name"));
	}

	public WebElement SaveChangesButtonn() {
		return driver.findElement(By.xpath("//*[text()= 'Save Changes']"));
	}

	//Method to update Full Name
	public void Full_Name_Update(String NewFullname)
	{
		//Wait for View Profile button to be visible and then run next command
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement viewprofile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='View Profile']")));

		//Click on View Profile button 'ACCOUNT CREATED SUCCESSFULLY' page
		viewprofile.click();
		logger.info("View Profile button is clicked ");

		//Wait for Edit Profile button to be visible and then run next command
		WebElement editprofile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()= 'Edit Profile ']")));

		//Click on Edit Profile on 'ACCOUNT' page
		editprofile.click();
		logger.info("Edit Profile button is clicked");

		//Wait for full name field to be visible
		WebElement fullname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));

		//Click on Full Name field and Enter the name
		new Actions(driver).click(fullname).keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).sendKeys(NewFullname).perform();
		logger.info("Full name is entered successfully");

		//Click on Save button
		SaveChangesButtonn().click();
		logger.info("Save Button is clicked successfully");

		//Validate that entered new name is same as in environment variable NEWFULLNAME
		Assert.assertEquals(fullname.getAttribute("value"),NewFullname);
		logger.info("Full name is updated successfully");
	}
}

