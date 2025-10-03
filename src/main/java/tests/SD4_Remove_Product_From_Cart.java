package tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.InventoryPage;
import pages.LoginPage;

public class SD4_Remove_Product_From_Cart extends BaseTest {

	@Test
	public void test_SD4_Remove_Product_From_Cart() {

		HomePage homePage = new HomePage(driver);
		LoginPage login = new LoginPage(driver);
		InventoryPage inventoryPage = new InventoryPage(driver);
		
		Reporter.log("1. Complete a successful login");
		homePage.goHomePage();
		login.standardAccountLogin();
		
		Reporter.log("2. Add saucelabs backpack to cart");
		inventoryPage.clickAddToCartSauceLabsBackpackButton();
		
		Reporter.log("3. Click 'Remove' button");
		inventoryPage.clickRemoveSauceLabsBackpackButton();
		
		Reporter.log("4. Verify button changed to 'Add to cart'");
		inventoryPage.validateAddToCartSauceLabsBackpackButtonDisplayed();
		
		Reporter.log("5. Verify Shoppin cart badge changed to '0'");
		inventoryPage.validateCartBadgeNumberisEmpty();
		

	}

}
