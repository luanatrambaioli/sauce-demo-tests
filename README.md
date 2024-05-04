# SauceDemo Automation Test README

This README file provides instructions and explanations related to automating tests for the SauceDemo web application using Selenium WebDriver with Java and Maven.

---

## Setup

### Prerequisites
- Java Development Kit (JDK) installed on your system.
- Eclipse IDE or any other Java IDE installed (optional but recommended).
- Chrome browser installed on your system.

### Selenium WebDriver and ChromeDriver
1. Download the Selenium WebDriver Java bindings (JAR file) from the [Selenium website](https://www.selenium.dev/downloads/).
2. Download the appropriate version of ChromeDriver that matches the version of Chrome installed on your system from the [ChromeDriver downloads page](https://chromedriver.chromium.org/downloads).

### Project Setup with Maven
1. Create a new Maven project in your IDE or via the command line.
2. Add the Selenium WebDriver dependency to your project's `pom.xml` file:
    ```xml
    <dependencies>
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.1.1</version> <!-- Replace with the latest version -->
        </dependency>
    </dependencies>
    ```
3. Add the ChromeDriver executable to your project's directory and set its path in your Selenium code.

---

## Running Tests

### 1. Login Test
- The `LoginPage` class handles the login functionality.
- Use the `login` method of the `LoginPage` class to log in with valid credentials.
- Make sure to replace `"standard_user"` and `"secret_sauce"` with valid username and password.

### 2. Product Filtering Test
- The `ProductPage` class contains methods to interact with the product page.
- Use the `filterByPriceLowToHigh` method of the `ProductPage` class to filter products by price from low to high.

### 3. Navigation Test
- The `SideMenu` class handles interactions with the side menu.
- Use the `clickMenuButton` method of the `SideMenu` class to open the side menu.
- Use the `clickAboutOption` method of the `SideMenu` class to navigate to the "About" page.

### 4. Checkout Test
- Use the `fillCheckoutInfo` method to fill in checkout information with random data.

---

## Contributing

Contributions to improve the automation tests or enhance the README are welcome.
1. Fork the repository, make your changes, and submit a pull request.

---

## Troubleshooting 

If you encounter any errors or warnings, check the dependencies, ChromeDriver version, and browser compatibility. Ensure that the Selenium WebDriver version is compatible with the ChromeDriver version and the Chrome browser version installed on your system.
