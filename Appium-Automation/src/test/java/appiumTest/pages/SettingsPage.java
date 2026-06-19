package appiumTest.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class SettingsPage {

    private AndroidDriver driver;
    private WebDriverWait wait;

    // PLACEHOLDER locator — verify with Appium Inspector
    private By settingsTitle = By.xpath("//android.widget.TextView[@text='Settings']");

    public SettingsPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isSettingsScreenDisplayed() {
        try {
            return wait.until(d -> d.findElement(settingsTitle)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getCurrentActivity() {
        return driver.currentActivity();
    }

    public void goBack() {
        driver.navigate().back();
    }
}
