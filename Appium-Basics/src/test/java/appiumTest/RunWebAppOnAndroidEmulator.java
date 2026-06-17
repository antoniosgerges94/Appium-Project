package appiumTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RunWebAppOnAndroidEmulator {

    @Test
    public void OpenWebApp()
            throws MalformedURLException {

        WebDriverManager.chromedriver().setup();

        String chromedriverPath =
                System.getProperty(
                        "webdriver.chrome.driver");

        UiAutomator2Options options =
                new UiAutomator2Options();

        options.setDeviceName(
                "My Virtual Emulator");

        options.setCapability(
                "browserName",
                "chrome");

        options.setCapability(
                "chromedriverExecutable",
                chromedriverPath);

        AndroidDriver driver =
                new AndroidDriver(
                        new URL("http://127.0.0.1:4723"),
                        options);

        driver.get(
                "https://google.com");

        driver.quit();
    }
}