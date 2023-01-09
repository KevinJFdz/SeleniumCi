package support.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeDriverManager {
    protected static WebDriver setUpDriver(boolean isHeadless){
        WebDriver driver;
        ChromeOptions chromeOptions = getChromeOptions(isHeadless);
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return driver;
    }

    private static ChromeOptions getChromeOptions(boolean isHeadless) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--disable-features=EnableEphemeralFlashPermission");
        chromeOptions.addArguments("--disable-infobars");
//        if (isHeadless)
        chromeOptions.addArguments("--headless");
        return chromeOptions;
    }
}
