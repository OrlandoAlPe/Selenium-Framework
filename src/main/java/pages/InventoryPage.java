package pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.util.ArrayList;
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

	@FindBy(xpath = "//*[@class='inventory_item_price']")
	List<WebElement> itemPricesList;

	int itemsCounter = 0;
	// products names
	private final String backPack = "sauce-labs-backpack";
	private final String bikeLight = "sauce-labs-bike-light";

	// filter categories
	private static final String FILTER_AZ_ORDER = "az";
	private static final String FILTER_ZA_ORDER = "za";
	private static final String FILTER_LOW_HIGH_PRICE = "lohi";
	private static final String FILTER_HIGH_LOW_PRICE = "hilo";

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
		super.validatePageLoaded("/inventory.html");
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

	public void clickAddToCartSauceLabsBickeLightButton() {
		super.clickWebElement(this.addToCartProductButton(bikeLight));
		itemsCounter++;
		Reporter.log("Sauce Labs bicke light added to cart.");
	}

	public void clickRemoveSauceLabsBackpackButton() {
		super.clickWebElement(this.removeProductButton(backPack));
		itemsCounter--;
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
		Reporter.log("No Elements in Cart Badge");
	}

	public void validatePricesAreSortedLowToHigh() {
		super.waitForVisibility(itemPricesList.get(0));
		List<Float> prices = new ArrayList<Float>();

		for (WebElement price : itemPricesList) {
			prices.add(Float.parseFloat(price.getText().replace("$", "")));
		}

		for (int i = 0; i < prices.size() - 1; i++) {
			if (prices.get(i) > prices.get(i + 1)) {
				fail("prices are not sorted low to high.");
			}
		}
		Reporter.log("prices sorted Low to High");

	}

	public void navigateInventoryPage() {
		driver.get("https://www.saucedemo.com/inventory.html");
		Reporter.log("Navigated to https://www.saucedemo.com/inventory.html");
	}
	
}
