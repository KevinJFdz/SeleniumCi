package support.properties;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertiesManager {
    private static Properties properties;

    static {
        try {
            properties = new Properties();
            InputStream input = Files.newInputStream(Paths.get("config.properties"));
            properties.load(input);
        } catch (IOException e) {
            properties.setProperty("implicitlyWait", System.getenv("IMPLICITLY_WAIT_TIME"));
            properties.setProperty("fluentWait", System.getenv("FLUENT_WAIT_TIME"));
            properties.setProperty("pollingEvery", System.getenv("POLLING_EVERY_TIME"));
        }
    }

    public static int getImplicitlyWaitTime() {
//        return Integer.parseInt(properties.getProperty("implicitlyWait"));
        return 10;
    }

    public static int getFluentWaitTime() {
        return Integer.parseInt(properties.getProperty("fluentWait"));
    }

    public static int getPollingEveryTime() {
        return Integer.parseInt(properties.getProperty("pollingEvery"));
    }
}