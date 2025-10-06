package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import base.BasePage;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void goHomePage() {
		driver.get("https://www.saucedemo.com/");
		Reporter.log("Navigated to https://www.saucedemo.com/");
	}

	public void validatePageNavigatedToHomePage() {
		super.validatePageLoaded("https://www.saucedemo.com/");
	}
}
