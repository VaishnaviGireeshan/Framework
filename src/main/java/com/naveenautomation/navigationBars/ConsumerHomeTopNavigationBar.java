package com.naveenautomation.navigationBars;

public enum ConsumerHomeTopNavigationBar {
	
		MY_ACCOUNT("My Account"), 
		WISH_LIST("Wish List"), 
		SHOPPING_CART("Shopping Cart"), 
		CHECKOUT("Checkout");

		public String homeTopNavItem;

		ConsumerHomeTopNavigationBar(String homeTopNavItem) {

			this.homeTopNavItem = homeTopNavItem;
		}

		public String getItem() {
			return homeTopNavItem;
		}
	}

