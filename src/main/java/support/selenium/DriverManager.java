package support.selenium;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static String browserName;
    private static boolean headless;
    private static String appVersion;
    private static String environment;

    public static void setEnvironment(String currentEnvironment){
        if (System.getProperty("environment") != null){
            environment= System.getProperty("environment");
        }else{
            environment= currentEnvironment;
        }
    }

    public static String getEnvironment(){
        return environment;
    }

    public static boolean isHeadless() {
        return headless;
    }

    public static void setHeadless(boolean isHeadless) {
        if (System.getProperty("headless") != null){
            headless= System.getProperty("headless").equalsIgnoreCase("true");
        }else{
            headless = isHeadless;
        }
    }

    public static String getAppVersion() {
        return appVersion;
    }

    public static void setAppVersion(String versionApp) {
        if (System.getProperty("appVersion") != null){
            appVersion= System.getProperty("appVersion");
        }else{
            appVersion = versionApp;
        }
    }

    public static String getBrowserName() {
        return browserName;
    }

    public static void setBrowserName(String browser) {
        if (System.getProperty("browser") != null){
            browserName = System.getProperty("browser");
        }else{
            browserName = browser;
        }
    }

    public static void setBrowserCapabilities(String environment, String browser, String appVersion, boolean isHeadless){
        setEnvironment(environment);
        setBrowserName(browser);
        setAppVersion(appVersion);
        setHeadless(isHeadless);
    }
    public static WebDriver getWebDriver() {
        return DriverFactory.getWebDriver(browserName,headless);
    }
}
