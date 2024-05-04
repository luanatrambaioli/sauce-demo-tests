package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.SauceDemoFilteringPage;
import pages.SauceDemoLoginPage;

public class SauceDemoFiltering {

    public static void main(String[] args) {
        WebDriver driver = null;
        try {
            // Set up WebDriver
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            // Initialize page objects
            SauceDemoFilteringPage filteringPage = new SauceDemoFilteringPage(driver);
            SauceDemoLoginPage loginPage = new SauceDemoLoginPage(driver);

            // Navigate to the website
            navigateToWebsite(driver);

            // Perform login
            loginPage.login();

            // Wait for the page to load
            waitForPageLoad();

            // Filter products by price (low to high)
            filteringPage.filterByPriceLowToHigh();

            // Check if the products are filtered correctly
            boolean isFiltered = verifyPriceSorting(filteringPage);

            // Print filter status
            printFilterStatus(isFiltered);

            // Wait for a few seconds before closing the browser
            waitForPageLoad();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            if (driver != null) {
                driver.quit();
            }
        }
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

    private static boolean verifyPriceSorting(SauceDemoFilteringPage filteringPage) {
        return filteringPage.isPriceSortedLowToHigh();
    }

    private static void printFilterStatus(boolean isFiltered) {
        if (isFiltered) {
            System.out.println("Products are filtered correctly.");
        } else {
            System.out.println("Products are not filtered correctly.");
        }
    }
}
