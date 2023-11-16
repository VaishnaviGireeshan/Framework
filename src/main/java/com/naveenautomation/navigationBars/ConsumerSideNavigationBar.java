package com.naveenautomation.navigationBars;



public enum ConsumerSideNavigationBar {
	MY_ACCOUNT("My Account"), EDIT_ACCOUNT("Edit Account"), PASSWORD("Password"), ADDRESS_BOOK("Address Book"),
	WISH_LIST("Wish List"), ORDER_HISTORY("Order History"), DOWNLODS("Downloads"),
	RECURRING_PAYMENTS("Recurring payments"), REWARD_POINTS("Reward Points"), RETURNS("Returns"),
	TRANSACTIONS("Transactions"), NEWSLETTER("Newsletter"), LOGOUT("Logout");

	public String item;

	ConsumerSideNavigationBar(String item) {

		this.item = item;
	}

	public String getItem() {
		return item;
	}

}
