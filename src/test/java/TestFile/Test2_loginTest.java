package TestFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjectFile.loginPage;
import PageObjectFile.regionwarningPage;

public class Test2_loginTest extends BaseTest {
	private static final Logger logger = LoggerFactory.getLogger(Test1_regionwarningTest.class);
	@Test(
			testName = "ValidLoginTest", 
			description = "Verify successful login with valid credentials"
			)
	public void ValidLoginTest() 
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

	}
}





