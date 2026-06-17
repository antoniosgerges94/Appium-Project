package appiumTest.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import appiumTest.base.BaseTest;
import appiumTest.pages.MainScreenPage;

public class SmokeTests extends BaseTest {

    @Test
    public void appLaunchesSuccessfully() {
        Assert.assertNotNull(driver.getSessionId(), "Session should be created successfully");
    }

    @Test
    public void addNoteButtonIsDisplayed() {
        MainScreenPage mainScreen = new MainScreenPage(driver);
        Assert.assertTrue(mainScreen.isFabDisplayed(), "Add note (FAB) button should be visible");
    }

    @Test
    public void emptyStateIsDisplayedOnFreshInstall() {
        MainScreenPage mainScreen = new MainScreenPage(driver);
        Assert.assertTrue(mainScreen.isEmptyStateDisplayed(),
                "Empty state message should be shown when there are no notes");
    }
}
