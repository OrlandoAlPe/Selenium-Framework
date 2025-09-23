package pages;

public class LoginPage extends BasePage {

	private String url = "https://www.saucedemo.com/";

	public void goThisPage() {
		navigateToPage(url);
	}

}
