package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SauceDemoMenuPage {
	private WebDriver driver; 

	// Locators
	private By menuButton = By.className("bm-burger-button");
	private By aboutOption = By.id("about_sidebar_link");
	private By aboutPageHeader = By.className("MuiToolbar-root");

	public SauceDemoMenuPage(WebDriver driver) {
		this.driver = driver;
	}

	public void openSideMenu() {
		clickMenuButton();
		waitForPageLoad();
	}

	public void clickAboutOption() {
		WebElement aboutOptionElement = driver.findElement(aboutOption);
		aboutOptionElement.click();
	}

	public boolean isAboutPageDisplayed() {
		return driver.findElement(aboutPageHeader).getText().equals("About");
	}

	private void clickMenuButton() {
		WebElement menuButtonElement = driver.findElement(menuButton);
		menuButtonElement.click();
	}

	private void waitForPageLoad() {
		try {
			Thread.sleep(3000); // Adjust the sleep time as needed
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
