package adactingroup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class BookHotelPage extends BasePage{

	public BookHotelPage(WebDriver driver) {
		super(driver);
		
		
		}
	@FindBy(xpath="//input[@id='radiobutton_0']")
    WebElement txt_radiobutton1;
	
	@FindBy(xpath="//input[@id='continue']")
    WebElement txt_continuebutton;
	
	
	@FindBy(xpath="//td[normalize-space()='Book A Hotel']")
    WebElement txt_booktitle;
	
	@FindBy(xpath="//label[@id='radiobutton_span']")
    WebElement txt_radiospan;
	
	@FindBy(xpath="//input[@id='first_name']")
    WebElement txt_firstname;
	
	
	@FindBy(xpath="//input[@id='last_name']")
    WebElement txt_lastname;
	
	@FindBy(xpath="//textarea[@id='address']")
    WebElement txt_address;
	
	@FindBy(xpath="//input[@id='cc_num']")
    WebElement txt_cardnum;
	
	@FindBy(xpath="//select[@id='cc_type']")
    WebElement txt_cardtype;
	
	@FindBy(xpath="//select[@id='cc_exp_month']")
    WebElement txt_expmonth;
	
	@FindBy(xpath="//select[@id='cc_exp_year']")
    WebElement txt_expyear;
	
	
	@FindBy(xpath="//input[@id='cc_cvv']")
    WebElement txt_cvvnum;
	
	@FindBy(xpath="//input[@id='book_now']")
    WebElement txt_booknow;
	
	
	@FindBy(xpath="//input[@id='cancel']")
    WebElement txt_cancel;
	
	
	@FindBy(xpath="//td[@class='login_title']")
    WebElement txt_titlecon;
	

	@FindBy(xpath="//label[@id='first_name_span']")
    WebElement txt_firstnamespan;
	
	@FindBy(xpath="//label[@id='last_name_span']")
    WebElement txt_lastnamespan;
	
	
	@FindBy(xpath="//label[@id='address_span']")
    WebElement txt_addressspan;
	

	@FindBy(xpath="//label[@id='cc_num_span']")
    WebElement txt_cardspan;
	
	
	@FindBy(xpath="//a[normalize-space()='Booked Itinerary']")
    WebElement txt_Itinerary;
	
	@FindBy(xpath="//input[@id='check_all']")
    WebElement txt_selectall;
	
	@FindBy(xpath="//input[@name='cancelall']")
    WebElement txt_selectdelete;
	public void clickRadioButton(){
		txt_radiobutton1.click();
	}
	
	public void clickContinueButton(){
		txt_continuebutton.click();
	}
	
	public WebElement booktitle() {
		return txt_booktitle;
		
	}
	public WebElement radiospan() {
		return txt_radiospan;
		
	}
	public void firstname(String input){
		txt_firstname.sendKeys(input);
	}
	public void lastname(String input){
		txt_lastname.sendKeys(input);
	}
	
	public void address(String input){
		txt_address.sendKeys(input);
	}
	public void cardnum(String input){
		txt_cardnum.sendKeys(input);
	}
	public void cardtype(String input){
		Select select = new Select(txt_cardtype);
        select.selectByVisibleText(input);
	}
	public void expmonth(String input){
		Select select = new Select(txt_expmonth);
        select.selectByVisibleText(input);
	}
	public void expyear(String input){
		Select select = new Select(txt_expyear);
        select.selectByVisibleText(input);
	}
	public void cvvnum(String input){
		txt_cvvnum.sendKeys(input);
	}
	
	public void booknow(){
		txt_booknow.click();
	}
	public void cancel(){
		txt_cancel.click();
	}
	public WebElement titleconfirm() {
		return txt_titlecon;
		
	}
	public WebElement firstnamespan() {
		return txt_firstnamespan;
	}
	public WebElement lastnamespan() {
		return txt_lastnamespan;
	}
	public WebElement addressspan() {
		return txt_addressspan;
	}
	public WebElement cardpan() {
		return txt_cardspan;
	}
	public void clearlastname(){
		txt_lastname.clear();
	}
	public void clearaddr() {
		txt_address.clear();
	}
	public void clearcardnum() {
		txt_cardnum.clear();
	}
	
	public void itinerary() {
		txt_Itinerary.click();
	}
	
	public void selectall() {
		txt_selectall.click();
	}
	public void selectdelete() {
		txt_selectdelete.click();
	}
}
