package testbase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
public static WebDriver driver;
	
	
	@BeforeClass
	public void setup() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://adactinhotelapp.com");
		
		
		
	}
	
	@AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
	
}
	
	

}
