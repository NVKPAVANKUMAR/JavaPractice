package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigParser {

    public static String fetchProperity(String key) throws IOException {
        FileInputStream fis = new FileInputStream("configuration/config.properties");
        Properties properties = new Properties();
        properties.load(fis);
        return properties.getProperty(key);
    }
}
