package tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.InventoryPage;
import pages.LoginPage;

public class SD3_Add_tems_To_Cart extends BaseTest {
	@Test
	public void test_SD3_AddI_tems_To_Cart() {
		
		HomePage homePage = new HomePage(driver);
		LoginPage login = new LoginPage(driver);
		InventoryPage inventoryPage = new InventoryPage(driver);
		
		Reporter.log("1. Complete a successful login");
		homePage.goHomePage();
		login.standardAccountLogin();
		
		Reporter.log("2. Locate 'Sauce Labs backpack' item");
		Reporter.log("3. Click 'Add to Cart' button");
		inventoryPage.clickAddToCartSauceLabsBackpackButton();
		
		Reporter.log("4. Verify button changed to 'Remove'");
		inventoryPage.validateRemoveSauceLabsBackpackButtonDisplayed();
		
		Reporter.log("5. Verify Shoppin cart badge changed to '1'");
		inventoryPage.validateCartBadgeNumberisCorrect();
	}
}
