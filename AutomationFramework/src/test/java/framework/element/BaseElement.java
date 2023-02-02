package framework.element;

import framework.utils.MyWaiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.stream.Collectors;

public class BaseElement {
    private WebElement element;
    private WebDriver driver;

    public BaseElement(WebElement element) {
        this.element = element;
    }

    public void waitAndClick() {
        MyWaiters.waitForElementToBeVisible(this.element);
        element.click();
    }

    public void sendKeys(String text) {
        MyWaiters.waitForElementToBeVisible(this.element);
        element.clear();
        element.sendKeys(text);
    }

    public String getText() {
        MyWaiters.waitForElementToBeVisible(this.element);
        return element.getText();
    }

    public List<String> getAllText(WebDriver driver, String locator, String s) {
        List<WebElement> list = driver.findElements(By.xpath(String.format(locator, s)));
        return list.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public boolean isDisplayed() {
        MyWaiters.waitForElementToBeVisible(this.element);
        return element.isDisplayed();
    }

    public void moveCursorToElement(WebDriver driver) {
        new Actions(driver).moveToElement(this.element).build().perform();
    }

}
