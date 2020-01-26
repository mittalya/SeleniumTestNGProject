package BaseTest;

import java.sql.DriverManager;
import java.sql.ResultSet;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class DbConnection {
	
	static Connection con = null;
	 private static Statement stmt;
	 public static String dburl = "jdbc:mysql://localhost:3306/login";
	 public static String user = "root";
	 public static String Pass = "Password0!";
 
	 @Test
  public void test() {try {
		 String query = "select * from login.logindetails";
	        ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				System.out.print(rs.getString(1));
				System.out.print("\t" + rs.getString(2));
				 }
		} catch (Exception e) {
			System.out.println(e);
		}
  }
  @BeforeTest
    public void DatabaseConnection() throws Exception {
			 try {
		        Class.forName("com.mysql.jdbc.Driver").newInstance();
			 
			 Connection con = (Connection) DriverManager.getConnection (dburl,user,Pass);
			 stmt = (Statement) con.createStatement();
			 }
	  
			 catch (Exception e){
				 e.printStackTrace();
			 }
	  }
			 

  @AfterTest
  public void tearDown() throws Exception {
	  	              if (con != null) {
	  	            	  con.close();
	  	            	  }
	  
  }

}
