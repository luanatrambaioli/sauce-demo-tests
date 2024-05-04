package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SauceDemoProductDetailsPage {
	private WebDriver driver;

	// Locators
	private By productLink = By.className("inventory_item_name");
	private By productName = By.className("inventory_details_name");
	private By productDescription = By.className("inventory_details_desc");
	private By productPrice = By.className("inventory_details_price");

	public SauceDemoProductDetailsPage(WebDriver driver) {
		this.driver = driver;
	}

	public void verifyProductDetailsPageNavigation() {
		// Click on a product to view its details
		WebElement productLinkElement = driver.findElement(productLink);
		productLinkElement.click();

		// Validation: Verify that the correct product details are displayed
		WebElement productNameElement = driver.findElement(productName);
		String actualProductName = productNameElement.getText();
		String expectedProductName = "Sauce Labs Backpack"; // Example expected product name
		if (actualProductName.equals(expectedProductName)) {
			System.out.println("Product name validation passed.");
		} else {
			System.out.println("Product name validation failed.");
		}

		WebElement productDescriptionElement = driver.findElement(productDescription);
		String actualProductDescription = productDescriptionElement.getText();
		String expectedProductDescription = "Carry your JS essentials wherever you go with this sleek backpack.";
		if (actualProductDescription.equals(expectedProductDescription)) {
			System.out.println("Product description validation passed.");
		} else {
			System.out.println("Product description validation failed.");
		}

		WebElement productPriceElement = driver.findElement(productPrice);
		String actualProductPrice = productPriceElement.getText();
		String expectedProductPrice = "$29.99"; // Example expected product price
		if (actualProductPrice.equals(expectedProductPrice)) {
			System.out.println("Product price validation passed.");
		} else {
			System.out.println("Product price validation failed.");
		}
	}
}