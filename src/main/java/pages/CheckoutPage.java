package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class CheckoutPage extends BasePage {

	@FindBy(id = "first-name")
	WebElement firstNameInput;

	@FindBy(id = "last-name")
	WebElement lastNameInput;

	@FindBy(id = "postal-code")
	WebElement zipcodeInput;

	@FindBy(id = "continue")
	WebElement continueButton;

	@FindBy(xpath = "//*[@data-test='error']")
	WebElement errorMessage;

	@FindBy(id = "cancel")
	WebElement cancelButton;
	
	private final String missingZIPCodeErrorMessage = "Error: Postal Code is required";
	private final String missingLastNameErrorMessage = "Error: Last Name is required";
	private final String missingFirstNameErrorMessage = "Error: First Name is required";

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	public void fillAllCheckoutData() {
		this.fillFirstNameTextField();
		this.fillLastNameTextField();
		this.fillZIPCodeTextField();
	}
	
	public void fillFirstNameTextField() {
		super.fillTextField(firstNameInput, "Jhon");
	}
	public void fillLastNameTextField() {
		super.fillTextField(lastNameInput, "Doe");
	}

	public void fillZIPCodeTextField() {
		super.fillTextField(zipcodeInput, "12345");
	}

	public void clickContinueButton() {
		super.clickWebElement(continueButton);
	}

	public void validateMissingZIPCodeErrorMessage() {
		super.validateTextMessage(missingZIPCodeErrorMessage, errorMessage);
	}

	public void validateMissingLastNameErrorMessage() {
		super.validateTextMessage(missingLastNameErrorMessage, errorMessage);
	}

	public void validateMissingFirstNameErrorMessage() {
		super.validateTextMessage(missingFirstNameErrorMessage, errorMessage);
	}

	public void clickCancelButton() {
		super.clickWebElement(cancelButton);
	}
	
}
