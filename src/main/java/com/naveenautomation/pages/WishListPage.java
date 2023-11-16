package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class WishListPage extends TestBase {

	public WishListPage() {
		PageFactory.initElements(wd, this);

	}

	@FindBy(xpath = "//h2[text()='My Wish List']")
	WebElement wishListPageText;

	public String getWishListPageText() {
		return wishListPageText.getText();
	}
}
