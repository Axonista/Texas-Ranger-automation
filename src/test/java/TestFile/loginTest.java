package TestFile;import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjectFile.homePage;
import PageObjectFile.loginPage;


public class loginTest extends BaseTest {

	@Test
	public void Signin() 
	{

		// Asserting that the elements are visible and text matches the expected values
		homePage homeloginObject = new homePage(driver);

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

		homeloginObject.Homepage_Validations();
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

		Assert.assertTrue(loginObject.Rememberme().isDisplayed());
		System.out.println("Remember me field is displayed");

		Assert.assertTrue(loginObject.ForgotPassword().isDisplayed());
		System.out.println("Forgot password option is displayed");

		Assert.assertTrue(loginObject.NoAccount().isDisplayed());
		System.out.println("Don't have an account option is displayed");

		Assert.assertTrue(loginObject.SignUp().isDisplayed());
		System.out.println("Sign up option is displayed");
		//Check Sign In Button is Disabled

	}

}



