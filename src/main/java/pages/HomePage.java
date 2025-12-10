package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import base.BasePage;

public class HomePage extends BasePage {

	@FindBy(id = "react-burger-menu-btn")
	WebElement hamburguerMenu;

	@FindBy(id = "logout_sidebar_link")
	WebElement logoutButton;

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

	public void clickHamburguerMenuButton() {
		super.waitForVisibility(hamburguerMenu);
		super.clickWebElement(hamburguerMenu);
	}

	public void clickLogoutButton() {
		super.waitForVisibility(logoutButton);
		super.clickWebElement(logoutButton);
	}

}
