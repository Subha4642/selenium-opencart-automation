package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;
	
	private By signupLoginLink = By.xpath("//a[@href='/login']");
	private By loggedInUser = By.xpath("//i[@class='fa fa-user']");
	
	public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignupLogin() {
        driver.findElement(signupLoginLink).click();
    }

    public boolean isUserLoggedIn() {
        return driver.findElement(loggedInUser).isDisplayed();
    }

}
