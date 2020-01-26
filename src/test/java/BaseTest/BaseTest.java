package BaseTest;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {
protected WebDriver driver;
	 

@BeforeTest
@Parameters ({"browser","url"})
public void beforeTest(String browser, String url) throws Exception{
	if(browser.equalsIgnoreCase("Chrome")) {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\yasmittal\\Documents\\chromedriver.exe");
	  driver = new ChromeDriver();
	}
	else if(browser.equalsIgnoreCase("Firefox")) {
		  System.setProperty("webdriver.gecko.driver", "C:\\Users\\yasmittal\\Documents\\geckodriver.exe");
		  driver = new FirefoxDriver();
		}
	else if(browser.equalsIgnoreCase("IE")) {
		InternetExplorerOptions options = new InternetExplorerOptions();
		options.enablePersistentHovering();
		options.introduceFlakinessByIgnoringSecurityDomains();
		options.ignoreZoomSettings();
		options.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
		options.setCapability("allow-blocked-content", true);
		options.setCapability("allowBlockedContent", true);
		
		/*DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
		capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		capabilities.setCapability("allow-blocked-content", true);
		capabilities.setCapability("allowBlockedContent", true);*/
		 
		System.setProperty("webdriver.ie.driver", "C:\\Users\\yasmittal\\Documents\\IEDriverServer.exe");
		  
		  driver = new InternetExplorerDriver(options);
		}
	else {
		throw new Exception("Browser is not correct");
	}
	  driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       //String BaseUrl = "https://gmail.com";
 	  driver.get(url);
}

public void TakeScreenshots(WebDriver driver ) throws Exception {
	String FileWithPath = "C:\\Users\\yasmittal\\Documents\\Selenium package\\SeleniumTestNG-master\\SeleniumTestNG-master\\test-output\\Screenshots";
	TakesScreenshot scrShot = ((TakesScreenshot)driver);
	File ScrFile = scrShot.getScreenshotAs(OutputType.FILE);
	File DestFile = new File(FileWithPath);
	FileUtils.copyFile(ScrFile, DestFile);
}

@AfterMethod

public void afterMethod() {
    driver.close();

}




@AfterTest
  public void afterTest() {
	  driver.quit();
  }

@BeforeSuite
  public void beforeSuite() {
  }

@AfterSuite
  public void afterSuite() {
  }

}
