package appiumTest.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import appiumTest.base.BaseTest;
import appiumTest.pages.MainScreenPage;
import appiumTest.pages.SettingsPage;

public class NavigationTests extends BaseTest {

    @Test
    public void openSettingsScreen() {
        MainScreenPage mainScreen = new MainScreenPage(driver);
        mainScreen.tapSettingsIcon();

        SettingsPage settings = new SettingsPage(driver);
        Assert.assertTrue(
                settings.getCurrentActivity().toLowerCase().contains("settings"),
                "Settings activity should be opened"
        );
    }

    @Test
    public void navigateBackFromSettings() {
        MainScreenPage mainScreen = new MainScreenPage(driver);
        mainScreen.tapSettingsIcon();

        SettingsPage settings = new SettingsPage(driver);
        settings.goBack();

        Assert.assertTrue(mainScreen.isFabDisplayed(), "Should return to main screen");
    }
}
