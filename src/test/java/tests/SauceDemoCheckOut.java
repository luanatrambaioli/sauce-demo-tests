package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.SauceDemoCheckoutPage;
import pages.SauceDemoLoginPage;

public class SauceDemoCheckOut {

    public static void main(String[] args) {
        // Set up WebDriver
        WebDriver driver = initializeDriver();

        // Initialize page objects
        SauceDemoLoginPage loginPage = new SauceDemoLoginPage(driver);
        SauceDemoCheckoutPage checkoutPage = new SauceDemoCheckoutPage(driver);

        // Navigate to the website
        navigateToWebsite(driver);

        // Perform login
        loginPage.login();

        // Add items to cart
        addItemsToCart(checkoutPage);

        // Verify that the cart icon reflects the correct number of items
        verifyCartItemCount(checkoutPage, 2); // Assuming 2 items were added to the cart

        // Go to checkout page
        goToCheckoutPage(checkoutPage);

        // Fill checkout information
        fillCheckoutInformation(checkoutPage);

        // Check if the order confirmation message is displayed
        verifyOrderConfirmation(checkoutPage);

        // Close the browser
        closeBrowser(driver);
    }

    private static WebDriver initializeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private static void navigateToWebsite(WebDriver driver) {
        driver.get("https://www.saucedemo.com/");
    }

    private static void addItemsToCart(SauceDemoCheckoutPage checkoutPage) {
        checkoutPage.addItemToCart(1);
        checkoutPage.addItemToCart(2);
    }

    private static void verifyCartItemCount(SauceDemoCheckoutPage checkoutPage, int expectedItemCount) {
        boolean isCartItemCountCorrect = checkoutPage.isCartItemCountCorrect(expectedItemCount);
        if (isCartItemCountCorrect) {
            System.out.println("Cart icon reflects the correct number of items.");
        } else {
            System.out.println("Cart icon does not reflect the correct number of items.");
        }
    }

    private static void goToCheckoutPage(SauceDemoCheckoutPage checkoutPage) {
        checkoutPage.goToCheckout();
    }

    private static void fillCheckoutInformation(SauceDemoCheckoutPage checkoutPage) {
        checkoutPage.fillCheckoutInfo();
    }

    private static void verifyOrderConfirmation(SauceDemoCheckoutPage checkoutPage) {
        if (checkoutPage.isOrderConfirmationDisplayed()) {
            System.out.println("Checkout successful: Thank you for your order!");
        } else {
            System.out.println("Checkout confirmation not found.");
        }
    }

    private static void closeBrowser(WebDriver driver) {
        driver.quit();
    }
}
