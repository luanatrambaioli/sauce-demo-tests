package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SauceDemoCheckoutPage {
	private WebDriver driver;

	public SauceDemoCheckoutPage(WebDriver driver) {
		this.driver = driver; 
	}

	public void addItemToCart(int itemNumber) {
		// Add item to cart
		String xpath = String.format("//div[@class='inventory_item'][%d]//button", itemNumber);
		WebElement addItemButton = driver.findElement(By.xpath(xpath));
		addItemButton.click();
		// Wait for a few seconds to see the result before continuing
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void goToCheckout() {
		// Click on shopping cart icon to go to checkout
		WebElement cartIcon = driver.findElement(By.className("shopping_cart_link"));
		cartIcon.click();
		// Click on checkout button
		WebElement checkoutButton = driver.findElement(By.cssSelector("#checkout"));
		checkoutButton.click();
	}

	public void fillCheckoutInfo() {
		// Fill in checkout information
		WebElement firstNameField = driver.findElement(By.id("first-name"));
		firstNameField.sendKeys("John");

		WebElement lastNameField = driver.findElement(By.id("last-name"));
		lastNameField.sendKeys("Doe");

		WebElement zipCodeField = driver.findElement(By.id("postal-code"));
		zipCodeField.sendKeys("12345");

		// Click on continue button
		WebElement continueButton = driver.findElement(By.xpath("//input[@type='submit']"));
		continueButton.click();

		// Click on finish button
		WebElement finishButton = driver.findElement(By.cssSelector("#finish"));
		finishButton.click();
	}

	public boolean isOrderConfirmationDisplayed() {
		try {
			WebElement confirmationMessage = driver.findElement(By.xpath("//h2[text()='Thank you for your order!']"));
			return confirmationMessage.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean isCartItemCountCorrect(int expectedItemCount) {
        try {
            // Get the cart icon element
            WebElement cartIcon = driver.findElement(By.className("shopping_cart_link"));

            // Get the text content of the cart icon (number of items)
            String itemCountText = cartIcon.getText();

            // Parse the text content to an integer
            int actualItemCount = Integer.parseInt(itemCountText);

            // Compare the actual item count with the expected item count
            return actualItemCount == expectedItemCount;
        } catch (NoSuchElementException | NumberFormatException e) {
            // Handle if the cart icon or item count is not found
            e.printStackTrace();
            return false;
        }
    }
}
