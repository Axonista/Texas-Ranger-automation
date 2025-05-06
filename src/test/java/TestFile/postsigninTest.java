package TestFile;

import org.testng.annotations.Test;

import PageObjectFile.homePage;
import PageObjectFile.postsinginPage;
import PageObjectFile.signinPage;

public class postsigninTest extends BaseTest {

@Test

	public void PostSignin() 
	{


		homePage homepageObject = new homePage(driver);
		homepageObject.Homepage_Validations();
		signinPage signinObject= new signinPage(driver);
		signinObject.SigninVisibility();
		signinObject.Signin_Validations();
		postsinginPage postsigninObject = new postsinginPage(driver);
		postsigninObject.PostSignin_Validations();

	}
}
