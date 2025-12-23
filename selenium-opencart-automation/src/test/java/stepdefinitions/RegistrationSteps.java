package stepdefinitions;

import base.DriverFactory;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.RegisterUserPage;

public class RegistrationSteps {
	HomePage homePage = new HomePage(DriverFactory.getDriver());
	RegisterUserPage registrationPage = new RegisterUserPage(DriverFactory.getDriver());

	@When("user provides credentials to signup")
	public void user_signup_credentials() {
		registrationPage.newUserSignup("Tester Four", "Tester.Four@mailto.plus");
    }
	
	@Then("user enter account details for signup")
    public void enter_account_details() {
		registrationPage.enterAccountInfo("Mr", "Tester.Four");
    }
	
	@And("new user account got created")
    public void user_should_be_logged_in_successfully() {
		registrationPage.accountCreated();
    }

}
