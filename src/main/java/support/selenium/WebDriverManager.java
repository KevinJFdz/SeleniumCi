package support.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;

public class WebDriverManager {

    public static WebDriver getChromeDriver(){
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
                    chromeOptions);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
}
