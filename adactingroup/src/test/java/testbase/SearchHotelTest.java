package testbase;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import adactingroup.ExcelReader;
import adactingroup.LoginPage;
import adactingroup.SearchHotelPage;

public class SearchHotelTest extends BaseClass{
	public WebDriver driver;
	LoginPage LP;
	SearchHotelPage SHP;
    
	@BeforeClass
    public void setUpTest() throws Exception {
        LP = new LoginPage(BaseClass.driver);
        SHP = new SearchHotelPage(BaseClass.driver);
        //login
        String username = ExcelReader.getCellValue("LoginData", 1, 0); // 2nd row, 1st column
	    String password = ExcelReader.getCellValue("LoginData", 1, 1); // 2nd row, 2nd column
	    LP.username(username);
		LP.password(password);
		Thread.sleep(500);
		LP.login();
        
    }
	@Test
	void TC_07_testSearchHotel() throws Exception {
		SHP.selectLocation("Sydney");
		Thread.sleep(500);
		SHP.selectHotel("Hotel Creek");
		Thread.sleep(500);
		SHP.selectRoomType("Double");
		Thread.sleep(500);
		SHP.selectNumberOfRoom("2 - Two");
		Thread.sleep(500);
		SHP.selectInDate("20/09/2025"); //"dd/mm/yyyy"
		Thread.sleep(500);
		SHP.selectOutDate("21/09/2025");//"dd/mm/yyyy"
		Thread.sleep(500);
		SHP.selectNumberOfAdult("2 - Two");
		Thread.sleep(500);
		SHP.selectNumberOfChild("2 - Two");
		Thread.sleep(500);
		SHP.SelectSearch();
		String actualTitle = BaseClass.driver.getTitle();
		System.out.println("Page Title after login: " + actualTitle);
		Assert.assertEquals(actualTitle, "Adactin.com - Select Hotel", "Expected  failed.");
        
	
}
	@Test(priority = 2)
	void TC_08_testMissingInDate() throws Exception {
		SHP.SelectSearchIcon();
	    SHP.selectLocation("Sydney");
	    Thread.sleep(500);
	    SHP.selectHotel("Hotel Creek");
	    Thread.sleep(500);
	    SHP.selectRoomType("Double");
	    Thread.sleep(500);
	    // Do NOT select room number
	    SHP.selectNumberOfRoom("2 - Two");
	    
	    SHP.indateclear();
	    Thread.sleep(500);
	    SHP.selectOutDate("21/09/2025");
	    Thread.sleep(500);
	    SHP.selectNumberOfAdult("2 - Two");
	    Thread.sleep(500);
	    SHP.selectNumberOfChild("1 - One");
	    Thread.sleep(500);
	    SHP.SelectSearch();

	    // Validate error message
	    String actualMsg = SHP.checkinspan().getText();
	    System.out.println("Error Message: " + actualMsg);
	    //Assert.assertEquals(actualMsg, "Please Select Check-In Date", "Error message mismatch");
	    Assert.assertTrue(actualMsg.equalsIgnoreCase("Please Select Check-In Date"), "Error message mismatch");	
	    

	}

	@Test(priority = 3)
	void TC_09_testMissingOutDate() throws Exception {
		SHP.SelectSearchIcon();
	    SHP.selectLocation("Sydney");
	    Thread.sleep(500);
	    SHP.selectHotel("Hotel Creek");
	    Thread.sleep(500);
	    SHP.selectRoomType("Double");
	    Thread.sleep(500);
	    // Do NOT select room number
	    SHP.selectNumberOfRoom("2 - Two");
	    
	    SHP.indateclear();
	    Thread.sleep(500);
		SHP.selectInDate("20/09/2025"); //"dd/mm/yyyy"
	    Thread.sleep(500);
	    SHP.outdateclear();
	    Thread.sleep(500);
	    SHP.selectNumberOfAdult("2 - Two");
	    Thread.sleep(500);
	    SHP.selectNumberOfChild("1 - One");
	    Thread.sleep(500);
	    SHP.SelectSearch();

	    // Validate error message
	    String actualMsg = SHP.checkoutspan().getText();
	    System.out.println("Error Message: " + actualMsg);
	    Assert.assertTrue(actualMsg.equalsIgnoreCase("Please Select Check-Out Date"), "Error message mismatch");	
	    }

	@Test(priority = 4)
	void TC_10_testDateBedoreInDate() throws Exception {
		SHP.SelectSearchIcon();
		SHP.selectLocation("Sydney");
		Thread.sleep(500);
		SHP.selectHotel("Hotel Creek");
		Thread.sleep(500);
		SHP.selectRoomType("Double");
		Thread.sleep(500);
		SHP.selectNumberOfRoom("2 - Two");
		Thread.sleep(500);
		SHP.selectInDate("20/09/2025"); //"dd/mm/yyyy"
		Thread.sleep(500);
		SHP.selectOutDate("19/09/2025");//"dd/mm/yyyy" //given befor in-date
		Thread.sleep(500);
		SHP.selectNumberOfAdult("2 - Two");
		Thread.sleep(500);
		SHP.selectNumberOfChild("2 - Two");
		Thread.sleep(500);
		SHP.SelectSearch();
		String actualMsg = SHP.checkoutspan().getText();
	    System.out.println("Error Message: " + actualMsg);
	    Assert.assertTrue(actualMsg.equalsIgnoreCase("Check-Out Date shall be after than Check-In Date"), "Error message mismatch");
	
}
	@Test(priority = 4)
	void TC_11_testWithoutLocation() throws Exception {
		SHP.SelectSearchIcon();
		//SHP.selectLocation("Sydney");
		//Thread.sleep(500);
		SHP.selectHotel("Hotel Creek");
		Thread.sleep(500);
		SHP.selectRoomType("Double");
		Thread.sleep(500);
		SHP.selectNumberOfRoom("2 - Two");
		Thread.sleep(500);
		SHP.selectInDate("20/09/2025"); //"dd/mm/yyyy"
		Thread.sleep(500);
		SHP.selectOutDate("19/09/2025");//"dd/mm/yyyy" //given befor in-date
		Thread.sleep(500);
		SHP.selectNumberOfAdult("2 - Two");
		Thread.sleep(500);
		SHP.selectNumberOfChild("2 - Two");
		Thread.sleep(500);
		SHP.SelectSearch();
		String actualMsg = SHP.locationspan().getText();
	    System.out.println("Error Message: " + actualMsg);
	    Assert.assertTrue(actualMsg.equalsIgnoreCase("Please Select a Location"), "Error message mismatch");
	
}
	@Test(priority = 5)
	void TC_12_testWithoutRoomType() throws Exception {
		SHP.SelectSearchIcon();
		SHP.selectLocation("Sydney");
		Thread.sleep(500);
		SHP.selectHotel("Hotel Creek");
		Thread.sleep(500);
		
		SHP.selectNumberOfRoom("2 - Two");
		Thread.sleep(500);
		SHP.selectInDate("20/09/2025"); //"dd/mm/yyyy"
		Thread.sleep(500);
		SHP.selectOutDate("19/09/2025");//"dd/mm/yyyy" //given befor in-date
		Thread.sleep(500);
		SHP.selectNumberOfAdult("2 - Two");
		Thread.sleep(500);
		SHP.selectNumberOfChild("2 - Two");
		Thread.sleep(500);
		SHP.SelectSearch();
		String actualTitle = BaseClass.driver.getTitle();
		System.out.println("Page Title after login: " + actualTitle);
		Assert.assertTrue(actualTitle.equalsIgnoreCase("Adactin.com - Search Hotel"), "message mismatch");
}
	
	
}