package appiumTest.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import appiumTest.base.BaseTest;
import appiumTest.pages.MainScreenPage;
import appiumTest.pages.NoteEditorPage;

public class SearchTests extends BaseTest {

    @Test
    public void searchForExistingNote() {
        MainScreenPage mainScreen = new MainScreenPage(driver);

        // create a note
        mainScreen.tapAddNote();
        NoteEditorPage editor = new NoteEditorPage(driver);
        editor.typeNoteContent("Shopping list groceries");
        editor.goBack();

        // search for it
        mainScreen.tapSearchIcon();
        driver.findElement(By.className("android.widget.EditText")).sendKeys("Shopping");

        Assert.assertTrue(mainScreen.getNoteCount() >= 1, "Search should return matching note");
    }

    @Test
    public void searchForNonExistentNote() {
        MainScreenPage mainScreen = new MainScreenPage(driver);

        mainScreen.tapSearchIcon();
        driver.findElement(By.className("android.widget.EditText")).sendKeys("NonExistentTermXYZ");

        Assert.assertEquals(mainScreen.getNoteCount(), 0, "Search with no matches should show empty results");
    }
}
