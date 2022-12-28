package steps.base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import pages.base.BasePage;
import support.selenium.WebDriverManager;

public class Hooks {
    @Before()
    public void setUp(){
        BasePage.setDriver(WebDriverManager.getChromeDriver());
    }

    @After()
    public void tearDown(){
        BasePage.getDriver().quit();
    }
}
