package stepdefinitions;

import base.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	DriverFactory driverFactory;
	
	@Before
	public void launchBrowser() {
		driverFactory = new DriverFactory();
		driverFactory.initDriver();
	}
	
	@After
	public void tearDown() {
		DriverFactory.getDriver().quit();
	}
	
}
