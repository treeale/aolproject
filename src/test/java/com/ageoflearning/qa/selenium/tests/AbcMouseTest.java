package com.ageoflearning.qa.selenium.tests;

import com.ageoflearning.qa.selenium.framework.BaseFramework;
import com.ageoflearning.qa.selenium.pageobjects.homepage.HomePage;
import com.ageoflearning.qa.selenium.pageobjects.registrationpage.RegistrationPage;
import com.ageoflearning.qa.selenium.pageobjects.subscriptionpage.SubscriptionPage;
import org.junit.Test;

public class AbcMouseTest extends BaseFramework {

	/**
	 * Enter email to register and verify pages
	 * @assert: That the page we land on is what is expected by checking the page URL and page elements
	 */
	@Test
	public void navigateToPagesAndVerify() {
		driver.get(getConfiguration("HOMEPAGE"));
		HomePage homePage = new HomePage(driver, wait);
		RegistrationPage registrationPage = new RegistrationPage(driver, wait);
		SubscriptionPage subscriptionPage = new SubscriptionPage(driver, wait);
		driver.manage().window().maximize();

		homePage.clickOnSignUpButton();
		softly.assertThat(doesURLContains("https://www.abcmouse.com/abc/prospect-register/")).as("Registration page should be loaded").isEqualTo(true);
		softly.assertThat(driver.getCurrentUrl()).as("Registration page should be loaded").contains("https://www.abcmouse.com/abc/prospect-register/");
		//Requirement said to check this on the subscription page but the "Become a Member!" text is rendered in the registration page
		softly.assertThat(registrationPage.getBecomeAMemberText()).as("Become a member text is rendered").isEqualTo("Become a Member!");
		registrationPage.enterEmail(getConfiguration("EMAIL"));
		registrationPage.clickSubmitButton();
		softly.assertThat(doesURLContains("https://www.abcmouse.com/abc/subscription/")).as("Subscription page should be loaded").isEqualTo(true);

		softly.assertAll();
	}
}
