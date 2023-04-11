package ua.shpp.mjava.okuzmenko;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SetUpConfigurations {
    private static final String DEFAULT_MIN_VALUE = "2";
    private static final String DEFAULT_MAX_VALUE = "10";
    private static final String DEFAULT_INCREMENT_VALUE = "1";
    private static final String CONFIG_FILE = "config.properties";

    private final Logger logger;
    private final Properties properties;

    public SetUpConfigurations() {
        this.logger = LoggerFactory.getLogger(SetUpConfigurations.class);
        this.properties = readPropertiesFile(CONFIG_FILE);
    }

    public String getPropertyMinValue() {
        return getProperty("minValue", DEFAULT_MIN_VALUE);
    }

    public String getPropertyMaxValue() {
        return getProperty("maxValue", DEFAULT_MAX_VALUE);
    }

    public String getPropertyIncrementValue() {
        return getProperty("increment", DEFAULT_INCREMENT_VALUE);
    }

    private String getProperty(String key, String defaultValue) {
        if (properties == null) {
            logger.warn("Properties not loaded, returning default value");
            return defaultValue;
        }
        String value = properties.getProperty(key, defaultValue);
        logger.debug("Property {}={}", key, value);
        return value;
    }

    @SuppressWarnings("SameParameterValue")
    public Properties readPropertiesFile(String filename) {
        Properties properties = new Properties();
        try (InputStream configFile = getClass().getClassLoader().getResourceAsStream(filename)) {
            if (configFile == null) {
                logger.warn("Config file {} not found, using default values", filename);
                return properties;
            }
            properties.load(configFile);
            logger.debug("Config file {} loaded successfully", filename);
        } catch (IOException e) {
            logger.warn("Failed to read properties from file {}, using default values", filename, e);
        }
        return properties;
    }
}
