package adactingroup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage {
	public LogoutPage(WebDriver driver) {
		super(driver);
		
		
		}
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
    WebElement txt_changepassword;
	
	
	@FindBy(xpath="//td[@class='reg_success']")
    WebElement txt_msg;
	
	public void logout() {
		txt_changepassword.click();
	}
	public WebElement msg() {
		return txt_msg;
	}

}
