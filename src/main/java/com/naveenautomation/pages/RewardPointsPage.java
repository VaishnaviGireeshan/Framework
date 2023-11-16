package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class RewardPointsPage extends TestBase {

	public RewardPointsPage() {
		PageFactory.initElements(wd, this);

	}

	@FindBy(xpath = "//h1[text()='Your Reward Points']")
	WebElement rewardPointsPagePageText;

	public String getRewardPointsPageText() {
		return rewardPointsPagePageText.getText();
	}

}
