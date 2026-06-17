package appiumTest.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import appiumTest.base.BaseTest;
import appiumTest.pages.MainScreenPage;
import appiumTest.pages.NoteEditorPage;

public class NoteEditingTests extends BaseTest {

    @Test
    public void editExistingNoteAndVerifyPersistence() {
        MainScreenPage mainScreen = new MainScreenPage(driver);

        // create a note first
        mainScreen.tapAddNote();
        NoteEditorPage editor = new NoteEditorPage(driver);
        editor.typeNoteContent("Original content");
        editor.goBack();

        // open and edit it
        mainScreen.tapNoteByIndex(0);
        editor.clearNoteContent();
        editor.typeNoteContent("Updated content");
        editor.goBack();

        // reopen and verify
        mainScreen.tapNoteByIndex(0);
        Assert.assertTrue(editor.getNoteContent().contains("Updated content"),
                "Edited content should persist after reopening the note");
    }
}
