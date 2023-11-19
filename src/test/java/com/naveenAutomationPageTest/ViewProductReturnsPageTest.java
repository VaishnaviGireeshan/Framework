package com.naveenAutomationPageTest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.naveenautomation.base.TestBase;
import com.naveenautomation.navigationBars.ConsumerSideNavigationBar;
import com.naveenautomation.pages.AccountPage;
import com.naveenautomation.pages.LoginPage;
import com.naveenautomation.pages.ReturnsPage;

public class ViewProductReturnsPageTest extends TestBase {
	LoginPage loginPage;
	AccountPage accountPage;
	ReturnsPage viewProductReturnsPage;

	@BeforeMethod
	public void launchBrowser() {
		initialise();
		loginPage = new LoginPage();

	}

	@Test(enabled = false)
	public void validateNavigationToViewProductReturnsPage() {
		accountPage = loginPage.submitLogin("SamStark@gmail.com", "Sam12345");
		viewProductReturnsPage = accountPage.clickProductReturns(ConsumerSideNavigationBar.RETURNS);
		Assert.assertEquals(viewProductReturnsPage.getViewProductReturnsPageText(), "Product Returns",
				"NavigationToViewProductReturnsPage Failed!!!");

	}

	@Test(enabled = false)
	public void validateNavigationBackToAccountPage() {
		accountPage = loginPage.submitLogin("SamStark@gmail.com", "Sam12345");
		viewProductReturnsPage = accountPage.clickProductReturns(ConsumerSideNavigationBar.RETURNS);
		accountPage = viewProductReturnsPage.clickProductReturnsContinueBtn();
		Assert.assertEquals(accountPage.getMyAccouuntText(), "My Account", "Navigation Back To AccountPage Failed!!!");
	}
}
