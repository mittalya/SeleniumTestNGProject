package Utils;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import POM.LoginPage;

public class LoginUtils {
     WebDriver driver;
     public LoginUtils (WebDriver driver){
    	 this.driver = driver;
     }

    public  void  UserLogin(String UserName, String Password) {
    	 LoginPage obj = new LoginPage(driver);
    	 obj.EnterUserName (UserName);
    	 WebDriverWait Waits = new WebDriverWait(driver,5);
    	 obj.EnterPassword(Password);
    	 Waits.until (ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[contains(@class,'signInBtn')]")));
    	 obj.ClickSignIn();
     }
}
