package TestFile;

import org.testng.annotations.Test;

import PageObjectFile.homePage;
import PageObjectFile.postsinginPage;
import PageObjectFile.profilePage;
import PageObjectFile.signinPage;

public class profileTest extends BaseTest {
	 
	
	@Test
	public void ProfileTest() 
	{
	
	homePage homepageObject = new homePage(driver);
	homepageObject.Homepage_Validations();
	signinPage signinObject= new signinPage(driver);
	signinObject.SigninVisibility();
	signinObject.Signin_Validations();
	postsinginPage postsigninObject = new postsinginPage(driver);
	postsigninObject.PostSignin_Validations();
	profilePage profilepageObject = new profilePage(driver);
	profilepageObject.Profile_Validations();
	

}
}
