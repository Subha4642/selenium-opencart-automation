package stepdefinitions;

import org.testng.Assert;

import base.DriverFactory;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.LoginPage;

public class LoginSteps {
	HomePage homePage = new HomePage(DriverFactory.getDriver());
	LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	
	@Given("user navigates to login & signup page")
	public void user_navigates_to_login_page() {
		homePage.clickSignupLogin();
	}

	@When("user logs in with valid credentials")
	public void user_logs_in_with_valid_credentials() {
        loginPage.login("Tester.One@mailto.plus", "Tester.One");
    }
	
	@Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        Assert.assertTrue(homePage.isUserLoggedIn());
    }
}
