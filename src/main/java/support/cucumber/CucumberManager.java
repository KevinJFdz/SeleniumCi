package support.cucumber;

import io.cucumber.java.Scenario;
import pages.base.BasePage;

public class CucumberManager {
    public void setScenario(Scenario newScenario){
        CucumberReport.setScenario(newScenario);
    }
    public Scenario getScenario(){
        return CucumberReport.getScenario();
    }

    public void attachScreenshotToReport(){
        CucumberReport.attachScreenshotToReport(BasePage.takeScreenshot());
    }
    public void attachScreenshotToReport(String message){
        CucumberReport.attachScreenshotToReport(BasePage.takeScreenshot(), message);
    }

    public void attachTextToReport(String name, String text){
        CucumberReport.attachTextToReport(name, text);
    }
    public void attachJsonToReport(String name, String json){
        CucumberReport.attachJsonToReport(name, json);
    }
}
