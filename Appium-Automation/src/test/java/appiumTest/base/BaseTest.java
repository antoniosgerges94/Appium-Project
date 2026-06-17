package appiumTest.base;

import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseTest {

    protected AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("My Virtual Emulator");
        options.setApp("C:\\Users\\Antonios Gerges\\eclipse-workspace\\Appium-Project\\org.fossify.notes_13.apk");
        options.setAppPackage("org.fossify.notes");
        options.setAppActivity("org.fossify.notes.activities.SplashActivity.Green");
        options.setFullReset(true); // start fresh every test - clean state

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
