package base;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import config.ConfigReader;

public class DriverFactory {

    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    Properties prop;

    public WebDriver initDriver() {
        prop = ConfigReader.initProperties();
        String browser = prop.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome")) {
            tlDriver.set(new ChromeDriver());
        } else if (browser.equalsIgnoreCase("firefox")) {
            tlDriver.set(new FirefoxDriver());
        }

        getDriver().manage().window().maximize();
        getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(
                        Integer.parseInt(prop.getProperty("implicitWait"))));

        getDriver().get(prop.getProperty("baseUrl"));
        return getDriver();
    }

    public static WebDriver getDriver() {
        return tlDriver.get();
    }
}