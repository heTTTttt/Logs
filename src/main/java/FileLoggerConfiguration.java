
public class FileLoggerConfiguration {
    private String logFileName;
    private String filePath;
    private LoggingLevel loggingLevel;
    private long maxFileSize;
    private String logDateFormat;

    public FileLoggerConfiguration() {
    }

    public FileLoggerConfiguration(String filePath, LoggingLevel loggingLevel, long maxFileSize, String logDateFormat) {
        this.filePath = filePath;
        this.loggingLevel = loggingLevel;
        this.maxFileSize = maxFileSize;
        this.logDateFormat = logDateFormat;
    }

    public String getLogFileName() {
        return logFileName;
    }

    public void setLogFileName(String logFileName) {
        this.logFileName = logFileName;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setLoggingLevel(LoggingLevel loggingLevel) {
        this.loggingLevel = loggingLevel;
    }

    public void setMaxFileSize(long maxFileSize) {
        this.maxFileSize = maxFileSize;
    }

    public void setLogDateFormat(String logDateFormat) {
        this.logDateFormat = logDateFormat;
    }

    public String getFilePath() {
        return filePath;
    }

    public LoggingLevel getLoggingLevel() {
        return loggingLevel;
    }

    public long getMaxFileSize() {
        return maxFileSize;
    }

    public String getLogDateFormat() {
        return logDateFormat;
    }

    @Override
    public String toString() {
        return "FileLoggerConfiguration{" +
                "filePath='" + filePath + '\'' +
                ", loggingLevel=" + loggingLevel +
                ", maxFileSize=" + maxFileSize +
                ", logDateFormat='" + logDateFormat + '\'' +
                '}';
    }
}
