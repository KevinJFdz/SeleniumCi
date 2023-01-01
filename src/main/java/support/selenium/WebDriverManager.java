package support.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;

public class WebDriverManager {

    public static WebDriver getChromeDriver(){
        io.github.bonigarcia.wdm.WebDriverManager.getInstance(CHROME).setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
}
