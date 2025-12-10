package tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.HomePage;
import pages.InventoryPage;
import pages.LoginPage;

public class SD9_Continue_Purchase_From_Cart extends BaseTest {

	@Test
	public void test_SD9_Continue_Purchase_From_Cart() {

		HomePage homePage = new HomePage(driver);
		LoginPage login = new LoginPage(driver);
		InventoryPage inventoryPage = new InventoryPage(driver);
		CartPage cartPage = new CartPage(driver);
		
		Reporter.log("1. Complete a successful login");
		homePage.goHomePage();
		login.standardAccountLogin();
		
		Reporter.log("2. Add any product to the cart");
		inventoryPage.clickAddToCartSauceLabsBackpackButton();
		
		Reporter.log("3. Click cart button");
		inventoryPage.clickShoppingCartButton();
		
		Reporter.log("4. Click continue shopping button");
		cartPage.clickContinueShoppingButton();
		
		Reporter.log("5. Verify you are in 'inventory' page");
		inventoryPage.verifyInventoryPageTitle();
		
	}

}
