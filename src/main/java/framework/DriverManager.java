package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverManager {
    private static WebDriver driver;
    private static final Properties PROPERTIES = new Properties();

    public static void initDriver() {
        try {
            PROPERTIES.load(new FileInputStream(new File("src/main/resources/driver.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (PROPERTIES.getProperty("browser")) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", PROPERTIES.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
                break;
            case "gecko":
                System.setProperty("webdriver.gecko.driver", PROPERTIES.getProperty("webdriver.gecko.driver"));
                driver = new EdgeDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", PROPERTIES.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }

    public static WebDriver getDriver() {
        if (driver == null)
            initDriver();
        return driver;
    }

}
