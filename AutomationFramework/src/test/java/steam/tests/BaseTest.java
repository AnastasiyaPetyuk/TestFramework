package steam.tests;

import framework.driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    protected static final Logger logger = LogManager.getLogger(BaseTest.class);
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
