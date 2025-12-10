package tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutOverviewPage;
import pages.CheckoutPage;
import pages.ConfirmationPage;
import pages.HomePage;
import pages.InventoryPage;
import pages.LoginPage;

public class SD6_Complete_Checkout_Process extends BaseTest {
	@Test
	public void test_TD6_Complete_Checkout_Process() {

		HomePage homePage = new HomePage(driver);
		LoginPage login = new LoginPage(driver);
		InventoryPage inventoryPage = new InventoryPage(driver);
		CartPage cartPage = new CartPage(driver);
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);

		Reporter.log("1. Complete a successful login");
		homePage.goHomePage();
		login.standardAccountLogin();

		Reporter.log("2. Add saucelabs backpack to cart");
		inventoryPage.clickAddToCartSauceLabsBackpackButton();

		Reporter.log("3. Click cart button");
		inventoryPage.clickShoppingCartButton();

		Reporter.log("4. Click checkout button");
		cartPage.clickCheckoutButton();

		Reporter.log("5. Write the following data :" + "First name: Joe" + "Last name: Doe" + "12345 zip code");
		checkoutPage.fillAllCheckoutData();

		Reporter.log("6. Click continue button");
		checkoutPage.clickContinueButton();

		Reporter.log("7.Validate we are in checkout overviewPage");
		checkoutOverviewPage.validateCheckoutOverviewPageLoaded();

		Reporter.log("8. Verify price, tax and total is displayed");
		checkoutOverviewPage.verifyItemTotalTaxAndTotalIsDisplayed();

		Reporter.log("9. Click Finish button");
		checkoutOverviewPage.clickFinishButton();

		Reporter.log("10. Validate 'Thank you for your order'! message.");
		confirmationPage.validateCheckoutCompletePageLoaded();
		confirmationPage.validateConfirmationMessageDisplayed();

		Reporter.log("11. Validate confirmation icon displayed.");
		confirmationPage.validateConfirmationIconDisplayed();
	}
}
