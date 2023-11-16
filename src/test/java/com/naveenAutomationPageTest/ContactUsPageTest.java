package com.naveenAutomationPageTest;

import org.testng.annotations.BeforeMethod;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.ContactUsPage;
import com.naveenautomation.pages.LoginPage;
import com.naveenautomation.pages.RegisterAccountPage;
import com.naveenautomation.pages.RegistrationSuccessPage;

public class ContactUsPageTest extends TestBase {
	LoginPage loginPage;
	ContactUsPage contactUsPage;

	RegisterAccountPage registerAccountPage;
	RegistrationSuccessPage registrationSuccessPage;

	@BeforeMethod
	public void launchBrowser() {
		initialise();
		loginPage = new LoginPage();

	}

	// validating location
	
}
