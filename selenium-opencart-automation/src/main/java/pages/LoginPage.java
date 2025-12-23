package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;
	
	private By email = By.xpath("//*[@data-qa='login-email']");
	private By password = By.xpath("//*[@data-qa='login-password']");
	private By loginButton = By.xpath("//button[@data-qa='login-button']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void login(String useremail, String userpassword) {
		driver.findElement(email).sendKeys(useremail);
		driver.findElement(password).sendKeys(userpassword);
		driver.findElement(loginButton).click();
	}

}
