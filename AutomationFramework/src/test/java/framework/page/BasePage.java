package framework.page;

import framework.utils.MyWaiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    private By locator;
    private WebDriver driver;

    public BasePage(By locator) {
        this.locator = locator;
    }


    public void waitForPageToBeDisplayed() {
        WebElement element = driver.findElement(this.locator);
        MyWaiters.waitForElementToBeVisible(element);
    }
}
