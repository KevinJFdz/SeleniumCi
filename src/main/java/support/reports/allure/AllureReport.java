package support.reports.allure;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AllureReport {
    private static String customResultsPath;
    public static void setUpAllureReport(String browserName, String environment, String version){
        customResultsPath = "test-output/"+environment+"/"+browserName+"/"+version+"/"+"/reports/allure-report";

        createAllureResultDir(customResultsPath);
        createEnvironmentXml(environment, browserName, version, customResultsPath);
        createCategoriesJson(customResultsPath);
        createExecutorsJson(customResultsPath);
    }

    private static void createAllureResultDir(String customResultsPath){
        File allureResultsDir = new File(customResultsPath);
        if (!allureResultsDir.exists()) {
            allureResultsDir.mkdirs();
        }

    }

    private static void createEnvironmentXml(String environment, String browser, String version,String customResultsPath) {
        System.setProperty("allure.results.directory", customResultsPath);
        FileWriter file;
        try {
            file = new FileWriter(customResultsPath+"/environment.xml");
            file.write("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
                    "<environment>\n" +
                    "    <parameter>\n" +
                    "        <key>Environment</key>\n" +
                    "        <value>"+environment+"</value>\n" +
                    "    </parameter>\n" +
                    "    <parameter>\n" +
                    "        <key>Browser</key>\n" +
                    "        <value>"+browser+"</value>\n" +
                    "    </parameter>\n" +
                    "    <parameter>\n" +
                    "        <key>Version</key>\n" +
                    "        <value>"+version+"</value>\n" +
                    "    </parameter>\n" +
                    "</environment>");
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    private static void createCategoriesJson(String customResultsPath){
        FileWriter file;

        try {
            file = new FileWriter(customResultsPath+"/categories.json");
            file.write("[\n" +
                    "  {\n" +
                    "    \"name\": \"Skipped tests\",\n" +
                    "    \"messageRegex\": \".*\",\n" +
                    "    \"matchedStatuses\": [ \"skipped\" ]\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Element not found\",\n" +
                    "    \"traceRegex\": \".*NoSuchElementError.*\",\n" +
                    "    \"matchedStatuses\": [ \"failed\" ]\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Broken tests\",\n" +
                    "    \"traceRegex\": \"Error.*\",\n" +
                    "    \"matchedStatuses\": [ \"failed\"]\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Test defect\",\n" +
                    "    \"messageRegex\": \".*Expected is not a String or a RegExp.*\",\n" +
                    "    \"matchedStatuses\": [\"failed\"]\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Product defect\",\n" +
                    "    \"traceRegex\": \".*Failed expectation.*\",\n" +
                    "    \"matchedStatuses\": [ \"failed\" ]\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"name\": \"Passed tests\",\n" +
                    "    \"matchedStatuses\": [\"passed\"]\n" +
                    "  }\n" +
                    "]");
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    private static void createExecutorsJson(String customResultsPath){
        FileWriter file;

        try {
            file = new FileWriter(customResultsPath+"/executor.json");
            file.write("{\n" +
                    "  \"name\": \"QA automation team\"\n" +
                    "}");
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public static void openAllureReport(){
        try {
            Process process = Runtime.getRuntime().exec("allure serve "+ customResultsPath);
            process.waitFor();
        } catch (IOException|InterruptedException ignored) {
        }
    }
}
