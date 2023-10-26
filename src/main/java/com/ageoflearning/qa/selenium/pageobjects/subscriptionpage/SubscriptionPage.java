package com.ageoflearning.qa.selenium.pageobjects.subscriptionpage;

import com.ageoflearning.qa.selenium.pageobjects.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Wait;

public class SubscriptionPage extends BasePage {

    public SubscriptionPage(WebDriver driver, Wait<WebDriver> wait) {
        super(driver, wait);
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
