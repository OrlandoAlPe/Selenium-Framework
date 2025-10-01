package pages;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void goHomePage() {
		driver.get("https://www.saucedemo.com/");
		Reporter.log("Navigated to https://www.saucedemo.com/");
	}

	public void validatePageNavigatedToHomePage() {
		assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
		Reporter.log("Current page:  'https://www.saucedemo.com/'");
	}
}
