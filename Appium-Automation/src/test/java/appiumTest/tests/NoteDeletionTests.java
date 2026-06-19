package appiumTest.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import appiumTest.base.BaseTest;
import appiumTest.pages.MainScreenPage;
import appiumTest.pages.NoteEditorPage;

public class NoteDeletionTests extends BaseTest {

    // Delete option that appears in the context menu after long-pressing a note
    // Verify the exact text with Appium Inspector — could be "Delete" or "Delete note"
    private By deleteMenuItem    = By.xpath("//android.widget.TextView[@text='Delete']");
    private By confirmDeleteBtn  = By.xpath("//android.widget.Button[@text='OK']");

    @Test
    public void deleteSingleNote() {
        MainScreenPage mainScreen = new MainScreenPage(driver);

        // Step 1: create a note
        mainScreen.tapAddNote();
        NoteEditorPage editor = new NoteEditorPage(driver);
        editor.typeNoteContent("Note to delete");
        editor.goBack();

        Assert.assertEquals(mainScreen.getNoteCount(), 1, "One note should exist before deletion");

        // Step 2: long press to trigger context menu
        mainScreen.longPressNote(0);

        // Step 3: tap delete from context menu
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d -> d.findElement(deleteMenuItem)).click();

        // Step 4: confirm deletion dialog (if present)
        try {
            wait.until(d -> d.findElement(confirmDeleteBtn)).click();
        } catch (Exception e) {
            // No confirmation dialog in this app version — continue
        }

        Assert.assertEquals(mainScreen.getNoteCount(), 0, "Note list should be empty after deletion");
    }
}
