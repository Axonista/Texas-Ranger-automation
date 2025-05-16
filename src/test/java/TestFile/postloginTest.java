package TestFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjectFile.homePage;
import PageObjectFile.postloginPage;
import PageObjectFile.loginPage;

public class postloginTest extends BaseTest {

	private static final Logger logger = LoggerFactory.getLogger(homeTest.class);

	@Test

	public void PostSignin() 
	{


		logger.info("Test 3 : Validate elements displayed after Login");
		// Asserting that the elements are visible and text matches the expected values
		homePage homepageObject = new homePage(driver);

		Assert.assertTrue(homepageObject.logo().isDisplayed(), "Logo is not displayed");
		logger.info("Logo is displayed");

		Assert.assertEquals(homepageObject.regionSupported().getText(), "OUTSIDE SUPPORTED REGIONS", "Region text is incorrect");
		logger.info("OUTSIDE SUPPORTED REGIONS is displayed");

		Assert.assertEquals(homepageObject.description1().getText(), "It looks like you're accessing Lonestar from outside one of our supported regions.", "Description 1 text is incorrect");
		logger.info("Description1 is displayed");

		Assert.assertEquals(homepageObject.description2().getText(), "You can still sign up, but you can only access the app when you're in: Texas, Louisiana, Oklahoma, Arkansas, Eastern New Mexico", "Description 2 text is incorrect");
		logger.info("Description2 is displayed");

		Assert.assertTrue(homepageObject.ContinueButton().isDisplayed(), "Continue button is not visible");
		logger.info("Continue Button is displayed");

		Assert.assertTrue(homepageObject.goHomeButton().isDisplayed(), "Go Home button is not visible");
		logger.info("Go Home button is displayed");


		homepageObject.Homepage_Validations();
		loginPage loginObject= new loginPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement signintitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='SIGN IN']")));

		Assert.assertEquals(signintitle.getText(),  "SIGN IN");
		logger.info("Sign in title is displayed");

		Assert.assertEquals(loginObject.Subdesc().getText(), "Lonestar is only available in Texas, Louisiana, Oklahoma, Arkansas, and Eastern New Mexico.");
		logger.info("Availability of Lonestar app description is displayed");

		Assert.assertTrue(loginObject.Email().isDisplayed());
		logger.info("Email field is displayed");

		Assert.assertTrue(loginObject.Password().isDisplayed());
		logger.info("Password field is displayed");

		Assert.assertTrue(!loginObject.SigninBtn().isEnabled());
		logger.info("Password field is disabled");

		Assert.assertTrue(loginObject.Rememberme().isDisplayed());
		logger.info("Remember me field is displayed");

		Assert.assertTrue(loginObject.ForgotPassword().isDisplayed());
		logger.info("Forgot password option is displayed");

		Assert.assertTrue(loginObject.NoAccount().isDisplayed());
		logger.info("Don't have an account option is displayed");

		Assert.assertTrue(loginObject.SignUp().isDisplayed());
		logger.info("Sign up option is displayed");

		loginObject.Login();

		Assert.assertTrue(loginObject.SigninBtn().isEnabled());
		logger.info("Sign in button is disabled");
		loginObject.SigninBtn().click();

		WebElement subscribe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='SUBSCRIBE']")));

		Assert.assertEquals(subscribe.getText(), "SUBSCRIBE");
		logger.info("Subscribe text is visible after logging in");

		logger.info("2nd Test Passed");

		postloginPage postsigninObject = new postloginPage(driver);
		Assert.assertTrue(postsigninObject.SubscribtionType().isDisplayed());
		logger.info("Type of subscription is displayed");

		Assert.assertEquals(postsigninObject.SubscribtionPrice().getText() , "$9.99");
		logger.info("Price of subscription is displayed");

		Assert.assertEquals(postsigninObject.PerMonth().getText() , "/ per month");
		logger.info("Subscription duration is displayed");

		Assert.assertEquals(postsigninObject.SubscribtionPoint1().getText() , "Unrestricted access to all Live and On-Demand video content");
		logger.info("Point 1 of subscription description is displayed");

		Assert.assertEquals(postsigninObject.SubscribtionPoint2().getText() , "Game highlights and replays");
		logger.info("Point 2 of subscription description is displayed");

		Assert.assertEquals(postsigninObject.SubscribtionPoint3().getText() , "News updates stats schedules league standings and more");
		logger.info("Point 3 of subscription description is displayed");

		Assert.assertEquals(postsigninObject.Shortdesc().getText() , "*Charged monthly, cancel at anytime");
		logger.info("Short description is displayed");

		Assert.assertTrue(postsigninObject.ProceedBtn().isEnabled());
		logger.info("Proceed to Payment button is displayed");

		Assert.assertTrue(postsigninObject.SubscribeLater().isDisplayed());
		logger.info("Subscribe later option is displayed");
		postsigninObject.PostSignin_Validations();
		logger.info("✅Post Login Validations is passed successfully");

	}
}
