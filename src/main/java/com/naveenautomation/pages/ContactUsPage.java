package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class ContactUsPage extends TestBase {

	public ContactUsPage() {
		PageFactory.initElements(wd, this);

	}

	@FindBy(css = "#content>h1")
	WebElement contactUsText;

	@FindBy(css = "#content>div>div>div>div>address")
	WebElement address;

	public String getContactUsText() {
		return contactUsText.getText();
	}

	public String getAddress() {
		return address.getText();
	}

}
