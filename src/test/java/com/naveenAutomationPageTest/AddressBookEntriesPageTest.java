package com.naveenAutomationPageTest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.Utils.Utils;
import com.naveenautomation.base.TestBase;
import com.naveenautomation.navigationBars.ConsumerSideNavigationBar;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.AddressBookPage;
import com.naveenautomation.pages.LoginPage;

public class AddressBookEntriesPageTest extends TestBase {

	LoginPage loginPage;
	AccountPage accountPage;
	AddressBookPage addressBookEntriesPage;

	@BeforeMethod
	public void launchBrowser() {
		initialise();
		loginPage = new LoginPage();
	}

	@Test(enabled = false)

	public void validateUserCanNavigateToAddressBook() {

		accountPage = loginPage.submitLogin("SamStark@gmail.com", "Sam12345");
		addressBookEntriesPage = accountPage.navigateAddressBook(ConsumerSideNavigationBar.ADDRESS_BOOK);
		Assert.assertEquals(addressBookEntriesPage.getaddressBookEntriesPageText(), "Address Book Entries",

				"Navigation to address book page failed!!!");

	}

	@Test(enabled = false)

	public void validateUserCanAddNewAddressToAddressBook() {

		accountPage = loginPage.submitLogin("SamStark@gmail.com", "Sam12345");
		addressBookEntriesPage = accountPage.navigateAddressBook(ConsumerSideNavigationBar.ADDRESS_BOOK);

		addressBookEntriesPage.clickAddNewAddress();

		addressBookEntriesPage.enterFirstName("Jon");

		addressBookEntriesPage.enterLastName("Snow");

		addressBookEntriesPage.enterAddress("The Great Wall");

		addressBookEntriesPage.enterCity("Woodstock");

		addressBookEntriesPage.enterPostcode("l6t 2a2");

		addressBookEntriesPage.selectCountry("Canada");
		Utils.sleep(5000);

		addressBookEntriesPage.selectRegion("Ontario");

		// Click Continue button

		addressBookEntriesPage.clickContinueBtn();

		Assert.assertEquals(addressBookEntriesPage.getAddressAddedSuccessMsg(),
				"Your address has been successfully added",

				"User is not able to add new address to Address book!!!");

	}

}
