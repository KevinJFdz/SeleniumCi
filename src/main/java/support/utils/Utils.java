package support.utils;

import support.utils.files.Files;

public class Utils {
    public Files files = new Files();
    public static void sleep(Integer millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
