package com.naveenautomation.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;


import com.naveenautomation.Utils.WebdriverEvents;
import com.naveenautomation.browsers.Browser;
import com.naveenautomation.environment.Environment;
import com.naveenautomation.navigationBars.ConsumerHomeTopNavigationBar;
import com.naveenautomation.navigationBars.ConsumerSideNavigationBar;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver wd; // should remain same for the whole project
	private final Browser BROWSER = Browser.CHROME;
	private final Environment URL = Environment.PROD;
	public static Logger logger;
	public WebdriverEvents events;
	public EventFiringWebDriver e_driver;
	private static final boolean RUN_ON_GRID = false;

	@BeforeClass
	public void loggerSetup() {// one time setup
		logger = Logger.getLogger(TestBase.class);// initializing the logger
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		logger.setLevel(Level.INFO);

	}

	public void initialise() {

		if (RUN_ON_GRID) {
			try {
				wd = new RemoteWebDriver(new URL("http://192.168.137.1:5555"), getOptions());
			} catch (MalformedURLException e) {

				e.printStackTrace();
			}
		} else {

			switch (BROWSER) {
			case CHROME:
				wd = WebDriverManager.chromedriver().create();
				break;
			case EDGE:
				wd = WebDriverManager.edgedriver().create();
				break;
			case FIREFOX:
				wd = WebDriverManager.firefoxdriver().create();
				break;

			default:
				throw new IllegalArgumentException();
			}
		}
		// Wrap the instance
		e_driver = new EventFiringWebDriver(wd);

		// Events which need to be captured
		events = new WebdriverEvents();
		e_driver.register(events);

		// Assigning back the value to Web driver
		wd = e_driver;

		// Loading the Page
		wd.get(URL.getUrl());
		wd.manage().window().maximize();
		wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wd.manage().deleteAllCookies();

	}

	public MutableCapabilities getOptions() {
		return new ManageOptions().getOption(BROWSER);
	}

	public void selectingItemFromConsumerSideNav(ConsumerSideNavigationBar itemSelected) {
		List<WebElement> item = wd.findElements(By.cssSelector("div.list-group>a"));
		for (int i = 0; i < item.size(); i++) {
			if (item.get(i).getText().toString().equals(itemSelected.getItem())) {
				item.get(i).click();
				break;

			}
		}

	}

	public void selectingItemFromHomeTopConsumerNav(ConsumerHomeTopNavigationBar topNavItemSelected) {
		List<WebElement> homeTopNavItem = wd.findElements(By.cssSelector("div.list-group>a"));
		for (int i = 0; i < homeTopNavItem.size(); i++) {
			if (homeTopNavItem.get(i).getText().toString().equals(topNavItemSelected.getItem())) {
				homeTopNavItem.get(i).click();
				break;

			}
		}

	}

	public void selectFromDropDown(WebElement element, String visibleText) {

		Select sc = new Select(element);
		sc.selectByVisibleText(visibleText);

	}

	public void sleep() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void tearDown() {
		try {
			wd.quit();
		} finally {
			wd.quit();
		}

	}

}
