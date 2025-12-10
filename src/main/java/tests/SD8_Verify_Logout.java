package tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.InventoryPage;
import pages.LoginPage;

public class SD8_Verify_Logout extends BaseTest {
	@Test
	public void test_SD8_Verify_Logout() {
		HomePage homePage = new HomePage(driver);
		LoginPage login = new LoginPage(driver);
		InventoryPage inventoryPage = new InventoryPage(driver);
		
		Reporter.log("1. Complete a successful login");
		homePage.goHomePage();
		login.standardAccountLogin();
		
		Reporter.log("2. Click Hamburguer menu");
		homePage.clickHamburguerMenuButton();
		
		Reporter.log("3. Click logout");
		homePage.clickLogoutButton();
		
		Reporter.log("4. Verify we are back in Login Page");
		Reporter.log("5. Verify URL is the main Page.");
		homePage.validatePageNavigatedToHomePage();
		
		Reporter.log("6. Try to navigate to '/inventory.html'.");
		inventoryPage.navigateInventoryPage();
		
		Reporter.log("7. Verify you are in login Page.");
		homePage.validatePageNavigatedToHomePage();
	}

}
