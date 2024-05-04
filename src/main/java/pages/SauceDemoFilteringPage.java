package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SauceDemoFilteringPage {
	private WebDriver driver;

	// Locators
	private By usernameField = By.id("user-name");
	private By passwordField = By.id("password"); 
	private By loginButton = By.id("login-button");
	private By filterDropdown = By.className("product_sort_container");
	private By productPrice = By.className("inventory_item_price");

	public SauceDemoFilteringPage(WebDriver driver) {
		this.driver = driver;
	}

	public void login(String username, String password) {
		WebElement usernameElement = driver.findElement(usernameField);
		usernameElement.sendKeys(username);

		WebElement passwordElement = driver.findElement(passwordField);
		passwordElement.sendKeys(password);

		WebElement loginButtonElement = driver.findElement(loginButton);
		loginButtonElement.click();
	}

	public void filterByPriceLowToHigh() {
		WebElement filterDropdownElement = driver.findElement(filterDropdown);
		Select filterSelect = new Select(filterDropdownElement);
		filterSelect.selectByValue("lohi"); // Low to high
	}

	public boolean isPriceSortedLowToHigh() {
		List<WebElement> prices = driver.findElements(productPrice);
		for (int i = 1; i < prices.size(); i++) {
			String price1 = prices.get(i - 1).getText().replace("$", "");
			String price2 = prices.get(i).getText().replace("$", "");
			double p1 = Double.parseDouble(price1);
			double p2 = Double.parseDouble(price2);
			if (p1 > p2) {
				return false;
			}
		}
		return true;
	}

	public void printFilterStatus(boolean isFiltered) {
		if (isFiltered) {
			System.out.println("Products are filtered correctly.");
		} else {
			System.out.println("Products are not filtered correctly.");
		}
	}
}
