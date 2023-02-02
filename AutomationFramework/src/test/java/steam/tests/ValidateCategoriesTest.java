package steam.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import steam.pages.MainPage;
import java.time.Duration;


public class ValidateCategoriesTest extends BaseTest{
    private MainPage mainPage;
    @Test
    public void validateCategoriesTest() {
        mainPage = new MainPage();
        mainPage.navigateToCategories();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Assert.assertTrue(mainPage.equalsListOfCategories("action"));
/*
        assertThat("Title", str, Matchers.equalTo(str2));
        Assert.assertTrue(str2.equals(str));
*/
    }

}
