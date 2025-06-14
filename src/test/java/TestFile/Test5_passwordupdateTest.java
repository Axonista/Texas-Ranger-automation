package TestFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjectFile.passwordupdatePage;
import PageObjectFile.regionwarningPage;
import io.github.cdimascio.dotenv.Dotenv;
import PageObjectFile.loginPage;
import PageObjectFile.postloginPage;
import PageObjectFile.profilePage;

public class Test5_passwordupdateTest extends BaseTest {
	
	private static final Dotenv dotenv = Dotenv.load();
	public static final String NEWFULLNAME_Test5 = dotenv.get("NEWFULLNAME_Test5");
	private static final Logger logger = LoggerFactory.getLogger(Test1_regionwarningTest.class);	
	public static final String EMAIL = dotenv.get("EMAIL");
	public static final String PASSWORD = dotenv.get("PASSWORD");
	public static final String WRONGPASSWORD = dotenv.get("WRONGPASSWORD");
	public static final String NEWPASSWORD = dotenv.get("NEWPASSWORD");	
	
	@Test(
			testName = "FullNameUpdate", 
			description = "Verify that full name is updated successfully on Accounts Page"
			)
	
	public void CredentialsUpdateTest()
	{
	
		//Create object for homePage file
		regionwarningPage homepageObject = new regionwarningPage(driver);

		// Asserting that the elements are visible and text matches the expected values
		Assert.assertTrue(homepageObject.Logo().isDisplayed(), "Logo is not displayed");
		logger.info("Logo is displayed");

		Assert.assertEquals(homepageObject.WarningmMessage().getText(), "OUTSIDE SUPPORTED REGIONS", "Region text is incorrect");
		logger.info("OUTSIDE SUPPORTED REGIONS is displayed");

		Assert.assertEquals(homepageObject.SubDescription().getText(), "It looks like you're accessing Lonestar from outside one of our supported regions.", "Description 1 text is incorrect");
		logger.info("SubDescription is displayed");

		Assert.assertEquals(homepageObject.Description().getText(), "You can still sign up, but you can only access the app when you're in: Texas, Louisiana, Oklahoma, Arkansas, Eastern New Mexico", "Description 2 text is incorrect");
		logger.info("Description is displayed");

		Assert.assertTrue(homepageObject.ContinueButton().isDisplayed(), "Continue button is not visible");
		logger.info("Continue Button is displayed");

		Assert.assertTrue(homepageObject.GoHomeButton().isDisplayed(), "Go Home button is not visible");
		logger.info("Go Home button is displayed");

		// Run the Region Warning Page Validations
		homepageObject.Move_To_SigninPage();

		//Using Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 10);

		//Wait for Sign in  title to be visible and then run next command
		WebElement signintitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='SIGN IN']")));

		//Create object for homePage file
		loginPage loginObject= new loginPage(driver);
		// Asserting that the elements are visible and text matches the expected values
		Assert.assertEquals(signintitle.getText(),  "SIGN IN");
		logger.info("Sign in title is displayed");

		Assert.assertEquals(loginObject.SubDescription().getText(), "Lonestar is only available in Texas, Louisiana, Oklahoma, Arkansas, and Eastern New Mexico.");
		logger.info("Availability of Lonestar app description is displayed");

		Assert.assertTrue(loginObject.Email().isDisplayed());
		logger.info("Email field is displayed");

		Assert.assertTrue(loginObject.Password().isDisplayed());
		logger.info("Password field is displayed");

		Assert.assertTrue(!loginObject.SigninButton().isEnabled());
		logger.info("Password field is disabled");

		Assert.assertTrue(loginObject.Rememberme().isDisplayed());
		logger.info("Remember me field is displayed");

		Assert.assertTrue(loginObject.ForgotPassword().isDisplayed());
		logger.info("Forgot password option is displayed");

		Assert.assertTrue(loginObject.DontHaveAnAccount().isDisplayed());
		logger.info("Don't have an account option is displayed");

		Assert.assertTrue(loginObject.SignUp().isDisplayed());
		logger.info("Sign up option is displayed");

		//Run valid login Validations
		loginObject.testValidLogin();
		logger.info("✅Login Validations is passed successfully");
		
		//Create Object for postloginPage
		postloginPage postloginObject = new postloginPage(driver);

		// Asserting that the elements are visible and text matches the expected values
		Assert.assertTrue(postloginObject.SubscribtionType().isDisplayed() , "Subscription type is not displayed if its Free or Premium");
		logger.info("Type of subscription is displayed");

		Assert.assertEquals(postloginObject.SubscribtionPrice().getText() , "$9.99");
		logger.info("Price of subscription is displayed");

		Assert.assertEquals(postloginObject.PerMonth().getText() , "/ per month");
		logger.info("Subscription duration is displayed");

		Assert.assertEquals(postloginObject.SubscribtionPoint1().getText() , "Unrestricted access to all Live and On-Demand video content");
		logger.info("Point 1 of subscription description is displayed");

		Assert.assertEquals(postloginObject.SubscribtionPoint2().getText() , "Game highlights and replays");
		logger.info("Point 2 of subscription description is displayed");

		Assert.assertEquals(postloginObject.SubscribtionPoint3().getText() , "News updates stats schedules league standings and more");
		logger.info("Point 3 of subscription description is displayed");

		Assert.assertEquals(postloginObject.Shortdescription().getText() , "*Charged monthly, cancel at anytime");
		logger.info("Short description is displayed");

		Assert.assertTrue(postloginObject.ProceedButtn().isEnabled() , "Procees button is not in enabled state");
		logger.info("Proceed to Payment button is in enabled state");

		Assert.assertTrue(postloginObject.SubscribeLater().isDisplayed() , "Subscribe late link is not displayed");
		logger.info("Subscribe later link is displayed");
		postloginObject.SubscribeLater().click();

		//Wait for Sign in  title to be visible and then run next command
		WebElement accountcreated = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='ACCOUNT CREATED SUCCESSFULLY']")));
		Assert.assertEquals(accountcreated.getText() , "ACCOUNT CREATED SUCCESSFULLY");
		logger.info("✅Post Login Validations is passed successfully");

		profilePage profilepageObject = new profilePage(driver);
		profilepageObject.Full_Name_Update(NEWFULLNAME_Test5);
		
		logger.info("✅Profile page Validations is passed successfully");

		passwordupdatePage crdupdateObject = new passwordupdatePage(driver);
		crdupdateObject.Password_Updation();
		logger.info("✅Password Update Validations is passed successfully");
	}

}
