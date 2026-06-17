package appiumTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.github.bonigarcia.wdm.WebDriverManager;

public class InspectMobileWebElements {

    @Test
    public void OpenWebApp()
            throws MalformedURLException, InterruptedException {

        WebDriverManager.chromedriver().browserVersion("145").setup();
        String chromedriverPath = System.getProperty("webdriver.chrome.driver");

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("My Virtual Emulator");
        options.setCapability("browserName", "chrome");
        options.setCapability("chromedriverExecutable", chromedriverPath);

        AndroidDriver driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"),
                options);

        driver.get("https://todo.qacart.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("input[name='email']")
        ));

        System.out.println("==================================================");
        System.out.println("✅ Session ID: " + driver.getSessionId());
        System.out.println("🔴 OPEN Appium Inspector NOW.");
        System.out.println("Set port to 4723 → Attach to Session → Refresh Discovered Sessions.");
        System.out.println("Once attached, press ENTER here to finish the test...");
        System.out.println("==================================================");

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine(); // Waits for Enter
        scanner.close();

        // 🟢 NO sleep – test ends immediately after pressing Enter!
        System.out.println("✅ Test finished successfully!");
    }
}