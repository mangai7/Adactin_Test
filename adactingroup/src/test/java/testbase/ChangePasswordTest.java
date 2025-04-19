package testbase;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import adactingroup.BookHotelPage;
import adactingroup.ChangePassword;
import adactingroup.ExcelReader;
import adactingroup.LoginPage;
import adactingroup.SearchHotelPage;

public class ChangePasswordTest extends BaseClass {
	public WebDriver driver;
	LoginPage LP;
	SearchHotelPage SHP;
	BookHotelPage BHP;
	ChangePassword CP;
	
	@BeforeClass
    public void setUpTest() throws Exception {
        LP = new LoginPage(BaseClass.driver);
        SHP = new SearchHotelPage(BaseClass.driver);
        BHP = new BookHotelPage(BaseClass.driver);
        CP = new ChangePassword(BaseClass.driver);
        //login
        String username = ExcelReader.getCellValue("LoginData", 1, 0); // 2nd row, 1st column
	    String password = ExcelReader.getCellValue("LoginData", 1, 1); // 2nd row, 2nd column
	    LP.username(username);
		LP.password(password);
		Thread.sleep(500);
		LP.login();
		

        
    }
	@Test
	void TC_21_testChangePassword() throws InterruptedException {
		CP.changepassword();
		CP.currentpassword("Mangai@123");
		CP.newpassword("mangai@123");
		CP.confirmpass("mangai@123");
		CP.submit();
		Thread.sleep(1000);
		String actualMsg = CP.successmsg().getText();
	    System.out.println("Message: " + actualMsg);
	    Assert.assertTrue(actualMsg.equalsIgnoreCase("Your Password is successfully updated!!!"), "message mismatch");
	    
	}
	

}
