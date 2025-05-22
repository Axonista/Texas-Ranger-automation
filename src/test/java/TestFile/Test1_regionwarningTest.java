package TestFile;
import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjectFile.regionwarningPage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class Test1_regionwarningTest extends BaseTest{
	
	private static final Logger logger = LoggerFactory.getLogger(Test1_regionwarningTest.class);
	@Test(testName = "ValidateWarningPage", description = "Validation of all elements on Region Warning Page")
	public void RegionWarningTest() {
		
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
		
	}
}
