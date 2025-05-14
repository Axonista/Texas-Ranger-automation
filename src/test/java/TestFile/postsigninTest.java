package TestFile;

import org.testng.annotations.Test;

import PageObjectFile.homePage;
import PageObjectFile.postsinginPage;
import PageObjectFile.loginPage;

public class postsigninTest extends BaseTest {

@Test

	public void PostSignin() 
	{


		homePage homepageObject = new homePage(driver);
		homepageObject.Homepage_Validations();
		loginPage signinObject= new loginPage(driver);
		signinObject.SigninVisibility();
		signinObject.Login();
		postsinginPage postsigninObject = new postsinginPage(driver);
		postsigninObject.PostSignin_Validations();
		

	}
}
