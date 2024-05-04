package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.SauceDemoLoginPage;
import pages.SauceDemoMenuPage;

public class SauceDemoMenu {

    public static void main(String[] args) {
        WebDriver driver = null;
        try {
            // Set up WebDriver 
            driver = initializeDriver();

            // Initialize page objects
            SauceDemoLoginPage loginPage = new SauceDemoLoginPage(driver);
            SauceDemoMenuPage menuPage = new SauceDemoMenuPage(driver);

            // Navigate to the website
            navigateToWebsite(driver);

            // Perform login
            loginPage.login();

            // Click on the side menu button
            menuPage.openSideMenu();

            // Click on the "About" option in the side menu
            menuPage.clickAboutOption();

            // Check if the About page is displayed
            boolean isAboutPageDisplayed = menuPage.isAboutPageDisplayed();
            printAboutPageStatus(isAboutPageDisplayed);

            // Wait for a few seconds to see the result before closing the browser
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

    private static WebDriver initializeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private static void navigateToWebsite(WebDriver driver) {
        driver.get("https://www.saucedemo.com/");
    }

    private static void printAboutPageStatus(boolean isAboutPageDisplayed) {
        if (isAboutPageDisplayed) {
            System.out.println("About page is displayed.");
        } else {
            System.out.println("About page is not displayed.");
        }
    }

    private static void waitForPageLoad() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
