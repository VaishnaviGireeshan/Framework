package com.naveenAutomationPageTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.naveenautomation.base.TestBase;
import com.naveenautomation.navigationBars.ConsumerSideNavigationBar;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.AddressBookPage;
import com.naveenautomation.pages.ChangePasswordPage;
import com.naveenautomation.pages.DownloadsPage;
import com.naveenautomation.pages.EditAccountPage;
import com.naveenautomation.pages.LoginPage;
import com.naveenautomation.pages.NewsLetterSubscriptionPage;
import com.naveenautomation.pages.OrderHistroyPage;
import com.naveenautomation.pages.RecurringPaymentsPage;
import com.naveenautomation.pages.RewardPointsPage;
import com.naveenautomation.pages.TransactionsPage;
import com.naveenautomation.pages.WishListPage;

public class AccountPageTest extends TestBase {
	LoginPage loginPage;
	AccountPage accountPage;
	ChangePasswordPage changePasswordPage;
	EditAccountPage editAccountPage;
	NewsLetterSubscriptionPage newLetterSubscriptionPage;
	AddressBookPage addressBookPage;
	WishListPage wishListPage;
	OrderHistroyPage orderHistroyPage;
	DownloadsPage downloadsPage;
	RecurringPaymentsPage recurringPaymentsPage;
	RewardPointsPage rewardPointsPage;
	TransactionsPage transactionsPage;

	@BeforeMethod
	public void launchBrowser() {
		initialise();
		loginPage = new LoginPage();
	}

	@Test
	public void validateUserCanEditPersonalInfo() {
		// Login to the account
		accountPage = loginPage.submitLogin("SamStark@gmail.com", "Sam12345");

		// Click on the "Edit your account information" link
		editAccountPage = accountPage.clickEditUserInfo(ConsumerSideNavigationBar.EDIT_ACCOUNT);

		// Enter a sample data
		editAccountPage.enterFirstName("T");

		accountPage = editAccountPage.clickSubmitBtn();

		// Verify if the success message is displayed
		Assert.assertEquals(accountPage.getEditAccountInfoSuccessMsg(),
				"Success: Your account has been successfully updated.", "Personal Information update failed!!!");
	}

	@Test(enabled = false)
	public void validateUserCanChangePassword() {
		accountPage = (AccountPage) loginPage.submitLogin("SamStark@gmail.com", "Sam12345");

		// Click on the "Change Password" link

		changePasswordPage = accountPage.clickChangePasswordLink(ConsumerSideNavigationBar.PASSWORD);

		// Enter a new password and confirm it
		changePasswordPage.enterPassword("Sam12345");
		changePasswordPage.enterConfirmPassword("Sam12345");

		// Click the "Continue" button
		accountPage = changePasswordPage.clickPwContinueBtn();

		// Verify if the success message is displayed
		Assert.assertEquals(accountPage.getchangePasswordSuccessMsg(),
				"Success: Your password has been successfully updated.", "Password Not  Changed");

	}

	@Test(enabled = false)
	public void validateUserCanUpdateNewsLetterSubscription() {
		accountPage = loginPage.submitLogin("SamStark@gmail.com", "Sam12345");

		// Click on the "Subscribe to newsletter" link
		newLetterSubscriptionPage = accountPage.subscribeNewsLetter(ConsumerSideNavigationBar.NEWSLETTER);

		// Select the "Yes" option for newsletter subscription
		newLetterSubscriptionPage.clickYesOption();

		// Click the "Submit" button
		accountPage = newLetterSubscriptionPage.clickNewsLetterSubscriptionSubmitBtn();

		// Verify if the success message is displayed
		Assert.assertEquals(accountPage.getnewsLetterSubscriptionSuccessMsg(),
				"Success: Your newsletter subscription has been successfully updated!",
				"News letter Subscription update Failed!!!");
	}

	@Test(enabled = false)
	public void validateUserCanAccessAddressBook() {
		accountPage = loginPage.submitLogin("SamStark@gmail.com", "Sam12345");
		addressBookPage = accountPage.addressBook(ConsumerSideNavigationBar.ADDRESS_BOOK);
		Assert.assertEquals(addressBookPage.getaddressBookEntriesPageText(), "Address Book Entries",
				"Address Book Entries Page, Access Failed!!!");

	}

	@Test(enabled = false)
	public void validateUserCanUpdateWishList() {
		accountPage = loginPage.submitLogin("SamStark@gmail.com", "Sam12345");
		wishListPage = accountPage.wishList(ConsumerSideNavigationBar.WISH_LIST);
		Assert.assertEquals(wishListPage.getWishListPageText(), "My Wish List", "Wish List Page, Access Failed!!!");
	}

	@Test(enabled = false)
	public void validateUserCanAccessOrderHistory() {
		accountPage = loginPage.submitLogin("SamStark@gmail.com", "Sam12345");
		orderHistroyPage = accountPage.orderHistory(ConsumerSideNavigationBar.ORDER_HISTORY);
		Assert.assertEquals(orderHistroyPage.getOrderHistroyPageText(), "Order History",
				"Order History Page, Access Failed!!!");
	}

	@Test(enabled = false)
	public void validateUserCanAccessDownloadsPage() {
		accountPage = loginPage.submitLogin("SamStark@gmail.com", "Sam12345");
		downloadsPage = accountPage.downloadsPageLink(ConsumerSideNavigationBar.DOWNLODS);
		Assert.assertEquals(downloadsPage.getDownloadsPageText(), "Account Downloads",
				"Downloads Page, Access Failed!!!");
	}

	@Test(enabled = false)
	public void validateUserCanAccessRecurringPaymentsPage() {
		accountPage = loginPage.submitLogin("SamStark@gmail.com", "Sam12345");
		recurringPaymentsPage = accountPage.recurringPaymentsPageLink(ConsumerSideNavigationBar.RECURRING_PAYMENTS);
		Assert.assertEquals(recurringPaymentsPage.getRecurringPaymentsPageText(), "Recurring Payments",
				"Recurring Payments Page, Access Failed!!!");
	}

	@Test
	public void validateUserCanAccessRewardPointsPage() {
		accountPage = loginPage.submitLogin("SamStark@gmail.com", "Sam12345");
		rewardPointsPage = accountPage.rewardPointsPageLink(ConsumerSideNavigationBar.REWARD_POINTS);
		Assert.assertEquals(rewardPointsPage.getRewardPointsPageText(), "Your Reward Points",
				"Reward Points Page, Access Failed!!!");
	}

	@Test(enabled = false)
	public void validateUserCanAccessTransactionsPage() {
		accountPage = loginPage.submitLogin("SamStark@gmail.com", "Sam12345");
		transactionsPage = accountPage.transactionsPageLink(ConsumerSideNavigationBar.TRANSACTIONS);
		Assert.assertEquals(transactionsPage.getTransactionsPageText(), "Your Transactions",
				"Transactions Page, Access Failed!!!");
	}
	
	

	@AfterMethod
	public void quitBrowser() {
		tearDown();

	}

}
