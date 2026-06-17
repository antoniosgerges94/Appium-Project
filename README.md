# Appium Notes Test Automation

A mobile UI test automation framework for the **Fossify Notes Android application**, built using **Appium**, **Java**, and the **Page Object Model (POM)** design pattern. The framework is designed to provide maintainable, scalable, and reusable automated tests for validating core application functionality.

---

## Overview

This project automates end-to-end user interactions within the Fossify Notes application, covering key functionalities such as note creation, editing, deletion, search, and navigation.

By implementing the **Page Object Model (POM)** architecture, UI element locators and screen interactions are separated from test logic, improving maintainability and reducing duplication across test cases.

---

## Technology Stack

* **Java 17**
* **Appium (UiAutomator2 Driver)** – Mobile automation framework
* **Selenium WebDriver** – Underlying automation protocol
* **TestNG** – Test execution and assertions
* **Maven** – Dependency management and build automation

---

## Project Structure

```text
src/test/java/appiumTest/
├── base/
│   └── BaseTest.java
│       └── Driver initialization, configuration, and teardown
│
├── pages/
│   ├── MainScreenPage.java
│   │   └── Notes list screen interactions
│   ├── NoteEditorPage.java
│   │   └── Note creation and editing interactions
│   └── SettingsPage.java
│       └── Settings screen interactions
│
└── tests/
    ├── SmokeTests.java
    ├── NoteCreationTests.java
    ├── NoteEditingTests.java
    ├── NoteDeletionTests.java
    ├── SearchTests.java
    └── NavigationTests.java
```

### Design Pattern

The framework follows the **Page Object Model (POM)** pattern:

* UI element locators are maintained within page classes.
* Business actions and screen interactions are encapsulated in page objects.
* Test classes focus solely on validation and assertions.
* UI changes require updates in a single location, reducing maintenance effort.

---

## Test Coverage

| Module        | Test Scenarios                                                                      |
| ------------- | ----------------------------------------------------------------------------------- |
| Smoke Tests   | Application launch, Floating Action Button (FAB) visibility, empty-state validation |
| Note Creation | Create a single note, create multiple notes                                         |
| Note Editing  | Modify note content and verify persistence after reopening                          |
| Note Deletion | Delete notes and validate list updates                                              |
| Search        | Search existing notes and validate no-result scenarios                              |
| Navigation    | Navigate to Settings and return to the main screen                                  |

---

## Prerequisites

Before running the test suite, ensure the following are installed:

* Java 17+
* Maven
* Android Studio
* Android Emulator or Physical Android Device
* Appium Server

---

## Running the Tests

### 1. Start an Android Device

Launch an Android Emulator (configured for **My Virtual Emulator**) or connect a physical Android device.

### 2. Start Appium Server

```bash
appium
```

### 3. Execute the Test Suite

From the project root directory:

```bash
mvn test
```

Alternatively, from Eclipse:

```text
Right-click testng.xml
→ Run As
→ TestNG Suite
```

---

## Known Limitations

* Some element locators currently use placeholder values based on common Android UI patterns and should be replaced with actual resource IDs obtained using **Appium Inspector**.
* Certain deletion workflow locators and actions are marked as TODO items until the application's exact UI behavior is fully inspected and mapped.

---

## Future Enhancements

* GitHub Actions CI/CD integration
* Automated execution on Android emulators during pull requests and pushes
* Enhanced reporting using Extent Reports or Allure Reports
* Data-driven testing support
* Cross-device and cross-version Android execution

---

## Author

**Antonios Gerges Hakim Eskandar**
Software QA/QC Engineer

📧 Email: [antoniosgerges94@gmail.com](mailto:antoniosgerges94@gmail.com)

🔗 LinkedIn: https://linkedin.com/in/antonios-eskandar

🐙 GitHub: https://github.com/antoniosgerges94
