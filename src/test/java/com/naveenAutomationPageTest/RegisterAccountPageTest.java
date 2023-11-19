package com.naveenAutomationPageTest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.base.TestBase;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.HomePage;
import com.naveenautomation.pages.LoginPage;
import com.naveenautomation.pages.RegisterAccountPage;
import com.naveenautomation.pages.RegistrationSuccessPage;

public class RegisterAccountPageTest extends TestBase {
	LoginPage loginPage;
	AccountPage accountPage;
	RegisterAccountPage registerAccountPage;
	RegistrationSuccessPage registrationSuccessPage;
	HomePage homepage;

	@BeforeMethod
	public void launchBrowser() {
		initialise();
		loginPage = new LoginPage();
	}

	@Test

	public void validateUserCanNavigateToRegisterAccount() {
		registerAccountPage = loginPage.clickRegisterAcBtn();

		Assert.assertEquals(registerAccountPage.getRegisterAccountText(), "Register Account",
				"User is not navigated to Register Account Page");
	}

	@Test(enabled = false)
	public void validateUserIsAbleToRegisterWithValidInfo() {
		registerAccountPage = loginPage.clickRegisterAcBtn();

		registerAccountPage.enterFirstName("Jeny");
		registerAccountPage.enterLastName("Doe");
		registerAccountPage.enterEmail("Jeny.doe@example.com");
		registerAccountPage.enterTelephone("1234567878");
		registerAccountPage.enterPassword("Lilly.doeE");
		registerAccountPage.enterConfirmPassword("Lilly.doeE");
		registerAccountPage.checkPrivacyPolicyCheckBox();

		registrationSuccessPage = registerAccountPage.clickSubmitBtn();
		Assert.assertEquals(registrationSuccessPage.getRegisterAccountSuccessText(), "Your Account Has Been Created!",
				"User is not Able To Register With Valid Info");
	}

	@Test(enabled = false)
	public void validateUserCanNotSkipFirstName() {
		registerAccountPage = loginPage.clickRegisterAcBtn();
		registerAccountPage.enterLastName("Tomi");
		registerAccountPage.enterEmail("Tom.doe@example.com");
		registerAccountPage.enterTelephone("1134567890");
		registerAccountPage.enterPassword("Tom.doe");
		registerAccountPage.enterConfirmPassword("Tom.doe");
		registerAccountPage.checkPrivacyPolicyCheckBox();
		registerAccountPage.clickContinueBtn();
		Assert.assertEquals(registerAccountPage.getWarningText(), "First Name must be between 1 and 32 characters!",
				"User successfully skipped First Name. Validation failed.");
	}

