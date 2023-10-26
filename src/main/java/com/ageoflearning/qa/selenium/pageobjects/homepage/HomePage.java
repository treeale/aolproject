package com.ageoflearning.qa.selenium.pageobjects.homepage;

import com.ageoflearning.qa.selenium.pageobjects.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Wait;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver, Wait<WebDriver> wait) {
		super(driver, wait);
	}

	public void clickOnSignUpButton () {
		WebElement topElement = driver.findElement(By.cssSelector("[class='loaded']"));
		SearchContext topRoot = topElement.getShadowRoot();
		WebElement secondElement = topRoot.findElement(By.cssSelector("#page-component"));
		SearchContext secondRoot = secondElement.getShadowRoot();
		WebElement thirdElement = secondRoot.findElement(By.cssSelector("main-layout > header > home-header > authstate-context:nth-child(3) > signup-button"));
		thirdElement.click();
	}
}
