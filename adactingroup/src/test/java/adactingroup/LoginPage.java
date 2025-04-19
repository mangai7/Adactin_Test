package adactingroup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class LoginPage extends BasePage{
	public LoginPage(WebDriver driver) {
		super(driver);
		
		
		}
	
	
	@FindBy(xpath= "//input[@id='username']")
	WebElement txt_username;
	
	@FindBy(xpath= "//input[@id='password']")
	WebElement txt_password;
	
	@FindBy(xpath= "//input[@id='login']")
	WebElement txt_login;
	
	
	
	public void username(String input) {
		txt_username.sendKeys(input);
	}
	
	public void password(String input) {
		txt_password.sendKeys(input);
	}
	public void login() {
		txt_login.click();
		
	}
	
	public boolean isLoginButtonVisible() {
	    return txt_login.isDisplayed();
	}
	
	public WebElement getLoginbutton() {
	    return txt_login;
	}
	
}
