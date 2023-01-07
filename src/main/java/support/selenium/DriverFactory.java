package support.selenium;

import org.openqa.selenium.WebDriver;
import support.properties.PropertiesManager;

import java.time.Duration;

public class DriverFactory {
    public static WebDriver getWebDriver(String browserName , boolean isHeadless) {
        WebDriver driver;
        if(browserName.equalsIgnoreCase("FireFox")){
            driver = FireFoxDriverManager.setUpDriver(isHeadless);
        }
        else{
            driver = ChromeDriverManager.setUpDriver(isHeadless);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(PropertiesManager.getImplicitlyWaitTime()));
        driver.manage().window().maximize();
        return driver;
    }
}
