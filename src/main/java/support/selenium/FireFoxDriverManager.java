package support.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FireFoxDriverManager {
    protected static WebDriver setUpDriver(boolean isHeadless){
        WebDriver driver;
        FirefoxOptions firefoxOptions = getFireFoxOptions(isHeadless);
        driver = new FirefoxDriver(firefoxOptions);
        return driver;
    }

    private static FirefoxOptions getFireFoxOptions(boolean isHeadless) {
        FirefoxOptions fireFoxOptions = new FirefoxOptions();
        fireFoxOptions.addArguments("--disable-notifications");
        fireFoxOptions.addArguments("--start-maximized");
        fireFoxOptions.addArguments("--disable-features=EnableEphemeralFlashPermission");
        fireFoxOptions.addArguments("--disable-infobars");
        if (isHeadless) fireFoxOptions.addArguments("--headless");
        return fireFoxOptions;
    }
}
