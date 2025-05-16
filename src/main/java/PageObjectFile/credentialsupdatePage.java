package PageObjectFile;


import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class credentialsupdatePage {
	WebDriver driver;

	public credentialsupdatePage(WebDriver driver) {
		this.driver = driver;
	}
	// Locators

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

	//public WebElement NewEmail() {
	//	return driver.findElement(By.xpath("input[id='email']"));
	//}

	public WebElement UpdateEmailBtn() {
		return driver.findElement(By.xpath("//*[text()='Update Email Address']"));
	}

	public WebElement ConfirmEmailMsg() {
		return driver.findElement(By.xpath("//*[text()= 'Confirmation Email']"));
	} 

	public WebElement GmailEmail() {
		return driver.findElement(By.xpath("input[name='identifier']"));
	}

	public WebElement GmailNext() {
		return driver.findElement(By.xpath("//*[text()= 'Next']"));
	} 
	public WebElement GmailPassword() {
		return driver.findElement(By.xpath("//*[text()= 'Next']"));
	}
	public WebElement NotNow() {
		return driver.findElement(By.xpath("//*[text()= 'Not now']"));
	}
	public WebElement Cancel() {
		return driver.findElement(By.xpath("//*[text()= 'Cancel']"));
	}
	public WebElement Skip() {
		return driver.findElement(By.xpath("//*[text()= 'Skip']"));
	}
	public WebElement GoogleApps() {
		return driver.findElement(By.xpath("ul > li:nth-child(3)"));
	}



	  

	//public WebElement BackToEditAccount() {
	//	return driver.findElement(By.xpath("//*[contains(text(),'Back to Edit')]"));
	//}

	// Method to validate homepage

	public void Credentials_Updation() {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		//String newemail = System.getenv("NewEmail");
		String password = System.getenv("PASSWORD");
		String newpassword = System.getenv("NEWPASSWORD");

		UpdatePasswordOption().click();
		
		WebElement currentpassword = wait.until(ExpectedConditions.elementToBeClickable(By.id("currentPassword")));

		currentpassword.sendKeys(password);
		NewPassword().sendKeys(newpassword);
		ConfirmPassword().sendKeys(newpassword);
		UpdatePasswordBtn().click();
		WebElement backtoeditbtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[span[text()='Back to Edit Account Details']]")));
		backtoeditbtn.click();

		UpdateEmailBtnOption().click();
		WebElement newemailEdit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter new email address']")));

		newemailEdit.sendKeys("saily.dhande1996@gmail.com");
		UpdateEmailBtn().click();
		
		
		//Open gmail and verify email
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();

		
		// Optional: specify the profile if you use multiple profiles (default is usually "Default")
		options.addArguments("profile-directory=Profile 11");

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



