package testbase;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import adactingroup.BookHotelPage;
import adactingroup.ExcelReader;
import adactingroup.LoginPage;
import adactingroup.SearchHotelPage;

public class BookHotelTest extends BaseClass{

	public WebDriver driver;
	LoginPage LP;
	SearchHotelPage SHP;
	BookHotelPage BHP;
	
	@BeforeClass
    public void setUpTest() throws Exception {
        LP = new LoginPage(BaseClass.driver);
        SHP = new SearchHotelPage(BaseClass.driver);
        BHP = new BookHotelPage(BaseClass.driver);
        //login
        String username = ExcelReader.getCellValue("LoginData", 1, 0); // 2nd row, 1st column
	    String password = ExcelReader.getCellValue("LoginData", 1, 1); // 2nd row, 2nd column
	    LP.username(username);
		LP.password(password);
		Thread.sleep(500);
		LP.login();
		
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
		
        
    }
	
	// without clicking radio button click continue button 
	
	@Test(priority = 1)
	void TC_13_testWithOutClickingRadioButton() {
		BHP.clickContinueButton();
		String actualMsg = BHP.radiospan().getText();
		System.out.println("Error Message: " + actualMsg);
		Assert.assertTrue(actualMsg.equalsIgnoreCase("Please Select a Hotel"), "message mismatch");
		
			
		}
	
	@Test(priority = 2)
	void TC_14_testGoToBookingPage() {
		BHP.clickRadioButton();
		BHP.clickContinueButton();
		String actualMsg = BHP.booktitle().getText();
	    System.out.println("Message: " + actualMsg);
	    Assert.assertTrue(actualMsg.equalsIgnoreCase("Book A Hotel"), "message mismatch");
	

	}
	@Test(priority=3)
	void TC_15_testWithoutFirstname() throws Exception {
		BHP.lastname("k");
		BHP.address("no.24,Vela street,Chennai.");
		BHP.cardnum("1234567812345678");
		BHP.cardtype("VISA");
		BHP.expmonth("June");
		BHP.expyear("2026");
		BHP.cvvnum("223");
		Thread.sleep(500);
		BHP.booknow();
		Thread.sleep(4000);

		String actualMsg = BHP.firstnamespan().getText();
		System.out.println("Error Message: " + actualMsg);
		Assert.assertTrue(actualMsg.equalsIgnoreCase("Please Enter your First Name"), "message mismatch");
		
	}
	@Test(priority=4)
	void TC_16_testWithoutLastname() throws Exception {
		BHP.firstname("Sree");
		BHP.clearlastname();
		BHP.address("no.24,Vela street,Chennai.");
		BHP.cardnum("1234567812345678");
		BHP.cardtype("VISA");
		BHP.expmonth("June");
		BHP.expyear("2026");
		BHP.cvvnum("223");
		Thread.sleep(500);
		BHP.booknow();
		Thread.sleep(4000);

		String actualMsg = BHP.lastnamespan().getText();
		System.out.println("Error Message: " + actualMsg);
		Assert.assertTrue(actualMsg.equalsIgnoreCase("Please Enter you Last Name"), "message mismatch");
		
	}
	
	@Test(priority=5)
	void TC_17_testWithoutBillingAddress() throws Exception {
		BHP.firstname("Sree");
		BHP.lastname("k");
		BHP.clearaddr();
		BHP.cardnum("1234567812345678");
		BHP.cardtype("VISA");
		BHP.expmonth("June");
		BHP.expyear("2026");
		BHP.cvvnum("223");
		BHP.booknow();
		Thread.sleep(4000);
		String actualMsg = BHP.addressspan().getText();
		System.out.println("Error Message: " + actualMsg);
		Assert.assertTrue(actualMsg.equalsIgnoreCase("Please Enter your Address"), "message mismatch");
		
	}
	@Test(priority = 6)
	void TC_18_testWithoutCardNumber() throws Exception{
		BHP.firstname("Sree");
		BHP.lastname("k");
		BHP.address("no.24,Vela street,Chennai.");
		BHP.clearcardnum();
		BHP.cardtype("VISA");
		BHP.expmonth("June");
		BHP.expyear("2026");
		BHP.cvvnum("223");
		Thread.sleep(500);
		BHP.booknow();
		Thread.sleep(4000);

		String actualMsg = BHP.cardpan().getText();
	    System.out.println("Error Message: " + actualMsg);
	    Assert.assertTrue(actualMsg.equalsIgnoreCase("Please Enter your 16 Digit Credit Card Number"), "message mismatch");
	    	
		
	}

	
	@Test(priority = 7)
	void TC_19_testBookWithValidData() throws Exception{
		BHP.firstname("Sree");
		BHP.lastname("k");
		BHP.address("no.24,Vela street,Chennai.");
		BHP.cardnum("1234567812345678");
		BHP.cardtype("VISA");
		BHP.expmonth("June");
		BHP.expyear("2026");
		BHP.cvvnum("223");
		Thread.sleep(500);
		BHP.booknow();
		Thread.sleep(5000);

		String actualMsg = BHP.titleconfirm().getText();
	    System.out.println("Message: " + actualMsg);
	    Assert.assertTrue(actualMsg.equalsIgnoreCase("Booking Confirmation"), "message mismatch");
	    
	
	}
	
	@Test(priority = 8)
	void TC_20_testItinerary() throws Exception{
		BHP.itinerary();
		BHP.selectall();
		BHP.selectdelete();
		
		Alert alert = driver.switchTo().alert();

		// Get alert text (optional)
		String alertText = alert.getText();
		System.out.println("Alert says: " + alertText);

		// Accept the alert (click OK)
		alert.accept();
		Thread.sleep(4000);
		
		
	}
	
	
	
	
}
