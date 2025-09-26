package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.NavigationPage;
import pages.LoginService;

public class SD1_LogIn_Functionality extends BaseTest {

	@Test
	public void test_SD1_LogIn_Functionality() {
		NavigationPage navigationPage = new NavigationPage(driver);
		LoginService login = new LoginService(driver);
		navigationPage.goHomePage();
		login.standardAccountLogin();
	}

}
