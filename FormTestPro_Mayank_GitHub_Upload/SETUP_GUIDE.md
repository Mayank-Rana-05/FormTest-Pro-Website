# FormTest Pro Java — Setup Guide (Windows, no VS Code)

## Requirements
- JDK 17 or newer (not just a JRE)
- Apache Maven 3.9 or newer
- Google Chrome, Firefox or Microsoft Edge
- Internet connection for the first Maven/Selenium setup and for the external test collection

## Install and verify
1. Install a JDK 17+ distribution and configure `JAVA_HOME` and `Path`.
2. Install Apache Maven 3.9+ and add Maven's `bin` folder to `Path`.
3. Open Command Prompt and verify:
   - `java -version`
   - `mvn -version`
4. Extract the ZIP to a normal folder (not inside the ZIP preview).

## Run with no IDE
Double-click `run_windows.bat`, choose a browser and wait for the test run to finish. Selenium Manager can resolve the matching browser driver automatically on supported systems. If driver resolution is blocked, update the browser or configure the driver manually.

To run headless Chrome: double-click `run_headless.bat`.

## Run from Command Prompt
From the extracted project folder:

```bat
mvn clean test -Dbrowser=chrome -Dheadless=false
```

Supported browser values: `chrome`, `firefox`, `edge`.

## Reports
TestNG/Surefire reports are generated under `target/surefire-reports/`. Open `index.html` or inspect the XML and text reports. A test count is not a pass count: use the latest execution report for actual Passed, Failed and Skipped numbers.

## Test scope
- Internal collection: 5 local demonstration forms × 50 data-driven invocations = 250 executions.
- External collection: 50 data-driven checks against `https://www.selenium.dev/selenium/web/web-form.html`.
- Internal HTML pages are in `src/test/resources/forms/`.
- TestNG suite configuration is `testng.xml`.

The external suite performs read-only page/control checks and fills a sample text field; it does not submit the external form, authenticate, bypass CAPTCHA or attempt security exploitation. Use external automation only on systems you own or are authorized to test.

## Troubleshooting
- `java is not recognized`: install JDK and add its `bin` directory to `Path`.
- `mvn is not recognized`: install Maven and add its `bin` directory to `Path`.
- Browser cannot start: update the browser; Selenium Manager needs network access on first driver setup.
- External tests fail: check internet connectivity and whether the public sample page is reachable. Internal tests can be run separately by temporarily selecting only the first test in `testng.xml` or by using TestNG groups/configuration in a future extension.
