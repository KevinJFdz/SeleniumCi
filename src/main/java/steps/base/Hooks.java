package steps.base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pages.base.BasePage;
import support.cucumber.CucumberManager;
import support.selenium.WebDriverManager;

public class Hooks {
    @Before()
    public void setUp(Scenario scenario){
        BasePage.setDriver(WebDriverManager.getChromeDriver());
        CucumberManager.setScenario(scenario);
    }

    @After()
    public void tearDown(){
        BasePage.getDriver().quit();
    }
}
