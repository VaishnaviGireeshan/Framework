package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class LoginPage extends TestBase {

	public LoginPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(id = "input-email")
	WebElement emailInput;

	@FindBy(id = "input-password")
	WebElement pwdInput;

	@FindBy(css = "input[value='Login']")
	WebElement clickBtn;

	@FindBy(css = "div.alert-danger ")
	WebElement dangerAlertText;

	@FindBy(css = "div.alert-success")
	WebElement successAlertText;

	@FindBy(xpath = "//a[text()='Forgotten Password'][1]")
	WebElement forgottenPwLink;

	@FindBy(xpath = "//a[text()='Continue']")
	WebElement registerAcBtn;

	@FindBy(xpath = "//a[text()='Continue']")
	WebElement continueButton;

/// Method to enter an email in the email input field
	public void enterEmail(String email) {
		emailInput.sendKeys(email);
	}

	// Method to enter a password in the password input field
	public void enterpwd(String password) {
		pwdInput.sendKeys(password);
	}

	public AccountPage submitLogin(String email, String password) {
		enterEmail(email);
		enterpwd(password);
		clickBtn.click();
		return new AccountPage();
	}

	public String getSuccessAlertText() {
		return successAlertText.getText();
	}

	public String getDangerAlertText() {
		return dangerAlertText.getText();
	}

	public ForgottenPasswordPage clickForgottenPasswordPageLink() {
		forgottenPwLink.click();
		return new ForgottenPasswordPage();
	}

	public RegisterAccountPage clickRegisterAcBtn() {

		registerAcBtn.click();

		return new RegisterAccountPage();
	}

	public RegisterAccountPage clickContinueBtn() {
		continueButton.click();
		return new RegisterAccountPage();
	}
}
