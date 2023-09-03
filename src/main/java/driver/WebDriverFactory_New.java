package driver;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;

public class WebDriverFactory_New {
    public static WebDriver initDriver(WebDriverType webDriverType) {
        WebDriver driver = null;
        switch (webDriverType) {
            case CHROME:
                //WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case EDGE:
               // WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case FIREFOX:
               // WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver initDriver() {
        WebDriverType webDriverType = null;
        try {
            webDriverType = WebDriverType.valueOf(System.getProperty("webDriverType", "chrome").toUpperCase());
        } catch (IllegalArgumentException ex) {
            System.out.println("This driver is not supported. \nPlease choose: chrome, edge, firefox");
            System.exit(-1); // Щоб не йшло виконання далі
        }
        return initDriver(webDriverType);
    }

}
