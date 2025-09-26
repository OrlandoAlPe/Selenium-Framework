package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginService {

	@FindBy(id = "user-name")
	WebElement usernameTextField;

	@FindBy(id = "password")
	WebElement passwordTextField;

	@FindBy(id = "login-button")
	WebElement loginButton;

	private WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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

	public LoginService(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private void signInWithAccount(String userType) {
		wait.until(ExpectedConditions.visibilityOf(usernameTextField));
		usernameTextField.sendKeys(userType);
		passwordTextField.sendKeys(UserType.STANDARD.password);
		loginButton.click();
	}

	public void standardAccountLogin() {
		signInWithAccount(UserType.STANDARD.username);
	}
	
	public void lockedOutAccountLogin() {
		signInWithAccount(UserType.LOCKED_OUT.username);
	}

}
