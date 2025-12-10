package pages;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import utils.TestSession;

public class CartPage extends BasePage {

	@FindBy(xpath = "//*[@class='cart_item']")
	List<WebElement> cartItemsList;

	@FindBy(id = "checkout")
	WebElement checkoutButton;
	
	@FindBy(id = "continue-shopping")
	WebElement continueShoppingButton;
	
	TestSession testSession = new TestSession();	
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
}
