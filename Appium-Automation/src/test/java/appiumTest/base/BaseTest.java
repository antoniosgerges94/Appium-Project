package appiumTest.base;

import java.io.File;
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
        // Relative path — works on any machine that has the APK in TestApp/
        File apkFile = new File("TestApp/org.fossify.notes_13.apk");

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("My Virtual Emulator");
        options.setApp(apkFile.getAbsolutePath());
        options.setAppPackage("org.fossify.notes");
        options.setAppActivity("org.fossify.notes.activities.SplashActivity"); // fixed: removed ".Green"
        options.setNoReset(false);   // clears app data without full reinstall (faster than fullReset)
        options.setFullReset(false); // fullReset=true is very slow; use only in @BeforeSuite if needed

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        // Do NOT mix implicitlyWait with explicit WebDriverWait — removed from here
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
