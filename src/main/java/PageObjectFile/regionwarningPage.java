package PageObjectFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import io.github.cdimascio.dotenv.Dotenv;
public class regionwarningPage {
	
	//Use Environment variables from .env file and give them variable names
	private static final Logger logger = LoggerFactory.getLogger(regionwarningPage.class);
	private static final Dotenv dotenv = Dotenv.load();
    public static final String EMAIL = dotenv.get("EMAIL");
    public static final String PASSWORD = dotenv.get("PASSWORD");
    public static final String WRONGPASSWORD = dotenv.get("WRONGPASSWORD");
    public static final String NEWFULLNAME = dotenv.get("NEWFULLNAME");
    public static final String NEWPASSWORD = dotenv.get("NEWPASSWORD");
    public static final String FULLNAME = dotenv.get("FULLNAME");
	WebDriver driver;

	public regionwarningPage(WebDriver driver) {
		this.driver = driver;
	}
	//Use WebElements to locate elements in variables
	public WebElement Logo() {
		return driver.findElement(By.cssSelector("a[href='/']"));
	}

	public WebElement WarningmMessage() {
		return driver.findElement(By.xpath("//*[text()='OUTSIDE SUPPORTED REGIONS']"));
	}

	public WebElement SubDescription() {
		return driver.findElement(By.xpath("//*[contains(text(),\"It looks like you're accessing Lonestar\")]"));
	}

	public WebElement Description() {
		return driver.findElement(By.xpath("//*[contains(text(),\"You can still sign up, but you can only access the app\")]"));
	}

	public WebElement ContinueButton() {
		return driver.findElement(By.xpath("//*[text() = 'Continue']"));
	}    

	public WebElement GoHomeButton() {
		return driver.findElement(By.xpath("//*[text() = 'Go Home']"));
	}

	public WebElement SUBSCRIBE_Title() {
		return driver.findElement(By.xpath("//*[text() = 'SUBSCRIBE']"));
	}
	
	public WebElement SigninTitle() {
		return driver.findElement(By.xpath("//*[text() = 'SUBSCRIBE']"));
	}
	// Method to validate homepage
	public void Move_To_SigninPage() {
		try
		{
	    //Click on Continue button.
		ContinueButton().click();
		logger.info("Continue button is clicked");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		//Explicit wait will wait for Sign in title to be visible
		WebElement signintitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = 'SIGN IN']")));
		Assert.assertEquals(signintitle.getText(),  "SIGN IN");
		logger.info("Sign in title is displayed");
		
		
    } catch (Exception e) {
        try {
            //If Sign in page is not displayed the this should
    		//because VPN is not connected to Dallas
            if (!SigninTitle().isDisplayed()) {
                logger.warn("⚠️ VPN ISSUE: You're outside supported regions. Please connect to a VPN and select location USA - Dallas");
            }
        } catch (Exception geo) {
            logger.info("Geo-restriction element not found. Might be a different issue.");
        }
     // Log full stack trace of the original exception
        logger.error("❌ Test failed due to unexpected error: " + e.getMessage(), e);
        throw e; // rethrow to ensure TestNG marks it as failed
    }
	}
}
