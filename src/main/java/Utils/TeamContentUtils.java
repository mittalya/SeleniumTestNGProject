package Utils;

import org.openqa.selenium.WebDriver;

import POM.TeamContent;

public class TeamContentUtils {
	WebDriver driver;
	public TeamContentUtils (WebDriver driver){
		this.driver = driver;
	}
	public void ClickTeamContent() {
		TeamContent team = new TeamContent(driver);
		team.ClickTeamContent();
	}
	
	public void ClickFolder1() {
		TeamContent folder = new TeamContent(driver);
		folder.OpenFolder();
	}
	
	public void ClickFolder2() {
		TeamContent folder2 = new TeamContent(driver);
		folder2.ClickFolder2();
	}
	
	public void ClickReport1() {
		TeamContent report = new TeamContent(driver);
		report.ClickReport();
	}
	
	public void WaitForReportLoad() {
		TeamContent reportload = new TeamContent(driver);
		reportload.ReportLoad();
	}
}
