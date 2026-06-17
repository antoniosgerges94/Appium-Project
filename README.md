# Appium Notes Test Automation

Mobile UI test automation suite for the [Fossify Notes](https://github.com/FossifyOrg/Notes) Android app, built using the Page Object Model (POM) design pattern.

## Tech Stack

- **Java 17**
- **Appium** (UiAutomator2 driver) — mobile automation
- **Selenium WebDriver** — underlying driver protocol
- **TestNG** — test runner and assertions
- **Maven** — build and dependency management

## Project Structure

```
src/test/java/appiumTest/
├── base/
│   └── BaseTest.java          # Driver setup/teardown, shared across all tests
├── pages/
│   ├── MainScreenPage.java    # Notes list screen interactions
│   ├── NoteEditorPage.java    # Note creation/editing screen interactions
│   └── SettingsPage.java      # Settings screen interactions
└── tests/
    ├── SmokeTests.java         # App launch and basic UI presence
    ├── NoteCreationTests.java  # Creating single/multiple notes
    ├── NoteEditingTests.java   # Editing and verifying persistence
    ├── NoteDeletionTests.java  # Deleting notes
    ├── SearchTests.java        # Searching existing/non-existing notes
    └── NavigationTests.java    # Navigating to/from Settings
```

The Page Object Model keeps element locators and interaction logic in the `pages` package, separate from test assertions in the `tests` package, so a UI change only requires updating one page object instead of every test that touches that screen.

## Test Coverage

| Area | Scenarios |
|---|---|
| Smoke | App launches, FAB button visible, empty state on fresh install |
| Note creation | Single note, multiple notes |
| Note editing | Edit and verify content persists after reopening |
| Note deletion | Delete a note and confirm list updates |
| Search | Search returns matches / returns empty for no matches |
| Navigation | Open Settings, navigate back to main screen |

## Running the Tests

1. Start an Android emulator (project is configured for an AVD named `My Virtual Emulator`) or connect a physical device.
2. Start the Appium server: `appium`
3. Run the suite from the project root:
   ```
   mvn test
   ```
   Or, in Eclipse, right-click `testng.xml` → **Run As → TestNG Suite**.

## Known Limitations / Next Steps

- Element locators in the `pages` classes are currently placeholders based on common Android UI patterns. They need to be replaced with real `resource-id`s captured via [Appium Inspector](https://github.com/appium/appium-inspector) against the actual Fossify Notes app.
- `NoteDeletionTests` has TODOs for the delete menu item and confirmation dialog, since the exact UI flow depends on the app's long-press menu, which hasn't been inspected yet.
- Planned: CI integration (GitHub Actions) to run the suite against an emulator on every push.

## Author

Antonios Gerges Hakim Eskandar
Software QA/QC Engineer
📧 antoniosgerges94@gmail.com
🔗 linkedin.com/in/antonios-eskandar
🐙 github.com/antoniosgerges94
