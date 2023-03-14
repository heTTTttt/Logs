import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class FileLoggerConfigurationLoader {

    public static FileLoggerConfiguration load(String configFilePath) throws IOException {

        // Створюємо об'єкт властивостей
        Properties properties = new Properties();

        // Завантажуємо властивості з файлу
        BufferedReader reader = new BufferedReader(new FileReader(configFilePath));
        properties.load(reader);

        // Створюємо новий об'єкт конфігурації
        FileLoggerConfiguration configuration = new FileLoggerConfiguration();

        // Задаємо значення властивостей конфігурації
        configuration.setFilePath(properties.getProperty("FILE"));
        configuration.setLoggingLevel(LoggingLevel.valueOf(properties.getProperty("LEVEL")));
        configuration.setMaxFileSize(Long.parseLong(properties.getProperty("MAX-SIZE")));
        configuration.setLogDateFormat(properties.getProperty("FORMAT"));

        // Повертаємо об'єкт конфігурації
        return configuration;
    }
}
