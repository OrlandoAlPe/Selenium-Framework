package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.NavigationPage;
import pages.InventoryPage;
import pages.LoginPage;

public class SD1_LogIn_Functionality extends BaseTest {

	@Test
	public void test_SD1_LogIn_Functionality() {
		
		NavigationPage navigationPage = new NavigationPage(driver);
		LoginPage login = new LoginPage(driver);
		InventoryPage inventoryPage = new InventoryPage(driver);
		
		navigationPage.goHomePage();
		login.standardAccountLogin();
		inventoryPage.verifyInventoryPageLoaded();
		inventoryPage.filterByPriceLowToHigh();
		inventoryPage.clickShoppingCartButton();
	}
}
