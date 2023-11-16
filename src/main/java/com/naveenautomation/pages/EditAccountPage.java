package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class EditAccountPage extends TestBase {

	public EditAccountPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "input[name='firstname']")
	public WebElement firstNameInput;

	@FindBy(css = "input[name='lastname']")
	WebElement lastNameInput;

	@FindBy(css = "input[name='email']")
	WebElement emailInput;

	@FindBy(css = "input[name='telephone']")
	WebElement telephoneInput;

	@FindBy(css = "input[type='submit']")
	WebElement submitBtn;

	@FindBy(css = "div.text-danger")
	WebElement warningMsg;

	public void clearField(WebElement element) {
		element.clear();
	}

	public void clearAllFields() {
		firstNameInput.clear();
		lastNameInput.clear();
		emailInput.clear();
		telephoneInput.clear();
	}

	public void enterFirstName(String firstName) {
		firstNameInput.sendKeys(firstName);

	}

	public void enterLastName(String lastName) {
		lastNameInput.sendKeys(lastName);

	}

	public void enterEmail(String email) {
		emailInput.sendKeys(email);

	}

	public void enterTelephoneNum(String phoneNum) {
		telephoneInput.sendKeys(phoneNum);

	}

	public AccountPage clickSubmitBtn() {
		submitBtn.click();
		return new AccountPage();
	}

	public String getWarningMsg() {
		return warningMsg.getText();
	}

}
