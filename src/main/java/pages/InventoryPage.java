package pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import base.BasePage;

public class InventoryPage extends BasePage {

	@FindBy(xpath = "//select[@class='product_sort_container']")
	WebElement filterDropDown;

	@FindBy(xpath = "//*[@class='shopping_cart_link']")
	WebElement shoppingCartButton;

	@FindBy(xpath = "//*[@class='title']")
	WebElement inventoryPageTitle;

	@FindBy(xpath = "//*[@class='shopping_cart_badge']")
	WebElement shoppingCartBadge;

	private int itemsCounter = 0;
	
	//products names
	private final String backPack = "sauce-labs-backpack";
	
	//filter categories
	public static final String FILTER_AZ_ORDER = "az";
	public static final String FILTER_ZA_ORDER = "za";
	public static final String FILTER_LOW_HIGH_PRICE = "lohi";
	public static final String FILTER_HIGH_LOW_PRICE = "hilo";

	public InventoryPage(WebDriver driver) {
		super(driver);
	}

	private void filterBy(String value) {
		Select filterDropdown = new Select(filterDropDown);
		super.waitForVisibility(filterDropDown);
		filterDropdown.selectByValue(value);
		Reporter.log("Elements sorted with the valiue " + value + "✅");
	}

	public void filterByNameAZ() {
		this.filterBy(FILTER_AZ_ORDER);
	}

	public void filterByNameZA() {
		this.filterBy(FILTER_ZA_ORDER);
	}

	public void filterByPriceLowToHigh() {
		this.filterBy(FILTER_LOW_HIGH_PRICE);
	}

	public void filterByPriceHighToLow() {
		this.filterBy(FILTER_HIGH_LOW_PRICE);
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

	private WebElement addToCartProductButton(String product) {
		WebElement addToCartButton = driver.findElement(By.id("add-to-cart-" + product));
		return addToCartButton;
	}

	private WebElement removeProductButton(String product) {
		WebElement addToCartButton = driver.findElement(By.id("remove-" + product));
		return addToCartButton;
	}

	public void clickAddToCartSauceLabsBackpackButton() {
		super.clickWebElement(this.addToCartProductButton(backPack));
		itemsCounter++;
		Reporter.log("Sauce Labs backpack added to cart.");
	}

	public void clickRemoveSauceLabsBackpackButton() {
		super.clickWebElement(this.removeProductButton(backPack));
		itemsCounter++;
		Reporter.log("Sauce Labs backpack product removed.");
	}

	public void validateRemoveSauceLabsBackpackButtonDisplayed() {
		super.validateElementIsDisplayed(this.removeProductButton(backPack));
		Reporter.log("Sauce Labs backpack remove button displayed.");
	}

	public void validateAddToCartSauceLabsBackpackButtonDisplayed() {
		super.validateElementIsDisplayed(this.addToCartProductButton(backPack));
		Reporter.log("Sauce Labs backpack add to cart button displayed.");
	}

	public void validateCartBadgeNumberisCorrect() {
		super.waitForVisibility(shoppingCartBadge);
		int actualNumber = Integer.parseInt(shoppingCartBadge.getText());
		assertEquals(itemsCounter, actualNumber);
		Reporter.log("Expected badge number: " + itemsCounter + " Is the actual badge number: " + actualNumber);
	}
	
	public void validateCartBadgeNumberisEmpty() {
		super.waitForVisibility(shoppingCartButton);
		List<WebElement> children = shoppingCartButton.findElements(By.xpath("./*"));
	    assertTrue(children.isEmpty(), "Elements in Cart Badge Present");
		Reporter.log("No Elements in Cart Badge" );
	}

}
