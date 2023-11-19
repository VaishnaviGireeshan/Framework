package com.naveenAutomationPageTest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.naveenautomation.base.TestBase;
import com.naveenautomation.navigationBars.ConsumerSideNavigationBar;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.HomePage;
import com.naveenautomation.pages.LoginPage;
import com.naveenautomation.pages.LogoutPage;

public class LogoutPageTest extends TestBase {
	LogoutPage logoutPage;
	HomePage homePage;
	LoginPage loginPage;
	AccountPage accountPage;

	@BeforeMethod
	public void launchBrowser() {
		initialise();
		// Initialize the test by navigating to the login page
		loginPage = new LoginPage();
	}

	@Test(enabled = false)
	public void validateUserCanLogoutsafely() {
		// login using valid credentials
		accountPage = (AccountPage) loginPage.submitLogin("SamStark@gmail.com", "Sam12345");
		// Perform the logout action
		logoutPage = accountPage.clickLogoutLink(ConsumerSideNavigationBar.LOGOUT);
		// Verify that the user is logged out safely
		Assert.assertEquals(logoutPage.getLogoutSafelyMsg(),
				"You have been logged off your account. It is now safe to leave the computer.", "logout failed!!!");

		homePage = logoutPage.clickContinueBtn();

		// Verify that the user is navigated to homepage
		Assert.assertTrue(homePage.isSlideShowDisplayed(), "Logout Failed");
	}
	

}
