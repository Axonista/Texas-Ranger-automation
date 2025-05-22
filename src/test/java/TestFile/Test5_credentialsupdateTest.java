package TestFile;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjectFile.credentialsupdatePage;
import PageObjectFile.regionwarningPage;
import PageObjectFile.loginPage;
import PageObjectFile.postloginPage;
import PageObjectFile.profilePage;

public class Test5_credentialsupdateTest extends BaseTest {
	
	private static final Logger logger = LoggerFactory.getLogger(Test1_regionwarningTest.class);
	
	@Test(testName = "UpdateCredentials", description = "Verify email address and password is updated successfully on Accounts Page")
	public void CredentialsUpdateTest() 
	{

	//Create object for homePage
	regionwarningPage homeloginObject = new regionwarningPage(driver);
	// Asserting that the elements are visible and text matches the expected values
	Assert.assertTrue(homeloginObject.logo().isDisplayed(), "Logo is not displayed");
	System.out.println("Logo is displayed");

	Assert.assertEquals(homeloginObject.regionSupported().getText(), "OUTSIDE SUPPORTED REGIONS", "Region text is incorrect");
	System.out.println("OUTSIDE SUPPORTED REGIONS is displayed");

	Assert.assertEquals(homeloginObject.description1().getText(), "It looks like you're accessing Lonestar from outside one of our supported regions.", "Description 1 text is incorrect");
	System.out.println("Description1 is displayed");

	Assert.assertEquals(homeloginObject.description2().getText(), "You can still sign up, but you can only access the app when you're in: Texas, Louisiana, Oklahoma, Arkansas, Eastern New Mexico", "Description 2 text is incorrect");
	System.out.println("Description2 is displayed");

	Assert.assertTrue(homeloginObject.ContinueButton().isDisplayed(), "Continue button is not visible");
	System.out.println("Continue Button is displayed");

	Assert.assertTrue(homeloginObject.goHomeButton().isDisplayed(), "Go Home button is not visible");
	System.out.println("Go Home button is displayed");

	homeloginObject.Move_To_SigninPage();
	loginPage loginObject= new loginPage(driver);
	WebDriverWait wait = new WebDriverWait(driver, 10);
	WebElement signintitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='SIGN IN']")));

	Assert.assertEquals(signintitle.getText(),  "SIGN IN");
	System.out.println("Sign in title is displayed");

	Assert.assertEquals(loginObject.Subdesc().getText(), "Lonestar is only available in Texas, Louisiana, Oklahoma, Arkansas, and Eastern New Mexico.");
	System.out.println("Availability of Lonestar app description is displayed");

	Assert.assertTrue(loginObject.Email().isDisplayed());
	System.out.println("Email field is displayed");

	Assert.assertTrue(loginObject.Password().isDisplayed());
	System.out.println("Password field is displayed");

	Assert.assertTrue(!loginObject.SigninBtn().isEnabled());
	System.out.println("Password field is disabled");

	Assert.assertTrue(loginObject.Rememberme().isDisplayed());
	System.out.println("Remember me field is displayed");

	Assert.assertTrue(loginObject.ForgotPassword().isDisplayed());
	System.out.println("Forgot password option is displayed");

	Assert.assertTrue(loginObject.NoAccount().isDisplayed());
	System.out.println("Don't have an account option is displayed");

	Assert.assertTrue(loginObject.SignUp().isDisplayed());
	System.out.println("Sign up option is displayed");

	loginObject.testValidLogin();

	Assert.assertTrue(loginObject.SigninBtn().isEnabled());
	loginObject.SigninBtn().click();

	WebElement subscribe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='SUBSCRIBE']")));

	Assert.assertEquals(subscribe.getText(), "SUBSCRIBE");

	System.out.println("2nd Test Passed");


	postloginPage postsigninObject = new postloginPage(driver);
	Assert.assertTrue(postsigninObject.SubscribtionType().isDisplayed());
	System.out.println("Type of subscription is displayed");

	Assert.assertEquals(postsigninObject.SubscribtionPrice().getText() , "$9.99");
	System.out.println("Price of subscription is displayed");

	Assert.assertEquals(postsigninObject.PerMonth().getText() , "/ per month");
	System.out.println("Subscription duration is displayed");

	Assert.assertEquals(postsigninObject.SubscribtionPoint1().getText() , "Unrestricted access to all Live and On-Demand video content");
	System.out.println("Point 1 of subscription description is displayed");

	Assert.assertEquals(postsigninObject.SubscribtionPoint2().getText() , "Game highlights and replays");
	System.out.println("Point 2 of subscription description is displayed");

	Assert.assertEquals(postsigninObject.SubscribtionPoint3().getText() , "News updates stats schedules league standings and more");
	System.out.println("Point 3 of subscription description is displayed");

	Assert.assertEquals(postsigninObject.Shortdesc().getText() , "*Charged monthly, cancel at anytime");
	System.out.println("Short description is displayed");

	Assert.assertTrue(postsigninObject.ProceedBtn().isEnabled());
	System.out.println("Proceed to Payment button is displayed");

	Assert.assertTrue(postsigninObject.SubscribeLater().isDisplayed());
	System.out.println("Subscribe later option is displayed");
	postsigninObject.PostSignin_Validations();

	profilePage profilepageObject = new profilePage(driver);
	profilepageObject.Profile_Validations();

	WebElement fullname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));

	new Actions(driver).click(fullname).keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).sendKeys(System.getenv("NEWFULLNAME")).perform();
	WebElement savechanges = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()= 'Save Changes']")));
	savechanges.click();
	Assert.assertEquals(fullname.getAttribute("value") , System.getenv("NEWFULLNAME"));
	System.out.println("Full name is updated successfully");

	System.out.println("4rd Test Passed");
	credentialsupdatePage crdupdateObject = new credentialsupdatePage(driver);
	crdupdateObject.Credentials_Updation();
	}




}
