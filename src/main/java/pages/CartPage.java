package pages;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import base.BasePage;
import utils.TestSession;

public class CartPage extends BasePage {

	@FindBy(xpath = "//*[@class='cart_item']")
	List<WebElement> cartItemsList;

	@FindBy(id = "checkout")
	WebElement checkoutButton;

	@FindBy(id = "continue-shopping")
	WebElement continueShoppingButton;

	@FindBy(xpath = "//*[@class='inventory_item_name']")
	List<WebElement> cartProductNames;

	@FindBy(xpath = "//*[@class='inventory_item_price']")
	List<WebElement> cartProductPrices;

	private final String prouctPrefix = "//*[@class='cart_item'][";
	private final String prouctPriceSufix = "]//*[@class='inventory_item_price']";
	private final String prouctNameSufix = "]//*[@class='inventory_item_name']";

	public CartPage(WebDriver driver) {
		super(driver);
	}

	public void validateCartPageLoaded() {
		super.validatePageLoaded("/cart.html");
	}

	public void validateThereAre2ItemsInCartList() {
		assertTrue(cartItemsList.size() == 2, "Miss match between expected items and displayed items");
	}

	public void clickCheckoutButton() {
		super.clickWebElement(checkoutButton);
	}

	public void clickContinueShoppingButton() {
		super.clickWebElement(continueShoppingButton);
	}

	public void verifyProductsInSession() {

		List<String> cartProductNamesList = new ArrayList<String>();
		List<String> cartProductPricesList = new ArrayList<String>();
		Reporter.log("Cart page products names and prices initialized.");

		List<String> cartSessionProductNames = TestSession.getCartProducts().stream().map(map -> map.get("name"))
				.collect(Collectors.toList());
		List<String> cartSessionProductPrices = TestSession.getCartProducts().stream().map(map -> map.get("price"))
				.collect(Collectors.toList());
		Reporter.log("Items added to cart from inventory page gathered from session.");

		for (int i = 1; i <= cartItemsList.size(); i++) {
			cartProductNamesList.add(driver.findElement(By.xpath(prouctPrefix + i + prouctNameSufix)).getText());
			cartProductPricesList.add(driver.findElement(By.xpath(prouctPrefix + i + prouctPriceSufix)).getText());
		}
		Reporter.log("Cart page products names and prices gathered.");

		assertTrue(cartProductNamesList.size() == cartSessionProductNames.size());
		assertTrue(cartProductPricesList.size() == cartSessionProductPrices.size());
		Reporter.log("Amount of items in cart and items in session matched.");

		for (int i = 0; i <= cartProductNamesList.size() - 1; i++) {
			assertTrue(cartSessionProductNames.contains(cartProductNamesList.get(i)),
					"Product name in cart not matching");
			assertTrue(cartSessionProductPrices.contains(cartProductPricesList.get(i)),
					"Product pric in cart not matching");
		}

		Reporter.log("Products added in inventory page present in cart page.");

	}
}
