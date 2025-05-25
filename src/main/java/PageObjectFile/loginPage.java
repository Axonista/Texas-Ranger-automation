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

public class loginPage {

	//Use Environment variables from .env file and give them variable names
	private static final Logger logger = LoggerFactory.getLogger(loginPage.class);
	private static final Dotenv dotenv = Dotenv.load();
	public static final String EMAIL = dotenv.get("EMAIL");
	public static final String PASSWORD = dotenv.get("PASSWORD");
	public static final String WRONGPASSWORD = dotenv.get("WRONGPASSWORD");
	public static final String NEWFULLNAME = dotenv.get("NEWFULLNAME");
	public static final String NEWPASSWORD = dotenv.get("NEWPASSWORD");
	public static final String FULLNAME = dotenv.get("FULLNAME");
	WebDriver driver;

	public loginPage(WebDriver driver) {
		this.driver = driver;
	}
	//Use WebElements to locate elements in variables
	public WebElement SubDescription() {
		return driver.findElement(By.xpath("//*[contains(text(), 'Lonestar is only available in ')]"));
	}

	public WebElement Email() {
		return driver.findElement(By.id("email"));
	}

	public WebElement Password() {
		return driver.findElement(By.id("password"));
	}

	public WebElement Rememberme() {
		return driver.findElement(By.id("remember-me"));
	}

	public WebElement ForgotPassword() {
		return driver.findElement(By.xpath("//*[text()='Forgot your password?']"));
	}

	public WebElement DontHaveAnAccount() {
		return driver.findElement(By.xpath("//*[text()=\"Don't have an account?\"]"));
	}

	public WebElement SignUp() {
		return driver.findElement(By.xpath("//*[text()='Sign Up']")); 
	}

	public WebElement SigninButton() {
		return driver.findElement(By.xpath("//button[@type='submit']"));
	}
	public WebElement ErrorMessage() {
		return driver.findElement(By.xpath("//*[contains(text(), 'Invalid')]"));
	}

	public void testInvalidLogin()
	{
		Assert.assertTrue(!SigninButton().isEnabled());
		logger.info("Sign in button is disabled");
		
		//Email address should be entered
		Email().sendKeys(EMAIL);
		
		//Password should be entered
		Password().sendKeys(WRONGPASSWORD);
		Assert.assertTrue(SigninButton().isEnabled());
		logger.info("Sign in button is enabled");
		
		//Sign in button is clicked
		SigninButton().click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		//Wait for the error message to be displayed
		WebElement errormessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Invalid')]")));
		Assert.assertTrue(errormessage.isDisplayed(), "Error message is not displayed");
		logger.info("Invalid username or password message is displayed successfully");
	}

	public void testValidLogin() {
		Assert.assertTrue(!SigninButton().isEnabled() , "Sign in button is not disabled");  
		logger.info("Sign in button is disabled");
		
		//Email address should be entered
		Email().sendKeys(EMAIL);
		logger.info("Email addres is entered successfully");
		
		//Password should be entered
		Password().sendKeys(PASSWORD);
		logger.info("Password is entered successfully");
		Assert.assertTrue(SigninButton().isEnabled() , "Sign in button is not enabled");
		logger.info("Sign in button is enabled");
		
		//Sign in button is clicked
		SigninButton().click();
		logger.info("Sign in button is clicked");
		
		//Wait for Subscribe title to be visible and then run next command
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement subscribe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='SUBSCRIBE']")));
		Assert.assertEquals(subscribe.getText(), "SUBSCRIBE");
		logger.info("Subscribe text is visible after logging in");
		

	}
}





