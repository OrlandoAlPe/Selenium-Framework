package tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.InventoryPage;
import pages.LoginPage;

public class SD10_Verify_Mandatory_Checkout_Fields extends BaseTest {
	@Test
	public void test_SD10_Verify_Mandatory_Checkout_Fields() {

		HomePage homePage = new HomePage(driver);
		LoginPage login = new LoginPage(driver);
		InventoryPage inventoryPage = new InventoryPage(driver);
		CartPage cartPage = new CartPage(driver);
		CheckoutPage checkoutPage = new CheckoutPage(driver);

		Reporter.log("1. Complete a successful login");
		homePage.goHomePage();
		login.standardAccountLogin();

		Reporter.log("2. Add any product to the cart and proceed to checkout");
		inventoryPage.clickAddToCartSauceLabsBackpackButton();
		inventoryPage.clickShoppingCartButton();
		cartPage.clickCheckoutButton();

		Reporter.log("3. Leave First Name field empty");
		Reporter.log("4. Fill Last name and ZIP code");
		checkoutPage.fillLastNameTextField();
		checkoutPage.fillZIPCodeTextField();

		Reporter.log("5. Click continue");
		checkoutPage.clickContinueButton();

		Reporter.log("6. Verify error message");
		checkoutPage.validateMissingFirstNameErrorMessage();
		checkoutPage.clickCancelButton();
		cartPage.clickCheckoutButton();
		
		Reporter.log("7. Repeat with zip code and Last name");
		Reporter.log("Checking missing zip code error.");
		checkoutPage.fillFirstNameTextField();
		checkoutPage.fillLastNameTextField();
		checkoutPage.clickContinueButton();
		checkoutPage.validateMissingZIPCodeErrorMessage();
		checkoutPage.clickCancelButton();
		cartPage.clickCheckoutButton();
		
		Reporter.log("Checking missing Last Name error.");
		checkoutPage.fillFirstNameTextField();
		checkoutPage.fillZIPCodeTextField();
		checkoutPage.clickContinueButton();
		checkoutPage.validateMissingLastNameErrorMessage();

	}
}
