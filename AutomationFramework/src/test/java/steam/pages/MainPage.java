package steam.pages;

import framework.driver.Driver;
import framework.element.BaseElement;
import framework.page.BasePage;
import framework.utils.GetProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainPage extends BasePage {
    private static final By locator = By.xpath("//div[contains(@class, 'capsule main_capsule')]");
    private static final String partOfLocator = "//div[@data-genre-group='%s'][2]/following-sibling::div[1]/a";
    protected WebDriver driver;
    private BaseElement baseElement;

    public MainPage() {
        super(locator);
        this.driver = Driver.setupDriver();
    }

    public void navigateToCategories() {
        WebElement categories = driver.findElement(By.xpath("//a[contains(text(), 'Categories')]"));

        baseElement = new BaseElement(categories);
        baseElement.moveCursorToElement(driver);

    }

    public boolean equalsListOfCategories(String s) {     // s = "action", "rpg", "strategy"

        List<String> actualString = new ArrayList<>(baseElement.getAllText(this.driver, partOfLocator, s));
        List<String> expectedString = new ArrayList<>();

        String line = GetProperties.getProperties("categories", s);

        expectedString = Stream.of(line.split(",")).collect(Collectors.toList());
//        System.out.println(actualString);
//        System.out.println(expectedString);

        return expectedString.equals(expectedString);
    }




    /*
          List<WebElement> elements = driver.findElements(By.cssSelector("//div[@data-genre-group='%s'][contains(@class,'popup_genre_expand_content')]/a"));
          String partOfURL = "//div[@data-genre-group='%s'][2]/following-sibling::div[1]/a";



    List<String> textValues = new ArrayList<>();

        for (WebElement element : elements) {
        String text = element.getText();
        textValues.add(text);
          }

        for (String text : textValues) {
        System.out.println(text);
          }

    public List<String> method(String s) {

        return getTextFromElements(list);

    }
    public List<String> getTextFromElements(List<WebElement> list) {
        return list.stream().map(WebElement::getText).collect(Collectors.toList());
    }
    public List<WebElement> getListOfHeaderElements() {
        return driver.findElements(By.xpath(partOfURL));
    }
     */

}
