package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import base.BasePage;

public class CheckoutPage extends BasePage{

	
	@FindBy(id = "first-name")
	WebElement firstNameInput;
	
	@FindBy(id = "last-name")
	WebElement lastNameInput;
	
	@FindBy(id = "postal-code")
	WebElement zipcodeInput;
	
	@FindBy(id = "continue")
	WebElement continueButton;
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	public void fillCheckoutData() {
		super.waitForPageToLoad();
		super.waitForVisibility(firstNameInput);
		firstNameInput.sendKeys("Jhon");
		lastNameInput.sendKeys("Doe");
		zipcodeInput.sendKeys("12345");
		
		Reporter.log("Checkout information written.");
	}
	
	public void clickContinueButton() {
		super.clickWebElement(continueButton);
	}
	
}
