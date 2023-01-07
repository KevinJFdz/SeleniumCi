package support.testng;

import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.model.Status;
import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;
import support.cucumber.CucumberManager;

public class CustomSoftAssert extends SoftAssert {
    @Override
    public void onAssertFailure(IAssert<?> a, AssertionError ex) {
        new CucumberManager().attachScreenshotToReport(ex.getMessage());
        try {
            AllureLifecycle lifeCycle = Allure.getLifecycle();
            lifeCycle.updateStep(lifeCycle.getCurrentTestCaseOrStep().get(), stepResult -> stepResult.setStatus(Status.FAILED));
            lifeCycle.stopStep(lifeCycle.getCurrentTestCaseOrStep().get());
        } catch (java.util.NoSuchElementException e) {
            new CucumberManager().attachScreenshotToReport(ex.getMessage());
        }

    }
}
