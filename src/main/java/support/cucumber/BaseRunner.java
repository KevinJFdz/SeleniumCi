package support.cucumber;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import steps.base.BaseSteps;
import support.reports.allure.AllureReport;
import support.selenium.DriverManager;

@CucumberOptions(
        features = {"src/test/java/features"},
        glue = {"steps"},
        plugin = {
                "pretty",
                "json:target/cucumber-report/cucumber.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        monochrome = true)
public class BaseRunner {
    protected String environment;
    protected String browser;
    protected String version;
    protected boolean headless;
    protected String userEmail;
    protected String userPassword;

    private static final ThreadLocal<TestNGCucumberRunner> testNGCucumberRunner = new ThreadLocal<>();

    private static TestNGCucumberRunner getRunner() {
        return testNGCucumberRunner.get();
    }

    public static void setRunner(TestNGCucumberRunner newTestNGCucumberRunner) {
        testNGCucumberRunner.set(newTestNGCucumberRunner);
    }

    @BeforeClass
    public void setUpDevice() {
        DriverManager.setBrowserCapabilities(environment, browser, version, headless);
        AllureReport.setUpAllureReport(
                DriverManager.getBrowserName(),
                DriverManager.getEnvironment(),
                DriverManager.getAppVersion());
        setRunner(new TestNGCucumberRunner(this.getClass()));
    }

    @Test(groups = "cucumber", description = "Cucumber scenarios", dataProvider = "scenarios")
    public void scenario(PickleWrapper pickle, FeatureWrapper cucumberFeature) {
        getRunner().runScenario(pickle.getPickle());
    }

    @DataProvider
    public Object[][] scenarios() {
        return getRunner().provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        getRunner().finish();
    }
}
