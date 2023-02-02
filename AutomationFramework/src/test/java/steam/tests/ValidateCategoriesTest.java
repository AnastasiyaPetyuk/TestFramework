package steam.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import steam.pages.MainPage;
import steam.steps.MainPageSteps;

import java.time.Duration;


public class ValidateCategoriesTest extends BaseTest{
    private MainPage mainPage;
    private MainPageSteps mainPageSteps;
    @Test
    public void validateCategoriesTest() {
        mainPage = new MainPage();
        mainPage.navigateToCategories();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        Assert.assertTrue(mainPageSteps.equalsListOfCategories("action"));
        Assert.assertTrue(mainPageSteps.equalsListOfCategories("rpg"));
        Assert.assertTrue(mainPageSteps.equalsListOfCategories("strategy"));
    }

}
