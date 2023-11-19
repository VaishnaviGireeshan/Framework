package com.naveenAutomationPageTest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.ContactUsPage;
import com.naveenautomation.pages.LoginPage;
import com.naveenautomation.pages.RegisterAccountPage;
import com.naveenautomation.pages.RegistrationSuccessPage;

public class RegisterAccountSuccessPageTest extends TestBase {
	LoginPage loginPage;
	AccountPage accountPage;
	RegisterAccountPage registerAccountPage;
	RegistrationSuccessPage registrationSuccessPage;
	ContactUsPage contactUsPage;

	@BeforeMethod
	public void launchBrowser() {
		initialise();
		loginPage = new LoginPage();

	}

	@Test(enabled = false)
	public void validateUserCanNavigateBackToToLoginPage() {

		registerAccountPage = loginPage.clickContinueBtn();
		
		Assert.assertEquals(registrationSuccessPage.getRegisterAccountSuccessText(), "Your Account Has Been Created!",
				"Navigation to Register Account Success Page Failed!!!");
	}

	public void validateUserCanNavigateToContactUsPage() {
		registerAccountPage = loginPage.clickRegisterAcBtn();
		contactUsPage = registrationSuccessPage.clickContactUsLink();
		Assert.assertEquals(contactUsPage.getContactUsText(), "Contact Us", "Navigation to Contact Us Page Failed!!!");
	}
}
