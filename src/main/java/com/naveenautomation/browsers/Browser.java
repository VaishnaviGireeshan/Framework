package com.naveenautomation.browsers;

public enum Browser {
	CHROME("Chrome"), 
	EDGE("Edge"), 
	FIREFOX("FireFox"),
	;

	public String browser;

	private Browser(String browser) {
		this.browser = browser;

	}
}
