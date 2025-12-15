package base;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.TestSession;

public class BaseTest {
	protected WebDriver driver;

	@BeforeMethod
	public void driverSetup() {
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.password_manager_leak_detection", false);
		prefs.put("credentials_enable_service", false);
		options.setExperimentalOption("prefs", prefs);

		// Detects if we are on CI/CD
		if (System.getenv("CI") != null) {
			options.addArguments("--headless");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--disable-gpu");
			options.addArguments("--window-size=1920,1080");
		}

		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void testTearDown() {
		TestSession.clear();
		if (driver != null) {
			driver.quit();
		}

	}

}
