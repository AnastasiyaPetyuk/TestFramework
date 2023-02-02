package steam.pages;

import framework.driver.Driver;
import framework.element.BaseElement;
import framework.page.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MainPage extends BasePage {
    protected static final By locator = By.xpath("//div[contains(@class, 'capsule main_capsule')]");
    public static WebDriver driver;
    public static BaseElement baseElement;

    public MainPage() {
        super(locator);
        this.driver = Driver.setupDriver();
    }

    public void navigateToCategories() {
        WebElement categories = driver.findElement(By.xpath("//a[contains(text(), 'Categories')]"));

        baseElement = new BaseElement(categories);
        baseElement.moveCursorToElement(driver);
    }



}
