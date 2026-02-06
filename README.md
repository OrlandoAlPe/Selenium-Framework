<h1>SauceDemo Test Automation Framework</h1>
A comprehensive test automation framework for SauceDemo e-commerce application, built using Java, Selenium WebDriver, TestNG, and Maven, following the Page Object Model design pattern.

Features CI/CD pipeline with GitHub Actions for automated test execution on every push

![Java](https://img.shields.io/badge/Java-21-orange)
![Selenium](https://img.shields.io/badge/Selenium-4.x-green)
![TestNG](https://img.shields.io/badge/TestNG-7.8-red)
![Maven](https://img.shields.io/badge/Maven-4.0+-blue)
![GitHubAcions](https://img.shields.io/badge/GitHubActions-purple)

<h1>🎯 Project Overview</h1>
This framework demonstrates end-to-end test automation for an e-commerce workflow, including user authentication, product browsing, shopping cart management, and checkout process. The project showcases best practices in test automation architecture and maintainable code structure.


<h1>🛠️ Technologies Used</h1>
      
- Java 21 - Programming language
- Selenium WebDriver  - Browser automation
- TestNG - Testing framework
- Maven - Build and dependency management
- Page Object Model (POM) - Design pattern for maintainability
- WebDriverManager - Automatic driver management
- GitHubActions 

<h1>📁 Project Structure </h1>

```
saucedemo-automation/

saucedemo-automation/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── base/
│   │           ├── BasePage.java
│   │           └── BaseTest.java
│   │       └── pages/
│   │           ├── CartPage.java
│   │           ├── CheckoutOverviewPage.java
│   │           ├── CheckoutPege.java
│   │           ├── ConfirmationPage.java
│   │           ├── HomePage.java
│   │           ├── InventoryPage.java
│   │           └── LoginPage.java
│   │       └── utils/
│   │           └── TestSession.java
│   └── test/
│       └── java/
│           └── tests/
│               ├──  SD1_Successful_Login.java
│               ├──  SD2_Invalid_Credentials_Login.java
│               ├──  SD3_Add_tems_To_Cart.java
│               ├──  SD4_Remove_Product_From_Cart.java
│               ├──  SD5_Verify_multiple_items_cart.java
│               ├──  SD6_Complete_Checkout_Process.java
│               ├──  SD7_Price_Order_Low_To_High.java
│               ├──  SD8_Verify_Logout.java
│               ├──  SD1_Successful_Login.java
│               ├──  SD9_Continue_Purchase_From_Cart.java
│               └──  SD10_Verify_Mandatory_Checkout_Fields.java
├── testng.xml
├── pom.xml
└── README.md
```
<h1>🚀 Features </h1>

- Page Object Model (POM) design pattern for better maintainability
- Reusable base classes for common functionality
- Explicit waits for dynamic elements
- Test execution reports with TestNG
- Maven integration for dependency management
- Modular and scalable framework structure


<h1>📋 Test Scenarios Covered</h1>
<h3> Authentication Tests </h3> 

- Login with valid credentials
- Login with invalid credentials

<h3>Inventory Tests</h3>

- Verify products are displayed
- Sort products by price (low to high, high to low)
- Add single product to cart
- Add multiple products to cart


<h3>Shopping Cart Tests</h3>

- Verify products in cart match added items
- Remove product from cart
- Verify cart count updates correctly
- Continue shopping functionality


<h3>Checkout Tests</h3>

- Complete checkout with valid information
- Verify order confirmation
- Checkout with missing information (negative test)

<h1>🔧 Prerequisites</h1>
Before running the tests, ensure you have the following installed:

- Java JDK 21 or higher
- Maven 3.6+
- Chrome/Firefox/Edge browser
- Git (for cloning the repository)

<h1>⚙️ Installation & Setup</h1>

Clone the repository:

bash   git clone https://github.com/OrlandoAlPe/Selenium-Framework.git
   cd saucedemo-automation

Install dependencies:
bash   mvn clean install

<h1>🏗️ Framework Architecture</h1>

- Page Object Model (POM)
- Each page of the application has a corresponding Page Object class that encapsulates:
- Web elements (locators)
- Actions that can be performed on the page
- Verification methods

Example:

```
public class LoginPage extends BasePage {
    
    // Locators
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    
    // Actions
    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}

```

<h4>Base Classes:</h4>

- BasePage: Contains common web operations (waits, clicks, text input)
- BaseTest: Handles WebDriver initialization and teardown
- Configuration properties for environment settings
- Test-specific constants for reusable values


<h1>🐛 Known Issues & Limitations</h1>

- Tests run in sequential mode (parallel execution not implemented)
- Screenshots on failure not implemented

<h1>📝 Best Practices Implemented</h1>

- Separation of concerns (Page Objects vs Test Logic)
- DRY principle (Don't Repeat Yourself)
- Meaningful naming conventions
- Proper exception handling
- Use of explicit waits over implicit waits
- Independent test cases (no dependencies between tests)
- Clear and descriptive assertions

<h1>👤 Contact</h1>
Orlando Álvarez

- 📧 Email: orlandoalpe97@gmail.com
- 💼 LinkedIn: https://www.linkedin.com/in/orlando-%C3%A1lvarez-peregrina-b27398181/
- 🐙 GitHub: https://github.com/OrlandoAlPe
- 📍 Location: Aguascalientes, México

📄 License
This project is open source and available under the MIT License.

⭐ If you find this project useful, please consider giving it a star!
Built with ❤️ for learning and demonstrating QA Automation skills
