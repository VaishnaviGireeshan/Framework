package com.naveenAutomationPageTest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.naveenautomation.base.TestBase;
import com.naveenautomation.navigationBars.ConsumerSideNavigationBar;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.EditAccountPage;
import com.naveenautomation.pages.LoginPage;

public class EditAccountPageTest extends TestBase {
	LoginPage loginPage;
	AccountPage accountPage;
	EditAccountPage editAccountPage;

	@BeforeMethod
	public void launchBrowser() {
		initialise();
		loginPage = new LoginPage();
	}

	@Test
	public void validateUserCanNotSkipFirstName() {
		accountPage = loginPage.submitLogin("SamStark@gmail.com", "Sam12345");
		editAccountPage = accountPage.clickEditUserInfo(ConsumerSideNavigationBar.EDIT_ACCOUNT);
		editAccountPage.clearAllFields();
		// editAccountPage.clearField(editAccountPage.firstNameInput);
		editAccountPage.enterLastName("stark");
		editAccountPage.enterEmail("SamStark@gmail.com");
		editAccountPage.enterTelephoneNum("1122334455");
		editAccountPage.clickSubmitBtn();
		Assert.assertEquals(editAccountPage.getWarningMsg(), "First Name must be between 1 and 32 characters!",
				"User successfully skipped First Name. Validation failed!!!");

	}

	@Test
	public void validateFirstNameCharactersAreWithinRange() {
		accountPage = loginPage.submitLogin("SamStark@gmail.com", "Sam12345");
		editAccountPage = accountPage.clickEditUserInfo(ConsumerSideNavigationBar.EDIT_ACCOUNT);
		editAccountPage.clearAllFields();
		editAccountPage.enterFirstName("iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
		editAccountPage.enterLastName("stark");
		editAccountPage.enterEmail("SamStark@gmail.com");
		editAccountPage.enterTelephoneNum("1122334455");
		editAccountPage.clickSubmitBtn();
		Assert.assertEquals(editAccountPage.getWarningMsg(), "First Name must be between 1 and 32 characters!",
				"User Entered invalid first name. Validation failed!!!");

	}

	@Test
	public void validateUserCanNotSkipLastName() {
		accountPage = loginPage.submitLogin("SamStark@gmail.com", "Sam12345");
		editAccountPage = accountPage.clickEditUserInfo(ConsumerSideNavigationBar.EDIT_ACCOUNT);
		editAccountPage.clearAllFields();
		editAccountPage.enterFirstName("stark");
		editAccountPage.enterEmail("SamStark@gmail.com");
		editAccountPage.enterTelephoneNum("1122334455");
		editAccountPage.clickSubmitBtn();
		Assert.assertEquals(editAccountPage.getWarningMsg(), "Last Name must be between 1 and 32 characters!",
				"User successfully skipped Last Name. Validation failed!!!");

	}

	@Test
	
		public void validateLastNameCharactersAreWithinRange() {
		accountPage = loginPage.submitLogin("SamStark@gmail.com", "Sam12345");
		editAccountPage = accountPage.clickEditUserInfo(ConsumerSideNavigationBar.EDIT_ACCOUNT);
		editAccountPage.clearAllFields();
		editAccountPage.enterFirstName("Sam");
		editAccountPage.enterLastName("iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
		editAccountPage.enterEmail("SamStark@gmail.com");
		editAccountPage.enterTelephoneNum("1122334455");
		editAccountPage.clickSubmitBtn();
		Assert.assertEquals(editAccountPage.getWarningMsg(), "Last Name must be between 1 and 32 characters!",
				"User Entered invalid last name. Validation failed!!!");

	}
	@Test
	public void validateUserCanNotSkipEmail() {
		accountPage = loginPage.submitLogin("SamStark@gmail.com", "Sam12345");
		editAccountPage = accountPage.clickEditUserInfo(ConsumerSideNavigationBar.EDIT_ACCOUNT);
		editAccountPage.clearAllFields();
		editAccountPage.enterFirstName("Sam");
		editAccountPage.enterLastName("stark");
		
		editAccountPage.enterTelephoneNum("1122334455");
		editAccountPage.clickSubmitBtn();
		Assert.assertEquals(editAccountPage.getWarningMsg(), "E-Mail Address does not appear to be valid!",
				"User successfully skipped Email. Validation failed!!!");

	}
	
}
