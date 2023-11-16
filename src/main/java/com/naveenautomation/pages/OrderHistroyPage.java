package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class OrderHistroyPage extends TestBase {

	public OrderHistroyPage() {
		PageFactory.initElements(wd, this);

	}
	@FindBy(xpath = "//h1[text()='Order History']")
	WebElement orderHistoryText;

	public String getOrderHistroyPageText() {
		return orderHistoryText.getText();
	}
}
