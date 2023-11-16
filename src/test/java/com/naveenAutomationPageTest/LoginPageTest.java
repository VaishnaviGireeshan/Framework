package com.naveenAutomationPageTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.EditAccountPage;
import com.naveenautomation.pages.ForgottenPasswordPage;
import com.naveenautomation.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	AccountPage accountPage;
	ForgottenPasswordPage forgottenPasswordPage;
	EditAccountPage editAccountPage;

	@BeforeMethod
	public void launchBrowser() {
		initialise();
		// Initialize the test by navigating to the login page
		loginPage = new LoginPage();
	}

	@Test

	public void validateUserCanLoginWithValidCredentials() {
		// Perform the login action
		accountPage = (AccountPage) loginPage.submitLogin("SamStark@gmail.com", "Sam12345");

		// Verify that the user is logged in successfully
		Assert.assertEquals(accountPage.getMyAccouuntText(), "My Account", "User is not logedin");
	}

	@Test
	public void validateUserCanNotLoginWithInValidPassword() {
		loginPage.submitLogin("SamStark@gmail.com", "Dany123@");

		// Verify that the user can not login
		Assert.assertEquals(loginPage.getDangerAlertText(), "Warning: No match for E-Mail Address and/or Password.",
				"User is logedin");
	}

	public void validateUserCanNotLoginWithInValidUsername() {
		loginPage.submitLogin("SamStarkgmail.com", "Sam12345");

		// Verify that the user can not login
		Assert.assertEquals(loginPage.getDangerAlertText(), "Warning: No match for E-Mail Address and/or Password.",
				"User is logedin");
	}

	@Test
	public void validateUserIsAbleToNavigateToForgottenPasswordPage() {
		forgottenPasswordPage = loginPage.clickForgottenPasswordPageLink();
		Assert.assertEquals(forgottenPasswordPage.getforgetPwdPageText(), "Forgot Your Password?",
				"Navigation to Forgotten Password Page Failed!!!");
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();

	}

}
