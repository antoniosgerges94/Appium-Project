package appiumTest.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import appiumTest.base.BaseTest;
import appiumTest.pages.MainScreenPage;
import appiumTest.pages.NoteEditorPage;

public class NoteCreationTests extends BaseTest {

    @Test
    public void createNoteWithText() {
        MainScreenPage mainScreen = new MainScreenPage(driver);
        mainScreen.tapAddNote();

        NoteEditorPage editor = new NoteEditorPage(driver);
        editor.typeNoteContent("My first Appium test note");
        editor.goBack();

        Assert.assertEquals(mainScreen.getNoteCount(), 1, "One note should appear in the list");
    }

    @Test
    public void createMultipleNotesAndVerifyCount() {
        MainScreenPage mainScreen = new MainScreenPage(driver);

        for (int i = 1; i <= 3; i++) {
            mainScreen.tapAddNote();
            NoteEditorPage editor = new NoteEditorPage(driver);
            editor.typeNoteContent("Note number " + i);
            editor.goBack();
        }

        Assert.assertEquals(mainScreen.getNoteCount(), 3, "Three notes should appear in the list");
    }
}
