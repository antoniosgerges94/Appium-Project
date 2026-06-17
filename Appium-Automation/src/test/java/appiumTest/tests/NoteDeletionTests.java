package appiumTest.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import appiumTest.base.BaseTest;
import appiumTest.pages.MainScreenPage;
import appiumTest.pages.NoteEditorPage;

public class NoteDeletionTests extends BaseTest {

    @Test
    public void deleteSingleNote() {
        MainScreenPage mainScreen = new MainScreenPage(driver);

        // create a note
        mainScreen.tapAddNote();
        NoteEditorPage editor = new NoteEditorPage(driver);
        editor.typeNoteContent("Note to delete");
        editor.goBack();

        Assert.assertEquals(mainScreen.getNoteCount(), 1, "One note should exist before deletion");

        // long press and delete (delete confirmation flow may vary by app version)
        mainScreen.longPressNote(0);
        // TODO: tap delete icon/menu item once located via Appium Inspector
        // TODO: confirm deletion dialog if present

        Assert.assertEquals(mainScreen.getNoteCount(), 0, "Note list should be empty after deletion");
    }
}
