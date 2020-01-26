package TestCases;


import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseTest.BaseTest;
import DataReader.ExcelReader;
import Utils.HomePageUtils;
import Utils.LoginUtils;
import Utils.TeamContentUtils;

public class Login extends BaseTest {
  @Test(dataProvider= "loginData")
  public void TestLoginPass(String UserName, String Password) throws InterruptedException{
		LoginUtils loginutils = new LoginUtils(driver);
		loginutils.UserLogin(UserName, Password);
		HomePageUtils home = new HomePageUtils(driver);
		String heading = home.VerifyHomePage();
		Assert.assertEquals(heading, "MES welcome");
		TeamContentUtils teamcontentutils = new TeamContentUtils(driver);
		teamcontentutils.ClickTeamContent();
		teamcontentutils.ClickFolder1();
		teamcontentutils.ClickFolder2();
		teamcontentutils.ClickReport1();
		long start = System.currentTimeMillis();
		teamcontentutils.WaitForReportLoad();
		long timeToLoad= (System.currentTimeMillis()-start);
		System.out.println(timeToLoad);
			 }
/*	  @DataProvider (name="LoginData1")
	  public Object [][] getDataFromDataProvider1(Method a){
		  if (a.getName().equalsIgnoreCase("UserLogin")) {
	  return new Object [][]
			  {
		  {"yasmittal", "yasmittal"}
			  };}
		  else {
		return new Object [][]
				  {
			  {"yasmittal", "yasmittal"}
				  };
		  }
	}*/
  
  @DataProvider
  public String[][] loginData() throws InvalidFormatException, IOException{
		ExcelReader read = new ExcelReader();
		return read.getCellData("C:\\Users\\yasmittal\\Documents\\Selenium package\\SeleniumTestNG-master\\SeleniumTestNG-master\\src\\test\\resources\\Datasheet_Demo.xlsx","Login");
		}
}

