package appiumTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class RunNativeAndroidApp {

    public static void main(String[] args)
            throws MalformedURLException {

        File appFile =
                new File(
                        "TestApp/org.fossify.notes_13.apk");

        UiAutomator2Options options =
                new UiAutomator2Options();

        options.setDeviceName(
                "My Virtual Emulator");

        options.setApp(
                appFile.getAbsolutePath());

        options.setAppPackage(
                "org.fossify.notes");

        options.setAppActivity(
                "org.fossify.notes.activities.SplashActivity.Green");

        AndroidDriver driver =
                new AndroidDriver(
                        new URL("http://127.0.0.1:4723"),
                        options);

        System.out.println(
                "Session created: "
                        + driver.getSessionId());

        WebDriverWait wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(10));

        wait.until(
                d ->
                        d.findElements(
                                By.className(
                                        "android.widget.FrameLayout"))
                                .size() > 0);

        System.out.println(
                "TestApp is opened");

        driver.quit();
    }
}