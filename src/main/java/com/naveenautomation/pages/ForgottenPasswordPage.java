package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class ForgottenPasswordPage extends TestBase {

	public ForgottenPasswordPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(xpath = "//h1[text()='Forgot Your Password?']")
	WebElement forgetPwdPageText;

	@FindBy(css = "#input-email")
	WebElement emailInput;

	@FindBy(css = "input[value='Continue']")
	WebElement continueBtn;

	@FindBy(css = "#account-login>div.alert-success>i")
	WebElement forgettenPwdSuccessMessage;

	@FindBy(css = "#account-forgotten>div.alert-danger>i")
	WebElement forgettenPwdFailedMessage;

	// Method to get the text of 'Forgot Your Password?'
	public String getforgetPwdPageText() {
		return forgetPwdPageText.getText();
	}

	// Method to enter email in the email input field
	public void enterEmail(String email) {
		emailInput.sendKeys(email);
	}

	// Method to click the 'Continue' button
	public LoginPage clickContinueBtnWithVaidEmail() {
		continueBtn.click();
		return new LoginPage();
	}

	public void clickContinueBtn() {
		continueBtn.click();

	}

	// Method to get the text of the message for forgotten password failure
	public String getforgettenPwdFailedMessage() {
		return forgettenPwdFailedMessage.getText();
	}

	public String getForgettenPwdSuccessMessage() {
		return forgettenPwdSuccessMessage.getText();
	}
}
