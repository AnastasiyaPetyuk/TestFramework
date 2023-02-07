package steam.steps;

import framework.driver.Browser;
import framework.pageElements.Label;
import framework.utils.GetProperties;
import framework.utils.MyWaiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import steam.pages.MainPage;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainPageSteps {
    public static final Logger logger = Logger.getLogger(MainPageSteps.class.getName());
    protected final Label partOfLocatorLabel = new Label(By.xpath("//div[@data-genre-group='%s'][2]/following-sibling::div[1]/a"));

    public void waitingOfDisplayedListsOfCategories() {
        WebElement element = Browser.getDriver().findElement(By.xpath("//div[@data-genre-group='action'][2]/following-sibling::div[1]/a"));
        MyWaiters.waitForTextToBePresentInElement(element, "Arcade & Rhythm");
    }

    public boolean equalsListOfCategories(String s) {     // s = "action", "rpg", "strategy"

        logger.info("check equals of categories in field " + s);

        String partOfLocator = "//div[@data-genre-group='%s'][2]/following-sibling::div[1]/a";

        List<String> actualString = new ArrayList<>(partOfLocatorLabel.getAllText(partOfLocator, s));
        List<String> expectedString = new ArrayList<>();
        String line = GetProperties.getProperties("categories", s);
        expectedString = Stream.of(line.split(",")).collect(Collectors.toList());
        System.out.println(expectedString);
        System.out.println(actualString);

        if (actualString.equals(expectedString)) {
            logger.info("The lists of categories are equal");
        } else {
            logger.info("The lists of categories are not equal");
        }

        return actualString.equals(expectedString);
    }
}
