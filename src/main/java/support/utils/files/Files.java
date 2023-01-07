package support.utils.files;

import java.io.*;

public class Files {

    public File readFile(String filePath) {
        return new File(filePath);
    }

    public void writeFile(String filePath, String textToWrite) {
        try {
            File file = new File(filePath);
            FileOutputStream fos = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            Writer writer = new BufferedWriter(osw);
            writer.write(textToWrite);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public PrintStream getPrintStream(String outputPath) {
        PrintStream printStream = null;
        try {
            printStream = new PrintStream(new File(outputPath).getPath());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return printStream;
    }

    public void createDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }
}
