package appiumTest.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class MainScreenPage {

    private AndroidDriver driver;
    private WebDriverWait wait;

    // NOTE: Verify these resource-ids with Appium Inspector if any locator fails
    private By fabAddNote    = By.id("org.fossify.notes:id/fab_add_note");
    private By emptyStateText = By.id("org.fossify.notes:id/notes_placeholder");
    private By searchIcon    = By.id("org.fossify.notes:id/menu_search");
    private By settingsIcon  = By.id("org.fossify.notes:id/menu_settings");
    private By noteItemTitle = By.id("org.fossify.notes:id/note_title");
    // Search field that appears after tapping the search icon
    private By searchInput   = By.className("android.widget.EditText");

    public MainScreenPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isFabDisplayed() {
        return wait.until(d -> d.findElement(fabAddNote)).isDisplayed();
    }

    public void tapAddNote() {
        wait.until(d -> d.findElement(fabAddNote)).click();
    }

    public boolean isEmptyStateDisplayed() {
        try {
            return driver.findElement(emptyStateText).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public List<WebElement> getNoteItems() {
        return driver.findElements(noteItemTitle);
    }

    public int getNoteCount() {
        return getNoteItems().size();
    }

    public void tapNoteByIndex(int index) {
        // Re-fetch list to avoid stale element reference
        List<WebElement> items = wait.until(d -> {
            List<WebElement> list = d.findElements(noteItemTitle);
            return list.isEmpty() ? null : list;
        });
        items.get(index).click();
    }

    public void tapSearchIcon() {
        wait.until(d -> d.findElement(searchIcon)).click();
    }

    /** Types into the search field that appears after tapping the search icon. */
    public void typeInSearchField(String text) {
        wait.until(d -> d.findElement(searchInput)).sendKeys(text);
    }

    public void tapSettingsIcon() {
        wait.until(d -> d.findElement(settingsIcon)).click();
    }

    public void longPressNote(int index) {
        WebElement note = getNoteItems().get(index);
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence longPress = new Sequence(finger, 0);
        longPress.addAction(finger.createPointerMove(Duration.ZERO,
                PointerInput.Origin.viewport(),
                note.getLocation().x + 10, note.getLocation().y + 10));
        longPress.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        longPress.addAction(new Pause(finger, Duration.ofMillis(1000)));
        longPress.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(List.of(longPress));
    }
}
