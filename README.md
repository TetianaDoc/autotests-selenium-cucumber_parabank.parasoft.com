# ParaBank WebDriver AutoTests (Selenium & Cucumber)

Automated UI testing framework for [ParaBank](https://parabank.parasoft.com/) built with **Java**, **Gradle**, **Selenium WebDriver 4**, **Cucumber BDD**, and **JUnit 5**.

---

## Project Overview & Architecture

This repository is organized as a multi-module Gradle project following the **Page Object Model (POM)** and **Page Actions** patterns, supporting both **JUnit 5** test suites and **Cucumber** BDD feature specifications.

```text
autotests-selenium-cucumber/
├── autotests-core/                  # Core WebDriver, configuration & encryption utilities
│   └── src/
│       ├── main/java/.../core/
│       │   ├── Browser.java         # Supported browsers (CHROME, FIREFOX, EDGE, SAFARI, IE)
│       │   ├── Environment.java     # Target environments (PROD, UAT, STAGE, DEV)
│       │   ├── OsType.java          # Operating system detection (MAC, LINUX, WINDOWS)
│       │   ├── WebDriverProvider.java # Selenium 4 WebDriver lifecycle & initialization
│       │   └── utils/
│       │       └── EncryptionUtils.java # AES-GCM / PBKDF2 test credential encryption
│       └── test/java/.../core/utils/
│           └── EncryptionUtilsTest.java # Unit tests for EncryptionUtils
│
└── web-tests/                       # ParaBank UI Page Objects, Actions, Cucumber & JUnit tests
    └── src/test/
        ├── java/.../web_auto_tests/
        │   ├── pages/               # Page Objects (BasePage, LandingPage, SignUpPage, AboutUsPage, ProductsPage, ServicesPage)
        │   ├── actions/             # Page Actions encapsulating UI interactions & assertions
        │   ├── model/               # Jackson POJO models for environment-specific YAML test data
        │   ├── steps/               # Cucumber step definitions (LandingPageStepDefs, SignUpPageStepDefs)
        │   ├── tests/               # JUnit 5 test classes (BaseTest, LandingPageTest, SignUpPageTest, AboutUsPageTest, ProductsPageTest)
        │   └── TestRunner.java      # JUnit Platform Suite runner for Cucumber features
        └── resources/
            ├── features/            # Cucumber Gherkin feature files (landing_page.feature, signup_page.feature)
            └── test-data/           # Environment-mapped YAML test data files
```

### Modules
1. **`autotests-core`**: Provides reusable infrastructure:
   - **`WebDriverProvider`**: Manages browser driver instantiation (`ChromeDriver`, `FirefoxDriver`, `EdgeDriver`, `SafariDriver`, `InternetExplorerDriver`) via Selenium 4's built-in **Selenium Manager** and configures implicit timeouts.
   - **`EncryptionUtils`**: Provides `AES/GCM/NoPadding` (`PBKDF2WithHmacSHA256`) encryption and decryption utilities for protecting sensitive test credentials.
2. **`web-tests`**: Contains the ParaBank test implementation:
   - **Pages (`pages/`)**: Extends Selenium's `LoadableComponent` with `PageFactory` `@FindBy` locators and `FluentWait` conditions.
   - **Actions (`actions/`)**: High-level business and UI operations built on top of Page Objects.
   - **BDD Features & Steps (`features/`, `steps/`)**: Gherkin scenarios covering Landing Page elements, navigation (`About Us`, `Services`), user registration (`SignUp`), authentication (`Login`/`Logout`), loan requests, and profile updates.
   - **JUnit 5 Tests (`tests/`)**: Ordered and parameterized JUnit Jupiter test suites.

---

## Tech Stack

| Component | Technology | Version |
| :--- | :--- | :--- |
| **Language** | Java | 11+ (Compatible up to Java 21) |
| **Build Tool** | Gradle | 8.2 |
| **Browser Automation** | Selenium WebDriver | 4.25.0 |
| **BDD Framework** | Cucumber (Java & JUnit Platform Engine) | 7.18.1 |
| **Test Framework** | JUnit 5 (Jupiter & Platform Suite) | 5.11.0 / 1.11.0 |
| **Assertions** | AssertJ | 3.26.3 |
| **Data Serialization** | Jackson Databind & YAML | 2.17.2 |
| **Utilities & Logging** | Google Guava, Lombok, SLF4J | 33.3.0-jre / 8.4 / 2.0.16 |
| **Static Analysis** | SonarLint Gradle Plugin | 3.3.3 |

---

## Prerequisites

- **JDK 11 or higher** (tested with JDK 21)
- **Installed Web Browser**: Firefox (default), Chrome, Edge, or Safari.
  - *Note:* With Selenium 4, **Selenium Manager** automatically downloads and configures the matching browser driver (`chromedriver`, `geckodriver`, etc.) at runtime.

---

## Running Tests

### 1. Build & Compile Project (Without Running UI Tests)
```bash
./gradlew clean testClasses
```

### 2. Run Core Unit Tests (`EncryptionUtilsTest`)
```bash
./gradlew :autotests-core:test
```

### 3. Run All Tests
```bash
./gradlew test
```

### 4. Run Specific JUnit 5 Test Classes
```bash
# Run LandingPageTest
./gradlew :web-tests:test --tests "com.gmail.doctatyana1.web_auto_tests.tests.LandingPageTest"

# Run SignUpPageTest
./gradlew :web-tests:test --tests "com.gmail.doctatyana1.web_auto_tests.tests.SignUpPageTest"

# Run AboutUsPageTest
./gradlew :web-tests:test --tests "com.gmail.doctatyana1.web_auto_tests.tests.AboutUsPageTest"

# Run ProductsPageTest
./gradlew :web-tests:test --tests "com.gmail.doctatyana1.web_auto_tests.tests.ProductsPageTest"
```

### 5. Run Cucumber BDD Suite (`TestRunner`)
```bash
./gradlew :web-tests:test --tests "com.gmail.doctatyana1.web_auto_tests.TestRunner"
```

### 6. Run Static Code Analysis (SonarLint)
```bash
./gradlew sonarlintMain sonarlintTest
```

---

## Configuration Guide

### Browser, Environment & Headless Mode Selection
By default, tests run on **`FIREFOX`** against the **`PROD`** environment (`https://parabank.parasoft.com/`), as defined in `BaseTest`. You can override these via JVM system properties:

- `-Dqa.browser=<CHROME|FIREFOX|EDGE|SAFARI|IE>`
- `-Dqa.env=<PROD|UAT|STAGE|DEV>`
- `-Dqa.headless=<true|false>` (runs `CHROME`, `FIREFOX`, or `EDGE` in headless mode)

Example:
```bash
./gradlew :web-tests:test -Dqa.browser=FIREFOX -Dqa.env=PROD -Dqa.headless=true --tests "com.gmail.doctatyana1.web_auto_tests.tests.AboutUsPageTest"
```

### Continuous Integration (GitHub Actions)
A GitHub Actions workflow (`.github/workflows/ci.yml`) is configured to run automatically on every `push` and `pull_request` to `master` (as well as manual `workflow_dispatch`). It sets up JDK 21 and Firefox on `ubuntu-24.04`, executes `./gradlew test sonarlintMain sonarlintTest -Dqa.browser=FIREFOX -Dqa.env=PROD -Dqa.headless=true`, and uploads the Gradle test reports as build artifacts.

### YAML Test Data
Test data is stored under `web-tests/src/test/resources/test-data/` and mapped by environment (`PROD`, `UAT`, `STAGE`, `DEV`) to POJOs in `com.gmail.doctatyana1.web_auto_tests.model`:
- `signIn-test-data.yaml` → `SignInTestData`
- `signUp-test-data.yaml` → `SignUpTestData`
- `aboutus-test-data.yaml` → `AboutUsTestData`
- `products-test-data.yaml` → `ProductsTestData`
- `services-test-data.yaml` → `ServicesTestData`
- `locations-test-data.yaml`, `adminpage-test-data.yaml`, `restorePassword-test-data.yaml`

### Credential Encryption
`EncryptionUtils` supports encrypting sensitive strings using AES-GCM with a key derived from `web-tests/src/test/resources/decr-pass`. Tests extending `BaseTest` can call `decrypt(encryptedValue)` to decrypt values at runtime.
