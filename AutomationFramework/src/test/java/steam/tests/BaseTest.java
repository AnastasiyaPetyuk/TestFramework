package steam.tests;

import framework.driver.Driver;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.logging.Logger;

public class BaseTest {

    public static final Logger logger = Logger.getLogger(BaseTest.class.getName());


    protected static WebDriver driver;

    @BeforeSuite
    public void setUpDriver() {
        logger.info("set up driver");
        driver = Driver.setupDriver();
    }

    @AfterSuite
    public void closeDriver() {
        logger.info("close driver");
        Driver.closeDriver();
    }
}
