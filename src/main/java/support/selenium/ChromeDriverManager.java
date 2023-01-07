package support.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager {
    protected static WebDriver setUpDriver(boolean isHeadless){
        WebDriver driver;
        ChromeOptions chromeOptions = getChromeOptions(isHeadless);
        driver = new ChromeDriver(chromeOptions);
        return driver;
    }

    private static ChromeOptions getChromeOptions(boolean isHeadless) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--disable-features=EnableEphemeralFlashPermission");
        chromeOptions.addArguments("--disable-infobars");
        if (isHeadless) chromeOptions.addArguments("--headless");
        return chromeOptions;
    }
}
