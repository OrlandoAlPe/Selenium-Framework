package pages;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import base.BasePage;

public class InventoryPage extends BasePage {

	@FindBy(xpath = "//select[@class='product_sort_container']")
	WebElement filterDropDown;

	@FindBy(id = "shopping_cart_container")
	WebElement shoppingCartButton;

	@FindBy(id = "inventory_container")
	WebElement inventoryPageContatiner;

	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	WebElement addToCartBackPackButton;

	public InventoryPage(WebDriver driver) {
		super(driver);
	}

	private void filterBy(String value) {
		Select filterDropdown = new Select(filterDropDown);
		wait.until(ExpectedConditions.visibilityOf(filterDropDown));
		filterDropdown.selectByValue(value);
		System.out.println("Elements sorted with the valiue " + value + "✅");
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

	public void verifyInventoryPageLoaded() {
		assertTrue(inventoryPageContatiner.isDisplayed());
		System.out.println("Inventory Page displayed");
	}

}
