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
        return driver.findElement(By.cssSelector("button[class*='border-dark-outline']"));
    }

    // Locators (methods to find elements)
    public WebElement SignInTitle() {
        return driver.findElement(By.cssSelector("h1[class*='mb-6']"));
    }
    public WebElement Subdesc() {
        return driver.findElement(By.cssSelector("p[class*='text-base']"));
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
        return driver.findElement(By.cssSelector("strong[class*='hover:no-underline']"));
    }

    public WebElement NoAccount() {
        return driver.findElement(By.cssSelector("p[class*='text-sm']"));
    }

    public WebElement SignUp() {
        return driver.findElement(By.cssSelector("strong[class*='ml-1']"));
    }
    
    
    public WebElement SigninBtn() {
        return driver.findElement(By.cssSelector("button[type='submit']"));
    }
    
    public void SigninVisibility()
        {
    	ContinueButton().click();
    	WebDriverWait wait = new WebDriverWait(driver, 10);
   	    WebElement signintitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[class*='mb-6']")));
   
   	    Assert.assertEquals(signintitle.getText(),  "SIGN IN");
		Assert.assertEquals(Subdesc().getText(), "Lonestar is only available in Texas, Louisiana, Oklahoma, Arkansas, and Eastern New Mexico.");
		Assert.assertTrue(Email().isDisplayed());
		Assert.assertTrue(Password().isDisplayed());
		Assert.assertTrue(Rememberme().isDisplayed());
		Assert.assertTrue(ForgotPassword().isDisplayed());
		Assert.assertTrue(NoAccount().isDisplayed());
		Assert.assertTrue(SignUp().isDisplayed());
		//Check Sign In Button is Disabled
		Assert.assertTrue(!SigninBtn().isEnabled());
    }

     public void Signin_Validations() {
     String email = System.getenv("EMAIL");
     String password = System.getenv("PASSWORD");
         
     Email().sendKeys(email);
     Password().sendKeys(password);
     Assert.assertTrue(SigninBtn().isEnabled());
     SigninBtn().click();
     
     WebDriverWait wait = new WebDriverWait(driver, 10);
	 WebElement subscribe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//main/div/h1")));
	
	 Assert.assertEquals(subscribe.getText(), "SUBSCRIBE");
	 
}
}

	


