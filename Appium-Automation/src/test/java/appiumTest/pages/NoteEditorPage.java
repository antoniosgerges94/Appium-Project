package appiumTest.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class NoteEditorPage {

    private AndroidDriver driver;
    private WebDriverWait wait;

    // PLACEHOLDER locators - replace using Appium Inspector
    private By noteContentField = By.id("org.fossify.notes:id/notes_view");
    private By saveButton = By.id("org.fossify.notes:id/menu_save");
    private By backButton = By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']");

    public NoteEditorPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void typeNoteContent(String text) {
        wait.until(d -> d.findElement(noteContentField)).sendKeys(text);
    }

    public String getNoteContent() {
        return wait.until(d -> d.findElement(noteContentField)).getText();
    }

    public void clearNoteContent() {
        wait.until(d -> d.findElement(noteContentField)).clear();
    }

    public void goBack() {
        driver.navigate().back();
    }

    public void saveNote() {
        try {
            wait.until(d -> d.findElement(saveButton)).click();
        } catch (Exception e) {
            // Some versions auto-save on back press
            goBack();
        }
    }
}
