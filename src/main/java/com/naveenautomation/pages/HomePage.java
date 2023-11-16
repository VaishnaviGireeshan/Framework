package com.naveenautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.base.TestBase;

public class HomePage extends TestBase {

	public HomePage() {
		PageFactory.initElements(wd, this);

	}

	@FindBy(css = "#slideshow0 > div")
	WebElement homePageSlideShow;
	@FindBy(css = "ul.dropdown-menu-right>li:first-of-type>a")
	WebElement registrationLink;
	@FindBy(css = "span.hidden")
	WebElement myAcLink;

	public boolean isSlideShowDisplayed() {
		return homePageSlideShow.isDisplayed();

	}

//	public RegisterAccountPage navigateToRegisterAcPage(ConsumerHomeTopNavigationBar homeTopNavItem ) {
//		selectingItemFromHomeTopConsumerNav(homeTopNavItem);
//		return new RegisterAccountPage();
//	}
	public RegisterAccountPage navigateToRegisterAcPage() {
		myAcLink.click();
		registrationLink.click();
		return new RegisterAccountPage();

	}

}
