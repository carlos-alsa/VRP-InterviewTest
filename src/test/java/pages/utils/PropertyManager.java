package pages.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Class to declare the .properties files that we are going to use in the different tests.
 * The path where to find the .properties files is established.
 * And the methods to return the respective values of the properties.
 * @author CSanabria
 */

public class PropertyManager {

    private static final String AUTH = "auth";
    private static final String ACCOUNT_DETAILS = "account_details";

    private static final String authFilePath = System.getProperty("user.dir") + "/src/test/resources/auth.properties";
    private static final String accountDetailsFilePath = System.getProperty("user.dir") + "/src/test/resources/account_details.properties";

    private static final Properties properties = new Properties();

    private static void loadProperties(String file) {
        try {
            switch (file) {
                case AUTH:
                    properties.load(new FileInputStream(authFilePath));
                    break;
                case ACCOUNT_DETAILS:
                    properties.load(new FileInputStream(accountDetailsFilePath));
                    break;
            }
        } catch (IOException e) {
            System.out.println("Configuration properties file cannot be found");
        }
    }

    public static String getAuthValueByKey(String key) {
        loadProperties("auth");
        return properties.getProperty(key);
    }

    public static String getAccountDetailsByKey(String key) {
        loadProperties("account_details");
        return properties.getProperty(key);
    }

}
