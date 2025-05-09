package TestFile;

import org.testng.annotations.Test;
import PageObjectFile.homePage;


public class homeTest extends BaseTest{




	@Test
	public void Homepage() {


		homePage homepageObject = new homePage(driver);

		// Run the homepage validations
		homepageObject.Homepage_Validations();
		


	}
}
