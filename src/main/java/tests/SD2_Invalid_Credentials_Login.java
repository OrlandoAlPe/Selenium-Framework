package tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.HomePage;

public class SD2_Invalid_Credentials_Login extends BaseTest {

	@Test
	public void test_SD2_Invalid_Credentials_Login() {

		HomePage homePage = new HomePage(driver);
		LoginPage login = new LoginPage(driver);

		Reporter.log("1. Navigate to: https://www.saucedemo.com");
		homePage.goHomePage();

		Reporter.log("2. Write username: 'invalid_user'");
		Reporter.log("3. Write password: 'wrong_password'");
		Reporter.log("4. click 'Login' button");
		login.invalidAccountLogin();

		Reporter.log(
				"5. Verify 'Epic sadface: Username and password do not match any user in this service' error message");
		login.validateInvalidLoginErrorMessageDisplayed();

		Reporter.log("6. Verify page stays in LoginPage");
		homePage.validatePageNavigatedToHomePage();
	}

}
