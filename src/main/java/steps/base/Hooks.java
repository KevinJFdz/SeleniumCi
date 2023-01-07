package steps.base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import pages.base.BasePage;
import support.selenium.DriverManager;

public class Hooks {
    @Before()
    public void setUp(){
        BasePage.setDriver(DriverManager.getWebDriver());
    }

    @After()
    public void tearDown(){
        BasePage.getDriver().quit();
    }
}
