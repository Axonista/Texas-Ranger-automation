package TestFile;

import org.testng.annotations.Test;

import PageObjectFile.homePage;
import PageObjectFile.postsinginPage;
import PageObjectFile.profilePage;
import PageObjectFile.loginPage;

public class profileTest extends BaseTest {
	 
	
	@Test
	public void ProfileTest() 
	{
	
	homePage homepageObject = new homePage(driver);
	homepageObject.Homepage_Validations();
	loginPage signinObject= new loginPage(driver);
	signinObject.SigninVisibility();
	signinObject.Login();
	postsinginPage postsigninObject = new postsinginPage(driver);
	postsigninObject.PostSignin_Validations();
	profilePage profilepageObject = new profilePage(driver);
	profilepageObject.Profile_Validations();
	

}
}
