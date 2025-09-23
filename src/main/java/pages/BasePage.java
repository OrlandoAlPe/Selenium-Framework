package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
	
	private WebDriver driver;
	
	public void navigateToPage(String url) {
		driver.get(url);
	}
	
	
}
