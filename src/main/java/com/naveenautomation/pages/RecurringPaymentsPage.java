package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class RecurringPaymentsPage extends TestBase {

	public RecurringPaymentsPage() {
		PageFactory.initElements(wd, this);

	}

	@FindBy(xpath = "//h1[text()='Recurring Payments']")
	WebElement recurringPaymentsPageText;

	public String getRecurringPaymentsPageText() {
		return recurringPaymentsPageText.getText();
	}

}
