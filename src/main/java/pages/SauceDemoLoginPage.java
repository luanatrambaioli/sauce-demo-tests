package pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SauceDemoLoginPage {
	private WebDriver driver;

	// Locators
	private By usernameField = By.id("user-name");
	private By passwordField = By.id("password");
	private By loginButton = By.id("login-button");
	private By cartIcon = By.className("shopping_cart_link");

	public SauceDemoLoginPage(WebDriver driver) { 
		this.driver = driver;
	}

	public void login() {
		String username = getRandomUsername();
		String password = "secret_sauce"; // Assuming password is constant
		enterUsername(username);
		enterPassword(password);
		clickLoginButton();
	}

	public boolean isLoginSuccessful() { 
		try {
			// Check if the cart icon is displayed after login
			WebElement cartIconElement = driver.findElement(cartIcon);
			return cartIconElement.isDisplayed();
		} catch (Exception e) {
			// If cart icon is not found or not displayed, login is not successful
			return false;
		}
	}

	private String getRandomUsername() {
		String[] usernames = { "standard_user", "problem_user", "visual_user" };
		Random random = new Random();
		int randomIndex = random.nextInt(usernames.length);
		return usernames[randomIndex];
	}

	private void enterUsername(String username) {
		WebElement usernameFieldElement = driver.findElement(usernameField);
		usernameFieldElement.sendKeys(username);
	}

	private void enterPassword(String password) {
		WebElement passwordFieldElement = driver.findElement(passwordField);
		passwordFieldElement.sendKeys(password);
	}

	private void clickLoginButton() {
		WebElement loginButtonElement = driver.findElement(loginButton);
		loginButtonElement.click();
	}
}
