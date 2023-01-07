package runners;

import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeSuite;
import support.cucumber.BaseRunner;

@CucumberOptions(
        tags = "@Login"
)

public class Runner extends BaseRunner {
    @BeforeSuite
    public void setUp() {
        environment = "stg";
        browser ="chrome";
        version = "1.0.0";
        headless = false;
    }

}
