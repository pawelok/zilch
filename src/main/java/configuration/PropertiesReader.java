package configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    private static final Properties properties = new Properties();

    static {
        String env = System.getProperty("env", "prod");  // Default to 'prod' if not specified
        String propertiesFile = env + ".properties";
        try (InputStream inputStream = PropertiesReader.class.getClassLoader().getResourceAsStream(propertiesFile)) {
            if (inputStream == null) {
                throw new IOException("Properties file not found: " + propertiesFile);
            }
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file: " + propertiesFile, e);
        }
    }

    public static String getAppId() {
        return System.getenv("APP_ID");
    }

    public static String getAppActivity() {
        return System.getenv("APP_ACTIVITY");
    }

    public static String getPlatform() {
        return System.getenv("PLATFORM");
    }

    public static String getDeviceUdid() {
        return System.getenv("DEVICE_UDID");
    }

    public static String getApiBaseUrl() { return properties.getProperty("API_BASE_URL"); }
}