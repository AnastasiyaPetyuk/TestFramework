package steam.steps;

import framework.utils.GetProperties;
import steam.pages.MainPage;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainPageSteps {
    public static final Logger logger = Logger.getLogger(MainPageSteps.class.getName());
    private static MainPage mainPage = new MainPage();
    public static final String partOfLocator = "//div[@data-genre-group='%s'][2]/following-sibling::div[1]/a";

    public static boolean equalsListOfCategories(String s) {     // s = "action", "rpg", "strategy"

        logger.info("check equals of categories in field " + s);

        List<String> actualString = new ArrayList<>(mainPage.baseElement.getAllText(mainPage.driver, partOfLocator, s));
        List<String> expectedString = new ArrayList<>();

        String line = GetProperties.getProperties("categories", s);

        expectedString = Stream.of(line.split(",")).collect(Collectors.toList());
        return expectedString.equals(expectedString);
    }
}
