import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger implements ILogger {

    private String logFilePath;
    private long maxFileSize;
    private int currentFileSize;

    public FileLogger(FileLoggerConfiguration config) {
        this.logFilePath = config.getFilePath();
        this.maxFileSize = config.getMaxFileSize();
        this.currentFileSize = 0;
    }


    public void debug(String message) throws FileMaxSizeReachedException {
        log(message);
    }

    public void info(String message) throws FileMaxSizeReachedException {
        log(message);
    }

    public void log(String message) {
        // Get current date and time
        LocalDateTime now = LocalDateTime.now();

        // Create log entry
        String logEntry = "[" + now.format(DateTimeFormatter.ISO_DATE_TIME) + "] " + message + "\n";

        // Write log entry to file
        try {
            // Check if log file exists
            File logFile = new File(logFilePath);
            if (!logFile.exists()) {
                // Create new log file
                logFile.createNewFile();
            } else {
                // Check if log file exceeds max file size
                if (logFile.length() >= maxFileSize) {
                    // Create new log file with timestamp in file name
                    String timestamp = now.format(DateTimeFormatter.ofPattern("dd.MM.yyyy-HH.mm.ss"));
                    String newLogFileName = "Log_" + timestamp + ".txt";
                    File newLogFile = new File(newLogFileName);
                    newLogFile.createNewFile();

                    // Use new log file for logging
                    logFilePath = newLogFileName;
                    currentFileSize = 0;
                }
            }

            // Write log entry to file
            FileWriter writer = new FileWriter(logFilePath, true);
            writer.write(logEntry);
            writer.close();

            // Update current file size
            currentFileSize += logEntry.getBytes().length;
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }
}
