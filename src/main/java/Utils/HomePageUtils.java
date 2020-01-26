package Utils;

import org.openqa.selenium.WebDriver;

import POM.HomePage;

public class HomePageUtils {
	WebDriver driver;
	public HomePageUtils (WebDriver driver){
		this.driver = driver;
	}
	public String VerifyHomePage() {
		HomePage home = new HomePage(driver);
		String heading = home.VerifyHeading();
		return heading;
	}
   
}
