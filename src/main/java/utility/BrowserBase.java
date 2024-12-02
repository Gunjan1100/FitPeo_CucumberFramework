package utility;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BrowserBase {

    WebDriver driver;
    public WebDriver browserInvocation()  {
        if(driver == null) {
            File f = new File("src/main/resources/configuration/frameworkconfiguration.properties");
            FileInputStream fis = null; // to read data
            try {
                fis = new FileInputStream(f);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            Properties properties = new Properties();
            try {
                properties.load(fis);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            properties.getProperty("browser");

            switch (properties.getProperty("browser").toLowerCase()) {
                case "edge":
                    driver = new EdgeDriver();
                    break;

                case "chrome":
                    driver = new ChromeDriver();
                    break;

                case "safari":
                    driver = new SafariDriver();
                    break;

                default:
                    throw new InvalidArgumentException("please check the browser value");
            }
            driver.get(properties.getProperty("url"));
            driver.manage().window().maximize();
            driver.navigate().refresh();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            return driver; // return value as driver so method will be WebDriver

        }
        return  driver;

    }
}

