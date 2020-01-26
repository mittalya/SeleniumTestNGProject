package POM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TeamContent {
		WebDriver driver;
		public TeamContent (WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		@FindBy (xpath= ".//*[@id='com.ibm.bi.contentApps.teamFoldersSlideout']")
	      WebElement Teamcontents;
		
		@FindBy (xpath= ".//*[@id='lc_40']/tbody/tr[1]/td[2]/div")
	      WebElement FirstFolder;
		
		@FindBy (xpath= ".//*[@title='Dashboard1108']")
	      WebElement SecondFolder;
		
		@FindBy (xpath= ".//*[@class='nameColumnDiv contentListFocusable clickable active']")
	      WebElement Report;
		
		@FindBy (xpath= ".//*[@class='lgd-title']")
	      WebElement ReportLocator;
		
		public void ClickTeamContent() {
			Teamcontents.click();
			}
		public void OpenFolder(){
			FirstFolder.click();
		}
		
		public void ClickFolder2(){
			SecondFolder.click();
			driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		}
		
		public void ClickReport(){
			Report.click();
			driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		}
		
		public void ReportLoad(){
		WebDriverWait Waits = new WebDriverWait(driver,20);
		Waits.until (ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='lgd-title']")));
		}
}

