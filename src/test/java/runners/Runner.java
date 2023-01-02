package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@Login",
        features = "src/test/java/features",
        glue = "steps",
        plugin = {
                "pretty",
                "json:target/cucumber-report/cucumber.json"
        }
)

public class Runner extends AbstractTestNGCucumberTests {
}
