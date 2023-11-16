package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class LogoutPage extends TestBase {

	public LogoutPage() {
		PageFactory.initElements(wd, this);

	}

	@FindBy(css = "#content>p")
	WebElement logoutMsg;

	@FindBy(css = "#content > div > div > a")
	WebElement logoutSubmitBtn;

	public String getLogoutSafelyMsg() {
		return logoutMsg.getText();
	}

	public HomePage clickContinueBtn() {
		logoutSubmitBtn.click();

		return new HomePage();
	}

}
