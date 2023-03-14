import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {

            FileLoggerConfiguration config = FileLoggerConfigurationLoader.load("LoggConfig.txt");
            FileLogger fileLogger = new FileLogger(config);

            for (int i = 0; i <= 10_000; i++) {
                fileLogger.info("Info Stage");
                fileLogger.debug("Debug Stage");
            }

        } catch (IOException e) {
            System.out.println("Error loading configuration: " + e.getMessage());
        } catch (FileMaxSizeReachedException e) {
            System.out.println("Error writing log: " + e.getMessage());
        }
    }
}