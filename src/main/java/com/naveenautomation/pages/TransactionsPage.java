package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class TransactionsPage extends TestBase {

	public TransactionsPage() {
		PageFactory.initElements(wd, this);

	}
	@FindBy(xpath = "//h1[text()='Your Transactions']")
	WebElement transactionsPageText;

	public String getTransactionsPageText() {
		return transactionsPageText.getText();
	}
}
