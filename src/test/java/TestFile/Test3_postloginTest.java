package TestFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjectFile.regionwarningPage;
import PageObjectFile.postloginPage;
import PageObjectFile.loginPage;

public class Test3_postloginTest extends BaseTest {

	private static final Logger logger = LoggerFactory.getLogger(Test1_regionwarningTest.class);
	@Test(
			testName = "PostLoginTest", 
			description = "Verify all the elements on Subscription card after successful login"
			)
	public void PostLoginTest() 
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
		logger.info("✅Region Warning Page validations is passed successfully");

		//Create object for loginPage file
		loginPage loginObject= new loginPage(driver);

		// Asserting that the elements are visible and text matches the expected values
		Assert.assertEquals(loginObject.SubDescription().getText(), "Lonestar is only available in Texas, Louisiana, Oklahoma, Arkansas, and Eastern New Mexico.");
		logger.info("Availability of Lonestar app description is displayed");

		Assert.assertTrue(loginObject.Email().isDisplayed(), "Email field is not displayed");
		logger.info("Email field is displayed");

		Assert.assertTrue(loginObject.Password().isDisplayed() , "Password field is not dispalyed");
		logger.info("Password field is displayed");

		Assert.assertTrue(!loginObject.SigninButton().isEnabled() , "Sign in button is not disabled");
		logger.info("Password field is disabled");

		Assert.assertTrue(loginObject.Rememberme().isDisplayed(),"Remember me link is not displayed");
		logger.info("Remember me field is displayed");

		Assert.assertTrue(loginObject.ForgotPassword().isDisplayed() , "Forgot me link is not displayed");
		logger.info("Forgot password option is displayed");

		Assert.assertTrue(loginObject.DontHaveAnAccount().isDisplayed(),"Done have an account link is not displayed");
		logger.info("Don't have an account option is displayed");

		Assert.assertTrue(loginObject.SignUp().isDisplayed() , "Sign up link is not displayed");
		logger.info("Sign up option is displayed");

		//Run valid login validations
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
		logger.info("Subscribe later link is clicked");

		//Wait for Sign in  title to be visible and then run next command
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement accountcreated = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='ACCOUNT CREATED SUCCESSFULLY']")));
		Assert.assertEquals(accountcreated.getText() , "ACCOUNT CREATED SUCCESSFULLY");
		logger.info("Account Created Successfully message is displayed successfully");
		logger.info("✅Post Login Validations is passed successfully");

	}
}
