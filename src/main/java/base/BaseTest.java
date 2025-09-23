package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	
	
	WebDriver driver;
	
	@BeforeTest
	public void driverSetUp() {
		WebDriver driver = new ChromeDriver();	
		driver.manage().window().maximize();
	}
	
	@AfterTest
	private void testCompleted() {
		driver.quit();
	}
	
	
}
