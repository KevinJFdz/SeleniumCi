package support.cucumber;

import io.cucumber.java.Scenario;

public class CucumberReport {
    private static Scenario scenario;

    public static void setScenario(Scenario newScenario){
        scenario = newScenario;
    }
    public static Scenario getScenario(){
        return scenario;
    }

    public static void attachScreenshotToReport(byte[] screenshot){
        if (getScenario() != null) {
            getScenario().attach(screenshot, "image/png", getScenario().getName());
        }
    }public static void attachScreenshotToReport(byte[] screenshot, String message){
        if (getScenario() != null) {
            getScenario().attach(screenshot, "image/png", message);
        }
    }
    public static void attachTextToReport(String name, String text){
        if (getScenario() != null) getScenario().attach(text,"text/plain",name);
    }
    public static void attachJsonToReport(String name, String json){
        if (getScenario() != null) {
            getScenario().attach(json,"application/json",name);
        }
    }
}
