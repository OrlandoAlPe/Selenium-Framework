package tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.InventoryPage;
import pages.LoginPage;

public class SD1_Successful_Login extends BaseTest {

	@Test
	public void test_SD1_Successful_Login() {

		HomePage navigationPage = new HomePage(driver);
		LoginPage login = new LoginPage(driver);
		InventoryPage inventoryPage = new InventoryPage(driver);

		Reporter.log("1. Navigate to: https://www.saucedemo.com");
		navigationPage.goHomePage();
		
		Reporter.log("2. Write username: 'standard_user'");
		Reporter.log("3. Write password: 'secret_sauce'");
		Reporter.log("4. click 'Login' button");
		login.standardAccountLogin();
		
		Reporter.log("5. Verify Url changed to '/inventory.html'");
		inventoryPage.validateInventoryPageLoaded();
		
		Reporter.log("6. Verify page title is 'Products'");
		inventoryPage.verifyInventoryPageTitle();
	}
}
