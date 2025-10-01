package pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import base.BasePage;

public class InventoryPage extends BasePage {

	@FindBy(xpath = "//select[@class='product_sort_container']")
	WebElement filterDropDown;

	@FindBy(id = "shopping_cart_container")
	WebElement shoppingCartButton;

	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	WebElement addToCartBackPackButton;
	
	@FindBy(id = "aremove-sauce-labs-backpack")
	WebElement removeBackPackButton;

	@FindBy(xpath = "//span[@class='title']")
	WebElement inventoryPageTitle;

	public InventoryPage(WebDriver driver) {
		super(driver);
	}

	private void filterBy(String value) {
		Select filterDropdown = new Select(filterDropDown);
		wait.until(ExpectedConditions.visibilityOf(filterDropDown));
		filterDropdown.selectByValue(value);
		Reporter.log("Elements sorted with the valiue " + value + "✅");
	}

	public void filterByNameAZ() {
		this.filterBy("az");
	}

	public void filterByNameZA() {
		this.filterBy("za");
	}

	public void filterByPriceLowToHigh() {
		this.filterBy("lohi");
	}

	public void filterByPriceHighToLow() {
		this.filterBy("hilo");
	}

	public void clickShoppingCartButton() {
		super.clickWebElement(shoppingCartButton);
	}

	public void validateInventoryPageLoaded() {
		super.waitForPageToLoad();
		assertTrue(driver.getCurrentUrl().contains("/inventory.html"), "Page not navigated to /inventory.html");
		Reporter.log("Inventory Page title");
	}

	public void verifyInventoryPageTitle() {
		SoftAssert softAssert = new SoftAssert();

		softAssert.assertTrue(inventoryPageTitle.isDisplayed(), "Inventory page title not displayed");
		softAssert.assertTrue(inventoryPageTitle.getText().contains("Products"), "Inventory page title mispelled");
		softAssert.assertAll();

		Reporter.log("Inventory Page title dsiplayed correctly");
	}

	public void clickAddToCartSauceLabsBackpackButton() {
		super.clickWebElement(addToCartBackPackButton);
	}

	public void validateRemoveSauceLabsBackpackButtonDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(removeBackPackButton));
		assertTrue(removeBackPackButton.isDisplayed(), "Remove button not displayed");
		Reporter.log("Remove button displayed.");
	}
	
}
