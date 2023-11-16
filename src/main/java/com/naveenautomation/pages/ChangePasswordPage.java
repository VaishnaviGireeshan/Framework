package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class ChangePasswordPage extends TestBase {

	public ChangePasswordPage() {
		PageFactory.initElements(wd, this);

	}

	// Locate and map web elements in the HTML page to corresponding WebElement
	// fields in the class.

	@FindBy(id = "input-password")
	WebElement passwordInput;

	@FindBy(id = "input-confirm")
	WebElement confirmPasswordInput;

	@FindBy(css = "input[type='submit']")
	WebElement changePwSubmitBtn;

	public void enterPassword(String password) {
		passwordInput.sendKeys(password);
	}

	public void enterConfirmPassword(String confirmPassword) {
		confirmPasswordInput.sendKeys(confirmPassword);
	}

	public AccountPage clickPwContinueBtn() {
		changePwSubmitBtn.click();
		return new AccountPage();
	}

}
