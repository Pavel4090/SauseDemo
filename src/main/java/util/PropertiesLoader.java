package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    public static Properties loadProperties(String fileName) {
        Properties properties = new Properties();

        try (InputStream input = PropertiesLoader.class.getClassLoader().getResourceAsStream(fileName)) {
            //load a properties file from class path, inside static method
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return properties;
    }

    public static Properties loadProperties() {
        return loadProperties("configuration.properties");
    }
}
