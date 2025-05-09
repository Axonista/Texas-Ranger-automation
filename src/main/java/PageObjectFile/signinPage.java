package PageObjectFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class signinPage {
	
	WebDriver driver;

    // Constructor
    public signinPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public WebElement ContinueButton() {
        return driver.findElement(By.xpath("//*[contains(text(), 'Continue')]"));
    }

    // Locators (methods to find elements)
    //public WebElement SignInTitle() {
       // return driver.findElement(By.xpath("//*[contains(text(),\"SIGN IN\")]"));
    //}
    public WebElement Subdesc() {
        return driver.findElement(By.xpath("//*[contains(text(),\"Lonestar is only available in \")]"));
    }
    
    public WebElement Email() {
        return driver.findElement(By.id("email"));
    }

    public WebElement Password() {
        return driver.findElement(By.id("password"));
    }

    public WebElement Rememberme() {
        return driver.findElement(By.id("remember-me"));
    }
    
    public WebElement ForgotPassword() {
        return driver.findElement(By.xpath("//*[text()='Forgot your password?']"));
    }

    public WebElement NoAccount() {
        return driver.findElement(By.xpath("//*[text()=\"Don't have an account?\"]"));
    }

    public WebElement SignUp() {
        return driver.findElement(By.xpath("//*[text()='Sign Up']")); 
    }
    
    
    public WebElement SigninBtn() {
        return driver.findElement(By.xpath("//*[text()='Sign In']"));
    }
    
    public void SigninVisibility()
        {
    	ContinueButton().click();
    	WebDriverWait wait = new WebDriverWait(driver, 10);
   	    WebElement signintitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='SIGN IN']")));
                             
   	    Assert.assertEquals(signintitle.getText(),  "SIGN IN");
   	    System.out.println("Sign in title is displayed");
   	 
		Assert.assertEquals(Subdesc().getText(), "Lonestar is only available in Texas, Louisiana, Oklahoma, Arkansas, and Eastern New Mexico.");
		System.out.println("Availability of Lonestar app description is displayed");
		
		Assert.assertTrue(Email().isDisplayed());
		System.out.println("Email field is displayed");
		
		Assert.assertTrue(Password().isDisplayed());
		System.out.println("Password field is displayed");
		
		Assert.assertTrue(Rememberme().isDisplayed());
		System.out.println("Remember me field is displayed");
		
		Assert.assertTrue(ForgotPassword().isDisplayed());
		System.out.println("Forgot password option is displayed");
		
		Assert.assertTrue(NoAccount().isDisplayed());
		System.out.println("Don't have an account option is displayed");
		
		Assert.assertTrue(SignUp().isDisplayed());
		System.out.println("Sign up option is displayed");
		//Check Sign In Button is Disabled
		
    }

     public void Signin_Validations() {
     String email = System.getenv("EMAIL");
     String password = System.getenv("PASSWORD");
         
     Email().sendKeys(email);
     Password().sendKeys(password);
     Assert.assertTrue(SigninBtn().isEnabled());
     SigninBtn().click();
     
     WebDriverWait wait = new WebDriverWait(driver, 10);
	 WebElement subscribe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='SUBSCRIBE']")));
	
	 Assert.assertEquals(subscribe.getText(), "SUBSCRIBE");
	 
	 System.out.println("2nd Test Passed");
	 
}
     
}

	


