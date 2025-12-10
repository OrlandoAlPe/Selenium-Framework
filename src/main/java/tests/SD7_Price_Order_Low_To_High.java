package tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.InventoryPage;
import pages.LoginPage;

public class SD7_Price_Order_Low_To_High extends BaseTest {
	@Test
	public void test_SD7_Price_Order_Low_To_High() {
		HomePage homePage = new HomePage(driver);
		LoginPage login = new LoginPage(driver);
		InventoryPage inventoryPage = new InventoryPage(driver);
		
		Reporter.log("1. Complete a successful login");
		homePage.goHomePage();
		login.standardAccountLogin();
		
		Reporter.log("2. Locate sort dropdown");
		Reporter.log("3. Sort by price (Low to high)");
		inventoryPage.filterByPriceLowToHigh();
		
		Reporter.log("4. Obtain all shown prices");
		Reporter.log("5. Verify prices are ordered low to high.");
		inventoryPage.validatePricesAreSortedLowToHigh();
		
	}
}
