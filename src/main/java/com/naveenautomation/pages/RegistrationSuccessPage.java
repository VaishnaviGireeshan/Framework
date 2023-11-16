package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class RegistrationSuccessPage extends TestBase {

	public RegistrationSuccessPage() {
		PageFactory.initElements(wd, this);

	}

	@FindBy(css = "#content > h1")
	WebElement registerAccountSuccessText;

	@FindBy(xpath = "//a[text()='contact us']")
	WebElement contactUsLink;

	public String getRegisterAccountSuccessText() {
		return registerAccountSuccessText.getText();
	}

	public ContactUsPage clickContactUsLink() {
		contactUsLink.click();
		return new ContactUsPage();
	}

}
