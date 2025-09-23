package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class SD1_LogIn_Functionality extends BaseTest {

	@Test
	public void test_SD1_LogIn_Functionality() {
		LoginPage loginPage = new LoginPage();
		loginPage.goThisPage();
	}

}
