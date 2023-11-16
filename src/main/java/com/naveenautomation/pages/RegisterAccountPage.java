package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class RegisterAccountPage extends TestBase {

	public RegisterAccountPage() {
		PageFactory.initElements(wd, this);

	}

	@FindBy(id = "input-firstname")
	WebElement inputFirstName;

	@FindBy(id = "input-lastname")
	WebElement inputLastName;
	@FindBy(id = "input-email")
	WebElement inputEmail;

	@FindBy(id = "input-telephone")
	WebElement inputTelephone;

	@FindBy(id = "input-password")
	WebElement inputPassword;

	@FindBy(id = "input-confirm")
	WebElement inputConfirmPassword;

	@FindBy(css = "input[type='checkbox']")
	WebElement privacyPolicyCheckBox;

	@FindBy(css = "input[value='Continue']")
	WebElement continueBtn;

	@FindBy(css = "#content > h1")
	WebElement registerAccountText;

	@FindBy(css = "div.text-danger")
	WebElement warningText;

	@FindBy(css = "div.alert-danger")
	WebElement alertText;

	@FindBy(css = "input[value='Continue']")
	WebElement submitBtn;

	@FindBy(css = "ul.dropdown-menu-right>li:first-of-type>a")
	WebElement registrationLink;

	

	public void enterFirstName(String firstName) {
		inputFirstName.sendKeys(firstName);
	}

	public void enterLastName(String lastName) {
		inputLastName.sendKeys(lastName);
	}

	public void enterEmail(String email) {
		inputEmail.sendKeys(email);

	}

	public void enterTelephone(String telephone) {
		inputTelephone.sendKeys(telephone);

	}

	public void enterPassword(String password) {
		inputPassword.sendKeys(password);
	}

	public void enterConfirmPassword(String confirmPassword) {
		inputConfirmPassword.sendKeys(confirmPassword);
	}

	public void checkPrivacyPolicyCheckBox() {
		privacyPolicyCheckBox.click();

	}

	public RegisterAccountPage clickContinueBtn() {
		continueBtn.click();
		return new RegisterAccountPage();
	}

	public RegistrationSuccessPage clickSubmitBtn() {
		submitBtn.click();
		return new RegistrationSuccessPage();
	}

	public String getRegisterAccountText() {
		return registerAccountText.getText();
	}

	public String getWarningText() {
		return warningText.getText();
	}

	public String getAlertText() {
		return alertText.getText();
	}

}
