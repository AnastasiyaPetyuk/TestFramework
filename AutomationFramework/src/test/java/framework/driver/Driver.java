package framework.driver;

import framework.utils.GetProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.ResourceBundle;

public class Driver {
    private static WebDriver driver;

    private Driver() {

    }

    public static WebDriver setupDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            // options.addArguments("--headless");
            options.addArguments("start-maximized");
            options.addArguments("--lang=en");
            driver = new ChromeDriver(options);
            // driver.manage().window().maximize();

            driver.get(GetProperties.getProperties("config", "mainUrl"));

//            ResourceBundle rb = ResourceBundle.getBundle("config");
//            driver.get(rb.getString("mainUrl"));


            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }

    public static void closeDriver() {
        driver.close();
    }
}
