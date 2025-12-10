package pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import base.BasePage;

public class LoginPage extends BasePage {

	@FindBy(id = "user-name")
	WebElement usernameTextField;

	@FindBy(id = "password")
	WebElement passwordTextField;

	@FindBy(id = "login-button")
	WebElement loginButton;

	@FindBy(xpath = "//h3[@data-test='error']")
	WebElement signInErrorMessage;

	private String loginInvelidCredentialsErrorMessage = "Username and password do not match any user in this service";

	public enum UserType {
		STANDARD("standard_user", "secret_sauce"), LOCKED_OUT("locked_out_user", "secret_sauce"),
		INVALID("invald_user", "wrong_password");

		private final String username;
		private final String password;

		UserType(String username, String password) {
			this.username = username;
			this.password = password;
		}

		public String getUsername() {
			return username;
		}

		public String getPassword() {
			return password;
		}
	}

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	private void signInWithAccount(UserType userType) {
		super.waitForPageToLoad();
		wait.until(ExpectedConditions.visibilityOf(usernameTextField));
		usernameTextField.sendKeys(userType.username);
		passwordTextField.sendKeys(userType.password);
		super.clickWebElement(loginButton);
		Reporter.log("Successfully Signed In with the " + userType + " account");
	}

	public void standardAccountLogin() {
		this.signInWithAccount(UserType.STANDARD);
	}

	public void invalidAccountLogin() {
		this.signInWithAccount(UserType.INVALID);
	}

	public void validateInvalidLoginErrorMessageDisplayed() {
		super.validateElementIsDisplayed(signInErrorMessage);
		assertTrue(signInErrorMessage.getText().contains(loginInvelidCredentialsErrorMessage),
				"Error message not displayed correctly");
		Reporter.log("Error message displayed correctly");
	}

}
