package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	@FindBy (xpath= ".//*[@id='CAMUsername']")
	    WebElement UserName;
	@FindBy (xpath = ".//*[@id='CAMPassword']")
	    WebElement Password;
	@FindBy (xpath= ".//*[contains(@class,'signInBtn')]")
        WebElement SignIn;
	

	public void EnterUserName (String User) {
		UserName.sendKeys (User);
	}
	public void EnterPassword (String Pass) {
		Password.sendKeys(Pass);
	}

	public void ClickSignIn() {
		SignIn.click();
	}
}
