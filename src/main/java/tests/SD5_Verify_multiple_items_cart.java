package tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.HomePage;
import pages.InventoryPage;
import pages.LoginPage;

public class SD5_Verify_multiple_items_cart extends BaseTest {
	@Test
	public void test_Verify_multiple_items_cart() {

		HomePage homePage = new HomePage(driver);
		LoginPage login = new LoginPage(driver);
		InventoryPage inventoryPage = new InventoryPage(driver);
		CartPage cartPage = new CartPage(driver);

		Reporter.log("1. Complete a successful login");
		homePage.goHomePage();
		login.standardAccountLogin();

		Reporter.log("2. Add saucelabs backpack to cart");
		inventoryPage.clickAddToCartSauceLabsBackpackButton();

		Reporter.log("3. Add saucelabs bike light to cart");
		inventoryPage.clickAddToCartSauceLabsBickeLightButton();

		Reporter.log("4. Click cart button");
		inventoryPage.clickShoppingCartButton();

		Reporter.log("5. verify url changes to '/cart.html'");
		cartPage.validateCartPageLoaded();

		Reporter.log("6. verify there are 2 items in the cart page");
		cartPage.validateThereAre2ItemsInCartList();

		// TODO
		Reporter.log("7. verify both product names and prices are in the cart page");

	}

}
