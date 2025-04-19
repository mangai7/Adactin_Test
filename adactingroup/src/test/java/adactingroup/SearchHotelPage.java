package adactingroup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SearchHotelPage extends BasePage{
	public SearchHotelPage(WebDriver driver) {
		super(driver);
		
		
		}
	
	@FindBy(id = "location")
    WebElement dropdown_location;
	
	@FindBy(xpath="//select[@id='hotels']")
    WebElement dropdown_hotel;
	
	
	@FindBy(xpath="//select[@id='room_type']")
    WebElement dropdown_roomtype;
	
	@FindBy(xpath="//select[@id='room_nos']")
    WebElement dropdown_numberofroom;
	
	@FindBy(xpath="//input[@id='datepick_in']")
    WebElement dropdown_indate;
	
	@FindBy(xpath="//input[@id='datepick_out']")
    WebElement dropdown_outdate;
	
	@FindBy(xpath="//select[@id='adult_room']")
    WebElement dropdown_adult;
	
	@FindBy(xpath="//select[@id='child_room']")
    WebElement dropdown_child;
	
	@FindBy(xpath="//a[normalize-space()='Search Hotel']")
    WebElement dropdown_searchicon;
	
	
	
	@FindBy(xpath="//input[@id='Submit']")
    WebElement dropdown_searchbtutton;
	
	@FindBy(xpath="//span[@id='location_span']")
    WebElement dropdown_locationspan;
	
	
	@FindBy(xpath="//span[@id='checkin_span']")
    WebElement dropdown_checkinspan;
	
	@FindBy(xpath="//span[@id='checkout_span']")
    WebElement dropdown_checkoutspan;

    public void selectLocation(String input) {
        Select select = new Select(dropdown_location);
        select.selectByVisibleText(input);
    	//dropdown_location.sendKeys(locationName);
    }
    public void selectHotel(String input) {
        Select select = new Select(dropdown_hotel);
        select.selectByVisibleText(input);
    	
    }
    public void selectRoomType(String input) {
        Select select = new Select(dropdown_roomtype);
        select.selectByVisibleText(input);
    }
    public void selectNumberOfRoom(String input) {
        Select select = new Select(dropdown_numberofroom);
        select.selectByVisibleText(input);
    }
    public void selectInDate(String input) throws Exception {
        dropdown_indate.clear();
        Thread.sleep(500);
        dropdown_indate.sendKeys(input);
    }
    public void selectOutDate(String input) throws Exception {
        dropdown_outdate.clear();
        Thread.sleep(500);
        dropdown_outdate.sendKeys(input);
    }
    public void selectNumberOfAdult(String input) {
        Select select = new Select(dropdown_adult);
        select.selectByVisibleText(input);
    }
    public void selectNumberOfChild(String input) {
        Select select = new Select(dropdown_child);
        select.selectByVisibleText(input);
    }
    
    public void SelectSearch() {
    	dropdown_searchbtutton.click();
    }
    public WebElement checkinspan() {
    	return dropdown_checkinspan;
    }
    public WebElement checkoutspan() {
    	return dropdown_checkoutspan;
    }
    public void indateclear() {
    	dropdown_indate.clear();
    }
    public void outdateclear() {
    	dropdown_outdate.clear();
    }
    public void SelectSearchIcon() {
    	dropdown_searchicon.click();
    }
    public WebElement locationspan() {
    	return dropdown_locationspan;
    }
}

