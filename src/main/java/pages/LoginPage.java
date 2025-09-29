package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class LoginPage extends BasePage{

	@FindBy(id = "user-name")
	WebElement usernameTextField;

	@FindBy(id = "password")
	WebElement passwordTextField;

	@FindBy(id = "login-button")
	WebElement loginButton;

	public enum UserType {
		STANDARD("standard_user", "secret_sauce"), LOCKED_OUT("locked_out_user", "secret_sauce");

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
	
	private void signInWithAccount(String userType) {
		wait.until(ExpectedConditions.visibilityOf(usernameTextField));
		usernameTextField.sendKeys(userType);
		passwordTextField.sendKeys(UserType.STANDARD.password);
		super.clickWebElement(loginButton);
		System.out.println("Successfully Signed In with the " + userType + " account");
	}

	public void standardAccountLogin() {
		this.signInWithAccount(UserType.STANDARD.username);
	}

	public void lockedOutAccountLogin() {
		this.signInWithAccount(UserType.LOCKED_OUT.username);
	}

}
