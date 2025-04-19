package testbase;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import adactingroup.ExcelReader;
import adactingroup.LoginPage;
import adactingroup.LogoutPage;

public class LogoutTest extends BaseClass{
	public WebDriver driver;
	LoginPage LP;
	LogoutPage logout;
	@BeforeClass
	public void setUpTest() throws Exception {
        LP = new LoginPage(BaseClass.driver);
        logout=new LogoutPage(BaseClass.driver);
        
        //login
        String username = ExcelReader.getCellValue("LoginData", 1, 0); // 2nd row, 1st column
	    String password = ExcelReader.getCellValue("LoginData", 1, 1); // 2nd row, 2nd column
	    LP.username("mangaipres");
		LP.password("mangai@123");
		Thread.sleep(500);
		LP.login();
		

        
    }
	@Test
	void TC_22_testlogout() throws Exception {
		logout.logout();
		Thread.sleep(2000);
		String actualMsg = logout.msg().getText();
	    System.out.println("Message: " + actualMsg);
	    //Assert.assertTrue(actualMsg.equalsIgnoreCase("You have successfully logged out."), "message mismatch");
	    Assert.assertTrue(actualMsg.toLowerCase().contains("you have successfully logged out.".toLowerCase()), "message mismatch");
		
	}
	
	

}
