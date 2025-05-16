package PageObjectFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	
	WebDriver driver;

    // Constructor
    public loginPage(WebDriver driver) {
        this.driver = driver;
    }
    
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
        return driver.findElement(By.xpath("//button[@type='submit']"));
    }
    

     public void Login() {
     String email = System.getenv("EMAIL");
     String password = System.getenv("PASSWORD");
         
     Email().sendKeys(email);
     Password().sendKeys(password);
     
    
	 
}
     
}

	


