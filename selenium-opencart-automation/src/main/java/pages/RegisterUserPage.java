package pages;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterUserPage {
	
	WebDriver driver;
	private By newUserName = By.xpath("//*[@data-qa = 'signup-name']");
	private By newUserEmail = By.xpath("//*[@data-qa = 'signup-email']");
	private By signUpButton = By.xpath("//*[@data-qa = 'signup-button']");
	private By password = By.id("password");
	// DOB
	private By dateDropdown = By.id("days");
	private By monthDropdown = By.id("months");
	private By yearDropdown = By.id("years");
	private By nameField = By.id("name");
	private By firstNameField = By.id("first_name");
	private By lastnameField = By.id("last_name");
	private By addressField = By.id("address1");
	private By countryField = By.id("country");
	private By stateField = By.id("state");
	private By cityField = By.id("city");
	private By zipcodeField = By.id("zipcode");
	private By moboileNumberField = By.id("mobile_number");
	private By createAccount = By.xpath("//button[@data-qa='create-account']");
	
	private By accountCreatedTitle = By.xpath("//h2[@class='account-created']");
	private By accountCreatedMessage1 = By.xpath("//p[contains(text(),'successfully created')]");
	private By accountCreatedMessage2 = By.xpath("//p[contains(text(),'member privileges')]");
	
	
	public RegisterUserPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void newUserSignup(String name, String email) {
		driver.findElement(newUserName).sendKeys(name);
		driver.findElement(newUserEmail).sendKeys(email);
		driver.findElement(signUpButton).click();
	}
	
	public void enterAccountInfo(String title,String userPassword) {
		
		driver.findElement(By.xpath("//input[@name='title' and @value='" + title + "']")).click();
		driver.findElement(password).sendKeys(userPassword);
		
		Select daySelect = new Select(driver.findElement(dateDropdown));
		daySelect.selectByValue("1");
		Select monthSelect = new Select(driver.findElement(monthDropdown));
		monthSelect.selectByVisibleText("January");
		Select yearSelect = new Select(driver.findElement(yearDropdown));
		yearSelect.selectByVisibleText("2001");
		
		String fullName = driver.findElement(nameField).getAttribute("value");
		String[] nameParts = fullName.trim().split("\\s+");
		String lastname = nameParts.length > 1 ? String.join(" ", Arrays.copyOfRange(nameParts, 1, nameParts.length)):"";
		driver.findElement(firstNameField).sendKeys(nameParts[0]);
		driver.findElement(lastnameField).sendKeys(lastname);
		
		driver.findElement(addressField).sendKeys("123,XYZ");
		Select countrySelect = new Select(driver.findElement(countryField));
		countrySelect.selectByValue("India");
		driver.findElement(stateField).sendKeys("Andhra Pradesh");
		driver.findElement(cityField).sendKeys("Eluru");
		driver.findElement(zipcodeField).sendKeys("534001");
		driver.findElement(moboileNumberField).sendKeys("9879879879");
		System.out.println("Entered All fields");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement createAccountBtn = wait.until(
	            ExpectedConditions.elementToBeClickable(createAccount)
	    );
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block:'center'});",
				createAccountBtn);
		js.executeScript("arguments[0].click();", createAccountBtn);

	}
	
	public boolean accountCreated() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		    String title = wait.until(ExpectedConditions.visibilityOfElementLocated(accountCreatedTitle)).getText().trim();
		    String message1 = driver.findElement(accountCreatedMessage1).getText().trim();
		    String message2 = driver.findElement(accountCreatedMessage2).getText().trim();
		    return title.equalsIgnoreCase("ACCOUNT CREATED!")
		            && message1.contains("successfully created")
		            && message2.contains("member privileges");
	}
			
	
}
