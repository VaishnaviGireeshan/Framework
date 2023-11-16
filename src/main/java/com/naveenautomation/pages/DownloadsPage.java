package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class DownloadsPage extends TestBase {

	public DownloadsPage() {
		PageFactory.initElements(wd, this);

	}

	@FindBy(xpath = "//h2[text()='Account Downloads']")
	WebElement downloadsPageText;

	public String getDownloadsPageText() {
		return downloadsPageText.getText();
	}
}
