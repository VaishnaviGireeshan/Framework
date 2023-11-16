package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class ReturnsPage extends TestBase {

	public ReturnsPage() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "#content>h1")
	WebElement viewProductReturnsPageText;

	@FindBy(xpath = "//a[text()='Continue']")
	WebElement productReturnsContinueBtn;

	public String getViewProductReturnsPageText() {
		return viewProductReturnsPageText.getText();

	}

	public AccountPage clickProductReturnsContinueBtn() {
		productReturnsContinueBtn.click();
		return new AccountPage();
	}

}
