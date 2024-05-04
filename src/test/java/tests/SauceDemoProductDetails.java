package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.SauceDemoLoginPage;
import pages.SauceDemoProductDetailsPage;

public class SauceDemoProductDetails {

    public static void main(String[] args) {
        WebDriver driver = null;
        try {
            // Set up WebDriver
            driver = initializeDriver();

            // Initialize page objects
            SauceDemoLoginPage loginPage = new SauceDemoLoginPage(driver);
            SauceDemoProductDetailsPage productDetailsPage = new SauceDemoProductDetailsPage(driver);

            // Navigate to the website and login
            navigateToWebsite(driver);
            loginPage.login();

            // Perform product details page navigation verification
            productDetailsPage.verifyProductDetailsPageNavigation();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            if (driver != null) {
                driver.quit();
            }
        }
    }

    private static WebDriver initializeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private static void navigateToWebsite(WebDriver driver) {
        driver.get("https://www.saucedemo.com/");
    }
}
