package PageObjectFile;


import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.cdimascio.dotenv.Dotenv;

public class passwordupdatePage {
	private static final Logger logger = LoggerFactory.getLogger(profilePage.class);
	private static final Dotenv dotenv = Dotenv.load();
	public static final String EMAIL = dotenv.get("EMAIL");
	public static final String PASSWORD = dotenv.get("PASSWORD");
	public static final String WRONGPASSWORD = dotenv.get("WRONGPASSWORD");
	public static final String NEWFULLNAME = dotenv.get("NEWFULLNAME");
	public static final String NEWPASSWORD = dotenv.get("NEWPASSWORD");
	
	WebDriver driver;

	public passwordupdatePage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Use WebElements to locate elements in variables
	public WebElement UpdatePasswordOption() {
		return driver.findElement(By.xpath("//*[text() = 'Update Password ']"));
	}
	
	public WebElement CurrentPassword() {
		return driver.findElement(By.id("currentPassword"));
	}

	public WebElement NewPassword() {
		return driver.findElement(By.id("newPassword"));
	}

	public WebElement ConfirmPassword() {
		return driver.findElement(By.id("confirmPassword"));
	}

	public WebElement UpdatePasswordBtn() {
		return driver.findElement(By.xpath("//button[@type='submit']"));
	}
	
	public WebElement PasswordUpdatedMsg() {
		return driver.findElement(By.xpath("//*[text()='Password Updated']"));
	} 

	public WebElement UpdateEmailBtnOption() {
		return driver.findElement(By.xpath("//*[text()='Update Email ']"));
	} 


	public WebElement UpdateEmailBtn() {
		return driver.findElement(By.xpath("//*[text()='Update Email Address']"));
	}

	public WebElement ConfirmEmailMsg() {
		return driver.findElement(By.xpath("//*[text()= 'Confirmation Email']"));
	} 



	// Method to validate Password Updation
	public void Password_Updation() {

		WebDriverWait wait = new WebDriverWait(driver, 10);
	
		//Click on Update Password button
		UpdatePasswordOption().click();
		logger.info("Update Password option is clicked");
		
		//Explicit wait is used to wait for Current Password field to be clickable
		WebElement currentpassword = wait.until(ExpectedConditions.elementToBeClickable(By.id("currentPassword")));

		//Enter Current Password
		currentpassword.sendKeys(PASSWORD);
		logger.info("Current Password is entered");
		
		//Enter New Password
		NewPassword().sendKeys(NEWPASSWORD);
		logger.info("New Password is entered");
		
		//Enter New Password
		ConfirmPassword().sendKeys(NEWPASSWORD);
		logger.info("New Password is entered again");
		
		//Click on Update Password Button
		UpdatePasswordBtn().click();
		logger.info("Update Password button is clicked");
		
		//Explicit wait is used to wait for Back to Edit button to be clickable
		WebElement backtoeditbtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[span[text()='Back to Edit Account Details']]")));
		
		//Click on Back to Edit button
		backtoeditbtn.click();
		logger.info("Back to Edit button is clicked");

		
		
	}
	
	public void Email_Updation()
	{	
		WebDriverWait wait = new WebDriverWait(driver, 10);
		UpdateEmailBtnOption().click();
		WebElement newemailEdit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter new email address']")));

		newemailEdit.sendKeys("saily.dhande1996@gmail.com");
		UpdateEmailBtn().click();
		//Open gmail and verify email
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();

		options.addArguments("user-data-dir=C:/Users/YourUser/AppData/Local/Google/Chrome/User Data");
		options.addArguments("profile-directory=Profile 10");

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://mail.google.com");
		
		// Prompt to log in manually (first time only)
        System.out.println("Please log in manually if needed, then press Enter here...");
        new Scanner(System.in).nextLine();
		 // Block the program from exiting (keep Chrome alive)
        try {
            System.out.println("Keeping the browser open... Press Ctrl+C to stop manually.");
            Thread.sleep(Long.MAX_VALUE); // Keeps process alive forever
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

	}
}



