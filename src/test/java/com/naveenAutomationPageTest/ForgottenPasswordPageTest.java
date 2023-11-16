package com.naveenAutomationPageTest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.ForgottenPasswordPage;
import com.naveenautomation.pages.LoginPage;

public class ForgottenPasswordPageTest extends TestBase {

	LoginPage loginPage;
	ForgottenPasswordPage forgottenPasswordPage;

	@BeforeMethod
	public void launchBrowser() {
		initialise();
		loginPage = new LoginPage();
	}

	public void validateUserCanNavigateToForgottenPasswordPage() {
		forgottenPasswordPage = loginPage.clickForgottenPasswordPageLink();
		Assert.assertEquals(forgottenPasswordPage.getforgetPwdPageText(), "Forgot Your Password?",
				"Navigation to Forgotten Password Page Failed!!!");
	}

	@Test
	public void validateUserWillGetConfirmationLinkUsingValidEmail() {
		// Click on the "Forgotten Password" link on the login page
		forgottenPasswordPage = loginPage.clickForgottenPasswordPageLink();
		forgottenPasswordPage.enterEmail("SamStark@gmail.com");
		loginPage = forgottenPasswordPage.clickContinueBtnWithVaidEmail();

		Assert.assertEquals(loginPage.getSuccessAlertText(),
				"An email with a confirmation link has been sent your email address.",
				"Password modification with valid email address failed!!!");
	}

	@Test
	public void validateUserWillNotGetConfirmationLinkUsingInvalidEmail() {
		// Click on the "Forgotten Password" link on the login page
		forgottenPasswordPage = loginPage.clickForgottenPasswordPageLink();

		// Verify if the page banner text matches "Forgot Your Password?"
		forgottenPasswordPage.enterEmail("Samds@gmail.com");

		forgottenPasswordPage.clickContinueBtn();

		// Verify if the warning message matches the expected message
		Assert.assertEquals(loginPage.getDangerAlertText(),
				"Warning: The E-Mail Address was not found in our records, please try again!",
				"User is able to get confirmation link with invalid email address");

	}
}
