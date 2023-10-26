package com.ageoflearning.qa.selenium.pageobjects.registrationpage;

import com.ageoflearning.qa.selenium.pageobjects.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Wait;

public class RegistrationPage extends BasePage {

	public RegistrationPage(WebDriver driver, Wait<WebDriver> wait) {
		super(driver, wait);
	}

	public void enterEmail(String email) {
		WebElement topElement = driver.findElement(By.cssSelector("[class='loaded']"));
		SearchContext topRoot = topElement.getShadowRoot();
		WebElement secondElement = topRoot.findElement(By.cssSelector("#page-component"));
		SearchContext secondRoot = secondElement.getShadowRoot();
		WebElement thirdElement = secondRoot.findElement(By.cssSelector("#email"));
		thirdElement.sendKeys(email);
	}

	public void clickSubmitButton() {
		WebElement topElement = driver.findElement(By.cssSelector("[class='loaded focus-visible']"));
		SearchContext topRoot = topElement.getShadowRoot();
		WebElement secondElement = topRoot.findElement(By.cssSelector("#page-component"));
		SearchContext secondRoot = secondElement.getShadowRoot();
		WebElement thirdElement = secondRoot.findElement(By.cssSelector("#submit-button"));
		thirdElement.click();
	}

	public String getBecomeAMemberText() {
		WebElement topElement = driver.findElement(By.cssSelector("[class='loaded']"));
		SearchContext topRoot = topElement.getShadowRoot();
		WebElement secondElement = topRoot.findElement(By.cssSelector("#page-component"));
		SearchContext secondRoot = secondElement.getShadowRoot();
		WebElement thirdElement = secondRoot.findElement(By.cssSelector("#become-member"));

		return thirdElement.getText();
	}
}
