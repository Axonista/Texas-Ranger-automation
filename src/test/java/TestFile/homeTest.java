package TestFile;
import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjectFile.homePage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class homeTest extends BaseTest{
	
	private static final Logger logger = LoggerFactory.getLogger(homeTest.class);

	@Test
	public void Homepage() {
		
		//Test case name
		logger.info("Test 1 : Validate Homepage elements are displayed and showing Proper text");
		
		//Create object for homePage file
		homePage homepageObject = new homePage(driver);
        
		// Asserting that the elements are visible and text matches the expected values
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
		
		// Run the homepage validations
		homepageObject.Homepage_Validations();
		logger.info("continue button is clicked");
		logger.info("✅Homepage Validations is passed successfully");
		
	}
}
