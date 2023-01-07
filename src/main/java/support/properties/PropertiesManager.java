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
            e.printStackTrace();
        }
    }

    public static int getImplicitlyWaitTime() {
        return Integer.parseInt(properties.getProperty("implicitlyWait"));
    }

    public static int getFluentWaitTime() {
        return Integer.parseInt(properties.getProperty("fluentWait"));
    }

    public static int getPollingEveryTime() {
        return Integer.parseInt(properties.getProperty("pollingEvery"));
    }
}

