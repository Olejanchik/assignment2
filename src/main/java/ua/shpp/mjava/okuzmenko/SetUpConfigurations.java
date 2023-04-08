package ua.shpp.mjava.okuzmenko;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Properties;

public class SetUpConfigurations {
    Logger logger = LoggerFactory.getLogger(SetUpConfigurations.class);
    private final Properties properties = readPropertiesFile("config.properties");
    public String getPropertyMinValue() {
        return properties.getProperty("minValue", "2");
    }
    public String getPropertyMaxValue() {
        return properties.getProperty("maxValue", "10");
    }
    public String getPropertyIncrementValue() {
        return properties.getProperty("increment", "1");
    }
    public Properties readPropertiesFile(String filename) {
        Properties properties = new Properties();
        try {
            InputStream configFile = SetUpConfigurations.class.getClassLoader().getResourceAsStream(filename);
            properties.load(configFile);
            if (configFile != null) {
                configFile.close();
            }
            logger.debug("File read and closed successful");
        } catch (Exception e) {
            logger.warn("there is no file with this name, used default values", e);
            return null;
        }
        return properties;
    }


}