	@Test(enabled = false)
	public void validateUserCanNotEnterInvalidFirstName() {
		registerAccountPage = loginPage.clickRegisterAcBtn();
		registerAccountPage.enterFirstName("Tomnnnnneeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		registerAccountPage.enterLastName("Doe");
		registerAccountPage.enterEmail("Tom.doe@example.com");
		registerAccountPage.enterTelephone("1134567890");
		registerAccountPage.enterPassword("Tom.doe");
		registerAccountPage.enterConfirmPassword("Tom.doe");
		registerAccountPage.checkPrivacyPolicyCheckBox();
		registerAccountPage.clickContinueBtn();
		Assert.assertEquals(registerAccountPage.getWarningText(), "First Name must be between 1 and 32 characters!",
				"User successfully skipped First Name. Validation failed.");
	}

	@Test(enabled = false)
	public void validateUserCanNotEnterInvalidLastName() {
		registerAccountPage = loginPage.clickRegisterAcBtn();
		registerAccountPage.enterFirstName("Tom");
		registerAccountPage.enterLastName("DoeDoeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
		registerAccountPage.enterEmail("Tom.doe@example.com");
		registerAccountPage.enterTelephone("1134567890");
		registerAccountPage.enterPassword("Tom.doe");
		registerAccountPage.enterConfirmPassword("Tom.doe");
		registerAccountPage.checkPrivacyPolicyCheckBox();
		registerAccountPage.clickContinueBtn();
		Assert.assertEquals(registerAccountPage.getWarningText(), "Last Name must be between 1 and 32 characters!",
				"User successfully skipped First Name. Validation failed.");
	}

	@Test
	public void validateUserCanNotSkipLastName() {
		registerAccountPage = loginPage.clickRegisterAcBtn();

		registerAccountPage.enterFirstName("Tom");
		registerAccountPage.enterEmail("Tom.doe@example.com");
		registerAccountPage.enterTelephone("1134567890");
		registerAccountPage.enterPassword("Tom.doe");
		registerAccountPage.enterConfirmPassword("Tom.doe");
		registerAccountPage.checkPrivacyPolicyCheckBox();
		registerAccountPage.clickContinueBtn();
		Assert.assertEquals(registerAccountPage.getWarningText(), "Last Name must be between 1 and 32 characters!",
				"User successfully skipped Last Name. Validation failed.");

	}

	@Test
	public void validateUserCanNotSkipEmail() {
		registerAccountPage = loginPage.clickRegisterAcBtn();
		registerAccountPage.enterFirstName("Tom");
		registerAccountPage.enterLastName("Doe");
		registerAccountPage.enterTelephone("1134567890");
		registerAccountPage.enterPassword("Tom.doe");
		registerAccountPage.enterConfirmPassword("Tom.doe");
		registerAccountPage.checkPrivacyPolicyCheckBox();
		registerAccountPage.clickContinueBtn();
		Assert.assertEquals(registerAccountPage.getWarningText(), "E-Mail Address does not appear to be valid!",
				"User successfully skipped Email. Validation failed.");
	}

	@Test
	public void validateUserCanNotEnterInvalidTelephone() {
		registerAccountPage = loginPage.clickRegisterAcBtn();

		registerAccountPage.enterFirstName("Tom");
		registerAccountPage.enterLastName("Doe");
		registerAccountPage.enterEmail("Tom.doe@example.com");

		registerAccountPage.enterPassword("Tom.doe");
		registerAccountPage.enterConfirmPassword("Tom.doe");
		registerAccountPage.checkPrivacyPolicyCheckBox();
		registerAccountPage.clickContinueBtn();
		Assert.assertEquals(registerAccountPage.getWarningText(), "Telephone must be between 3 and 32 characters!",
				"User successfully skipped Telephone. Validation failed.");
	}

	@Test
	public void validateUserCanNotSkipPassword() {
		registerAccountPage = loginPage.clickRegisterAcBtn();

		registerAccountPage.enterFirstName("Tom");
		registerAccountPage.enterLastName("Doe");
		registerAccountPage.enterEmail("Tom.doe@example.com");
		registerAccountPage.enterTelephone("1134567890");
		registerAccountPage.enterConfirmPassword("Tom.doe");
		registerAccountPage.checkPrivacyPolicyCheckBox();
		registerAccountPage.clickContinueBtn();
		Assert.assertEquals(registerAccountPage.getWarningText(), "Password must be between 4 and 20 characters!",
				"User successfully skipped Password. Validation failed.");
	}

	@Test
	public void validateUserCanNotSkipConfirmPassword() {
		registerAccountPage = loginPage.clickRegisterAcBtn();
		registerAccountPage.enterFirstName("Tom");
		registerAccountPage.enterLastName("Doe");
		registerAccountPage.enterEmail("Tom.doe@example.com");
		registerAccountPage.enterTelephone("1134567890");
		registerAccountPage.enterPassword("Tom.doe");
		registerAccountPage.checkPrivacyPolicyCheckBox();
		registerAccountPage.clickContinueBtn();
		Assert.assertEquals(registerAccountPage.getWarningText(), "Password confirmation does not match password!",
				"User successfully skipped Confirm Password. Validation failed.");
	}

	@Test(enabled = false)
	public void validateUserCheckEDPrivacyPolicyCheckBox() {
		registerAccountPage = loginPage.clickRegisterAcBtn();

		registerAccountPage.enterFirstName("Tomi");
		registerAccountPage.enterLastName("Doe");
		registerAccountPage.enterEmail("Tom.doee@example.com");
		registerAccountPage.enterTelephone("1134567890");
		registerAccountPage.enterPassword("Tom.doe");
		registerAccountPage.enterConfirmPassword("Tom.doe");
		registerAccountPage.clickContinueBtn();
		Assert.assertEquals(registerAccountPage.getAlertText(), "Warning: You must agree to the Privacy Policy!",
				"User successfully skipped Privacy PolicyCheck Box. Validation failed.");
	}

	

}
