package org.jat.configs.loader;


import java.io.IOException;
import java.util.Properties;


/**
 * The class PropertiesParser provides access to methods for getting data from property files.
 */
public class PropertiesLoader {


    /**
     * Reads properties from the *.properties file.
     *
     * @param fileName Properties file name to be loaded
     * @return Loaded properties
     * @throws IOException if properties could not be loaded from the InputStream
     */
    public static Properties getAllProperties(String fileName) throws IOException {
        Properties properties = new Properties();
        properties.load(ResourceLoader.readFile(fileName));
        return properties;
    }

    /**
     * Gets property by name from the provided <a href="#{@link}">{@link Properties} and throw exception if there is no
     * such name/key in provided properties.
     *
     * @param properties  Properties
     * @param propertyKey name/key
     * @return String value of the property
     * @throws IllegalArgumentException if there is no such property
     */
    public static String getProperty(Properties properties, String propertyKey) {
        String prop = getProperty(properties, propertyKey, null);
        if (prop != null) {
            return prop;
        } else {
            throw new IllegalArgumentException("Property with name: " + propertyKey + " is missing");
        }
    }

    /**
     * Gets property by name from the provided <a href="#{@link}">{@link Properties} or return default if there is no
     * such name/key in provided properties.
     *
     * @param properties   Properties
     * @param propertyKey  name/key
     * @param defaultValue Default value if requested name/key is missing
     * @return String value of the property or default
     */
    public static String getProperty(Properties properties, String propertyKey, String defaultValue) {
        return System.getProperty(propertyKey) != null
                ? System.getProperty(propertyKey)
                : properties.getProperty(propertyKey, defaultValue);
    }
}
