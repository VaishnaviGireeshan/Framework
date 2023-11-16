package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class NewsLetterSubscriptionPage extends TestBase {

	public NewsLetterSubscriptionPage() {
		PageFactory.initElements(wd, this);

	}

	@FindBy(css = "#content>h1")
	WebElement newsLetterSubsriptionPageText;

	@FindBy(css = "label.radio-inline:first-of-type>input")
	WebElement newsLetterSubsriptionYesOption;

	@FindBy(css = "input[value='Continue']")
	WebElement newsLetterSubscriptionSubmitBtn;

	public String getNewsLetterSubsriptionPageText() {
		return newsLetterSubsriptionPageText.getText();

	}

	public void clickYesOption() {
		newsLetterSubsriptionYesOption.click();

	}

	public AccountPage clickNewsLetterSubscriptionSubmitBtn() {
		newsLetterSubscriptionSubmitBtn.click();
		return new AccountPage();
	}

}
