package TestFile;
import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjectFile.homePage;
public class homeTest extends BaseTest{
	@Test
	public void Homepage() {
		// Asserting that the elements are visible and text matches the expected values
		homePage homepageObject = new homePage(driver);
        
		Assert.assertTrue(homepageObject.logo().isDisplayed(), "Logo is not displayed");
		System.out.println("Logo is displayed");
		
		Assert.assertEquals(homepageObject.regionSupported().getText(), "OUTSIDE SUPPORTED REGIONS", "Region text is incorrect");
		System.out.println("OUTSIDE SUPPORTED REGIONS is displayed");
		
		Assert.assertEquals(homepageObject.description1().getText(), "It looks like you're accessing Lonestar from outside one of our supported regions.", "Description 1 text is incorrect");
		System.out.println("Description1 is displayed");
		
		Assert.assertEquals(homepageObject.description2().getText(), "You can still sign up, but you can only access the app when you're in: Texas, Louisiana, Oklahoma, Arkansas, Eastern New Mexico", "Description 2 text is incorrect");
		System.out.println("Description2 is displayed");
		
		Assert.assertTrue(homepageObject.ContinueButton().isDisplayed(), "Continue button is not visible");
		System.out.println("Continue Button is displayed");
		
		Assert.assertTrue(homepageObject.goHomeButton().isDisplayed(), "Go Home button is not visible");
		System.out.println("Go Home button is displayed");
		// Run the homepage validations
		homepageObject.Homepage_Validations();
		System.out.println("continue button is clicked");
	}
}
