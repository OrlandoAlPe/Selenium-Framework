package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class ConfirmationPage extends BasePage {

	public ConfirmationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@class='complete-header']")
	WebElement completedOrderMeesage;

	@FindBy(xpath = "//*[@class='pony_express']")
	WebElement confirmationIcon;
	
	public void validateCheckoutCompletePageLoaded() {
		super.validatePageLoaded("/checkout-complete.html");
	}
	
	public void validateConfirmationMessageDisplayed() {
		super.validateElementIsDisplayed(completedOrderMeesage);
	}
	
	public void validateConfirmationIconDisplayed() {
		super.validateElementIsDisplayed(confirmationIcon);
	}
}
