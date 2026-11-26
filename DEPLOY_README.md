# FormTest Pro — GitHub Pages + Selenium CI

This repository package combines the browser-based dashboard (`index.html`) with the Java 17, Selenium WebDriver, TestNG and Maven automation project.

## GitHub upload

1. Open the existing `FormTest-Pro-Website` repository.
2. Choose **Add file → Upload files**.
3. Extract this ZIP on your computer and upload the *contents* of the extracted folder to the repository root (including hidden `.github` folder).
4. Choose **Commit changes**.
5. GitHub Pages should continue serving `/index.html` from `main` / root.
6. Open **Actions** and select **FormTest Pro Java Tests**. It also runs automatically after a push. Download `formtestpro-test-reports` from the completed run's Artifacts section.

## Important

GitHub Pages hosts the static dashboard only. Java/Selenium runs separately in GitHub Actions. The designed case counts shown on the dashboard are not actual pass counts; actual results come from the uploaded Maven/TestNG report artifact.

## Local execution

Requirements: JDK 17+, Maven 3.9+, Chrome.

```bash
mvn clean test
```

For headless execution:

```bash
mvn -Dheadless=true -Dbrowser=chrome clean test
```
