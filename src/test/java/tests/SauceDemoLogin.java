package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.SauceDemoLoginPage;

public class SauceDemoLogin {

    public static void main(String[] args) {
        WebDriver driver = null;
        try {
            // Set up WebDriver
            driver = initializeDriver();

            // Initialize page objects
            SauceDemoLoginPage loginPage = new SauceDemoLoginPage(driver);

            // Navigate to the website
            navigateToWebsite(driver);

            // Perform login
            loginPage.login();

            // Wait for the page to load
            waitForPageLoad();

            // Check if login was successful 
            if (loginPage.isLoginSuccessful()) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Login failed!");
            }
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

    private static void waitForPageLoad() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
