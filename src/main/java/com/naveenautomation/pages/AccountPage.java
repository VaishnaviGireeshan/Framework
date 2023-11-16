package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.naveenautomation.base.TestBase;
import com.naveenautomation.navigationBars.ConsumerSideNavigationBar;

public class AccountPage extends TestBase {

	public AccountPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement myAccountText;

	@FindBy(css = "div[class='alert alert-success alert-dismissible']")
	WebElement successAlert;

	// Locate and map web elements in the HTML page to corresponding WebElement
	// fields in the class.
	// methods to interact with these elements

	public String getMyAccouuntText() {
		return myAccountText.getText();
	}

	public EditAccountPage clickEditUserInfo(ConsumerSideNavigationBar itemSelected) {
		selectingItemFromConsumerSideNav(itemSelected);
		return new EditAccountPage();
	}

	public ChangePasswordPage clickChangePasswordLink(ConsumerSideNavigationBar itemSelected) {
		selectingItemFromConsumerSideNav(itemSelected);
		return new ChangePasswordPage();
	}

	public AddressBookPage addressBook(ConsumerSideNavigationBar itemSelected) {
		selectingItemFromConsumerSideNav(itemSelected);
		return new AddressBookPage();
	}

	public NewsLetterSubscriptionPage subscribeNewsLetter(ConsumerSideNavigationBar itemSelected) {
		selectingItemFromConsumerSideNav(itemSelected);
		return new NewsLetterSubscriptionPage();
	}

	public AddressBookPage navigateAddressBook(ConsumerSideNavigationBar itemSelected) {
		selectingItemFromConsumerSideNav(itemSelected);
		return new AddressBookPage();
	}

	public LogoutPage clickLogoutLink(ConsumerSideNavigationBar itemSelected) {
		selectingItemFromConsumerSideNav(itemSelected);

		return new LogoutPage();

	}

	public ReturnsPage clickProductReturns(ConsumerSideNavigationBar itemSelected) {
		selectingItemFromConsumerSideNav(itemSelected);

		return new ReturnsPage();
	}

	public WishListPage wishList(ConsumerSideNavigationBar itemSelected) {
		selectingItemFromConsumerSideNav(itemSelected);
		return new WishListPage();
	}

	public OrderHistroyPage orderHistory(ConsumerSideNavigationBar itemSelected) {
		selectingItemFromConsumerSideNav(itemSelected);
		return new OrderHistroyPage();
	}

	public DownloadsPage downloadsPageLink(ConsumerSideNavigationBar itemSelected) {
		selectingItemFromConsumerSideNav(itemSelected);
		return new DownloadsPage();
	}

	public RecurringPaymentsPage recurringPaymentsPageLink(ConsumerSideNavigationBar itemSelected) {
		selectingItemFromConsumerSideNav(itemSelected);
		return new RecurringPaymentsPage();
	}

	public RewardPointsPage rewardPointsPageLink(ConsumerSideNavigationBar itemSelected) {
		selectingItemFromConsumerSideNav(itemSelected);
		return new RewardPointsPage();
	}

	public TransactionsPage transactionsPageLink(ConsumerSideNavigationBar itemSelected) {
		selectingItemFromConsumerSideNav(itemSelected);
		return new TransactionsPage();
	}

	public String getEditAccountInfoSuccessMsg() {
		return successAlert.getText();

	}

	public String getchangePasswordSuccessMsg() {
		return successAlert.getText();
	}

	public String getnewsLetterSubscriptionSuccessMsg() {
		return successAlert.getText();
	}

}
