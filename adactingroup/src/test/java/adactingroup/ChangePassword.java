package adactingroup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePassword extends BasePage {
	public ChangePassword(WebDriver driver) {
		super(driver);
		
		
		}
	
	@FindBy(xpath="//a[normalize-space()='Change Password']")
    WebElement txt_changepassword;
	
	
	@FindBy(xpath="//input[@id='current_pass']")
    WebElement txt_currentpass;
	
	
	
	@FindBy(xpath="//input[@id='new_password']")
    WebElement txt_newpassword;
	
	
	@FindBy(xpath="//input[@id='re_password']")
    WebElement txt_confirmpass;
	
	
	@FindBy(xpath="//input[@id='Submit']")
    WebElement txt_submit;
	
	
	@FindBy(xpath="//span[normalize-space()='Your Password is successfully updated!!!']")
    WebElement txt_sucmsg;
	
	public void changepassword() {
		txt_changepassword.click();
		
	}
	public void currentpassword(String input) {
		txt_currentpass.sendKeys(input);
	}
	public void newpassword(String input) {
		txt_newpassword.sendKeys(input);
	}
	public void confirmpass(String input) {
		txt_confirmpass.sendKeys(input);
	}
	public void submit() {
		txt_submit.click();
		
	}
	public WebElement successmsg() {
		return txt_sucmsg;
	}
}
