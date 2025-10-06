package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import base.BasePage;

public class CheckoutOverviewPage extends BasePage {

	@FindBy(xpath = "//*[@class='summary_subtotal_label']")
	WebElement subtotalLabel;

	@FindBy(xpath = "//*[@class='summary_tax_label']")
	WebElement taxLabel;

	@FindBy(xpath = "//*[@class='summary_total_label']")
	WebElement totalLabel;

	@FindBy(xpath = "//*[@class='cart_list']")
	WebElement cartItemsContainer;

	@FindBy(id = "finish")
	WebElement finishButon;
	
	public CheckoutOverviewPage(WebDriver driver) {
		super(driver);
	}

	public void validateCheckoutOverviewPageLoaded() {
		super.validatePageLoaded("/checkout-step-two.html");
	}

	public void verifyItemTotalTaxAndTotalIsDisplayed() {
		super.waitForVisibility(cartItemsContainer);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(cartItemsContainer.isDisplayed(), "Cart Items are not displayed.");
		softAssert.assertTrue(subtotalLabel.isDisplayed(), "SubTotal label is not displayed.");
		softAssert.assertTrue(taxLabel.isDisplayed(), "Tax label is not displayed.");
		softAssert.assertTrue(totalLabel.isDisplayed(), "Total label is not displayed.");
		softAssert.assertAll();
		Reporter.log("Expected elements present.");
	}

	public void clickFinishButton() {
		super.clickWebElement(finishButon);
	}
	
}
