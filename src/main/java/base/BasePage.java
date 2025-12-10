package base;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class BasePage {

	protected final WebDriver driver;
	protected final WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	protected void clickWebElement(WebElement button) {
		wait.until(ExpectedConditions.visibilityOf(button));
		button.click();
		Reporter.log("Element clicked");
	}

	protected void waitForVisibility(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		Reporter.log("Element visible");
	}

	protected void waitForPageToLoad() {
		wait.until(
				driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
	}

	protected void validateElementIsDisplayed(WebElement element) {
		this.waitForVisibility(element);
		assertTrue(element.isDisplayed());
		Reporter.log("Element displayed");

	}

	protected void validatePageLoaded(String url) {
		this.waitForPageToLoad();
		assertTrue(driver.getCurrentUrl().contains(url), "Page not navigated to " + url);
		Reporter.log("Page navigated to " + url);
	}
	
	protected void fillTextField(WebElement element,String text) {
		this.waitForPageToLoad();
		this.waitForVisibility(element);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.sendKeys(text);
		Reporter.log("Text Field filled.");
	}

	protected void validateTextMessage(String text, WebElement element) {
		this.waitForPageToLoad();
		this.validateElementIsDisplayed(element);
		assertTrue(element.getText().equals(text),
				"Displayed text:" + element.getText() + "  is different than expected text: " + text);
		Reporter.log("Expected message: " + text + " displayed");

	}

}
