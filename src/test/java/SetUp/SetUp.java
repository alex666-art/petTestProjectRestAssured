package SetUp;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SetUp {

    public static String get_LOGIN_Property() {
        Properties prop = new Properties();
        try (InputStream input = SetUp.class.getClassLoader().getResourceAsStream("credentials.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find credentials.properties");
            }
            //load a properties file from class path, inside static method
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop.getProperty("LOGIN");
    }

    public static String get_PASSWORD_Property() {
        Properties prop = new Properties();
        try (InputStream input = SetUp.class.getClassLoader().getResourceAsStream("credentials.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find credentials.properties");
            }
            //load a properties file from class path, inside static method
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop.getProperty("PASSWORD");
    }

    public static String get_URL_Property() {
        Properties prop = new Properties();
        try (InputStream input = SetUp.class.getClassLoader().getResourceAsStream("credentials.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find selenide.properties");
            }
            //load a properties file from class path, inside static method
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop.getProperty("URL");
    }
}