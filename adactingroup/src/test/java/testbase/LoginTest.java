package testbase;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import adactingroup.ExcelReader;
import adactingroup.LoginPage;


public class LoginTest extends BaseClass{
	public WebDriver driver;
	LoginPage LP;
    
	@BeforeClass
    public void setUpTest() {
        LP = new LoginPage(BaseClass.driver);
    }
	@Test(priority = 1)
	void TC_01_testLoginButtonVisible() {
		boolean isLoginButtonVisible = LP.isLoginButtonVisible();

        // TestNG assertion to check visibility
        Assert.assertTrue(isLoginButtonVisible, "Login button is NOT visible.");
    
	}
	@Test(priority = 2)
	void TC_02_tesLogintButtonClickable() {
        // WebDriverWait to ensure the element is clickable
        WebDriverWait wait = new WebDriverWait(BaseClass.driver, Duration.ofSeconds(20));
        
        // Wait until the login button is clickable
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(LP.getLoginbutton()));

        // Assert that the login button is clickable
        Assert.assertNotNull(loginButton, "Login button is NOT clickable.");
        System.out.println("Login  button is clickable.");
    }
	
	
	@Test(priority = 3)
	void TC_03_testInvalidUsernameAndvalidPassword(){
		String username = ExcelReader.getCellValue("LoginData", 2, 0); 
	    String password = ExcelReader.getCellValue("LoginData", 2, 1); 


		LP.username(username);
		LP.password(password);
		LP.login();
		String actualTitle = BaseClass.driver.getTitle();
		System.out.println("Page Title after login: " + actualTitle);

		//Assert.assertTrue(actualTitle.equalsIgnoreCase("Adactin.com - Search Hotel"), "Title mismatch (case-insensitive)");
		
		Assert.assertNotEquals(actualTitle, "Adactin.com - Search Hotel", "❌ Expected login to fail, but succeeded.");
		System.out.println("Successfully Loginfailed\n");
	}
	
	@Test(priority = 4)
	void TC_04_testInvalidUsernameAndValidPassword(){
		String username = ExcelReader.getCellValue("LoginData", 3, 0); 
	    String password = ExcelReader.getCellValue("LoginData", 3, 1); 

		LP.username(username);
		LP.password(password);
		LP.login();
		String actualTitle = BaseClass.driver.getTitle();
		System.out.println("Page Title after login: " + actualTitle);

		//Assert.assertTrue(actualTitle.equalsIgnoreCase("Adactin.com - Search Hotel"), "Title mismatch (case-insensitive)");
		
		Assert.assertNotEquals(actualTitle, "Adactin.com - Search Hotel", "❌ Expected login to fail, but succeeded.");
		System.out.println(" Successfully Loginfailed \n");
	}
	
	void TC_05_testInvalidUsernameAndInvalidPassword(){
		String username = ExcelReader.getCellValue("LoginData", 4, 0); 
	    String password = ExcelReader.getCellValue("LoginData", 4, 1); 

		LP.username(username);
		System.out.println("username" + username);
		LP.password(password);
		LP.login();
		String actualTitle = BaseClass.driver.getTitle();
		System.out.println("Page Title after login: " + actualTitle);

		//Assert.assertTrue(actualTitle.equalsIgnoreCase("Adactin.com - Search Hotel"), "Title mismatch (case-insensitive)");
		
		Assert.assertNotEquals(actualTitle, "Adactin.com - Search Hotel", "❌ Expected login to fail, but succeeded.");
		System.out.println(" Successfully Loginfailed \n");
	}
	
	@Test(priority =6 )
	void TC_06_testvalidlogin() throws Exception {
		String username = ExcelReader.getCellValue("LoginData", 1, 0); // 2nd row, 1st column
	    String password = ExcelReader.getCellValue("LoginData", 1, 1); // 2nd row, 2nd column


		LP.username(username);
		LP.password(password);
		Thread.sleep(500);
		LP.login();
		Thread.sleep(500);
		String actualTitle = BaseClass.driver.getTitle();
		System.out.println("Page Title after login: " + actualTitle);

		//Assert.assertTrue(actualTitle.equalsIgnoreCase("Adactin.com - Search Hotel"), "Title mismatch (case-insensitive)");
		
		Assert.assertEquals(actualTitle, "Adactin.com - Search Hotel", "✅ Expected login to succeed, but failed.");
        System.out.println("Successfully LoginSuccess\n");
        
	}

	
}


