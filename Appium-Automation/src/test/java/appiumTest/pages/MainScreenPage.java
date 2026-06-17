package appiumTest.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class MainScreenPage {

    private AndroidDriver driver;
    private WebDriverWait wait;

    // NOTE: These locators are PLACEHOLDERS.
    // Use Appium Inspector to find the real resource-ids for org.fossify.notes
    // and replace the strings below accordingly.

    private By fabAddNote = By.id("org.fossify.notes:id/fab_add_note");
    private By notesList = By.id("org.fossify.notes:id/notes_list");
    private By emptyStateText = By.id("org.fossify.notes:id/notes_placeholder");
    private By searchIcon = By.id("org.fossify.notes:id/menu_search");
    private By settingsIcon = By.id("org.fossify.notes:id/menu_settings");
    private By noteItemTitle = By.id("org.fossify.notes:id/note_title");

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
        getNoteItems().get(index).click();
    }

    public void tapSearchIcon() {
        wait.until(d -> d.findElement(searchIcon)).click();
    }

    public void tapSettingsIcon() {
        wait.until(d -> d.findElement(settingsIcon)).click();
    }

    public void longPressNote(int index) {
        WebElement note = getNoteItems().get(index);
        // Use W3C actions for long press
        org.openqa.selenium.interactions.PointerInput finger =
                new org.openqa.selenium.interactions.PointerInput(
                        org.openqa.selenium.interactions.PointerInput.Kind.TOUCH, "finger");
        org.openqa.selenium.interactions.Sequence longPress = new org.openqa.selenium.interactions.Sequence(finger, 0);
        longPress.addAction(finger.createPointerMove(Duration.ZERO,
                org.openqa.selenium.interactions.PointerInput.Origin.viewport(),
                note.getLocation().x + 10, note.getLocation().y + 10));
        longPress.addAction(finger.createPointerDown(org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT.asArg()));
        longPress.addAction(new org.openqa.selenium.interactions.Pause(finger, Duration.ofMillis(1000)));
        longPress.addAction(finger.createPointerUp(org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(java.util.List.of(longPress));
    }
}
