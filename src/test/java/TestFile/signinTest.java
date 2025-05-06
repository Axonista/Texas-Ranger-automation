package TestFile;

import org.testng.annotations.Test;

import PageObjectFile.homePage;
import PageObjectFile.signinPage;




public class signinTest extends BaseTest {

	@Test
	public void Signin() 
	{


		homePage homepageObject = new homePage(driver);
		homepageObject.Homepage_Validations();
		signinPage signinObject= new signinPage(driver);
		signinObject.SigninVisibility();
		signinObject.Signin_Validations();
		System.out.println("1st Test Passed");

	}

}



