package appiumTest;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

public class RunNativeIOSAppOnBrowserStack {

    public static void main(String[] args) {

        IOSDriver driver = null;

        try {

            String username =
                    System.getenv("BROWSERSTACK_USERNAME");

            String accessKey =
                    System.getenv("BROWSERSTACK_ACCESS_KEY");

            String appId =
                    System.getenv("BROWSERSTACK_APP_ID");

            if (username == null ||
                    accessKey == null ||
                    appId == null ||
                    username.isBlank() ||
                    accessKey.isBlank() ||
                    appId.isBlank()) {

                throw new RuntimeException(
                        "\nMissing environment variables:\n"
                                + "BROWSERSTACK_USERNAME\n"
                                + "BROWSERSTACK_ACCESS_KEY\n"
                                + "BROWSERSTACK_APP_ID");
            }

            XCUITestOptions options =
                    new XCUITestOptions();

            options.setCapability("app", appId);

            Map<String, Object> bstack =
                    new HashMap<>();

            bstack.put("deviceName", "iPhone 14");
            bstack.put("osVersion", "16");

            bstack.put("projectName", "Demo Project");
            bstack.put("buildName", "Build 1");
            bstack.put("sessionName", "Launch iOS App");

            bstack.put("debug", false);
            bstack.put("networkLogs", false);
            bstack.put("video", false);

            bstack.put("source", "appium-java:eclipse");

            options.setCapability(
                    "bstack:options",
                    bstack);

            String url =
                    "https://"
                            + username
                            + ":"
                            + accessKey
                            + "@hub.browserstack.com/wd/hub";

            driver =
                    new IOSDriver(
                            new URL(url),
                            options);

            System.out.println(
                    "Session created: "
                            + driver.getSessionId());

            System.out.println(
                    "iOS app launched");

            driver.executeScript(
                    "browserstack_executor: {"
                            + "\"action\":\"setSessionStatus\","
                            + "\"arguments\":{"
                            + "\"status\":\"passed\","
                            + "\"reason\":\"App launched successfully\""
                            + "}}");

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            if (driver != null) {
                driver.quit();
            }
        }
    }
}