# FormTest Pro — Java Selenium Automation

**Student:** Mayank  
**UID:** 24BCS11295  
**Programme:** Computer Science & Engineering, Chandigarh University

FormTest Pro is a Java-based web form automation project built with Selenium WebDriver, TestNG and Maven. It contains five local demonstration forms and a separate suite that checks the public Selenium sample form page.

![Java](https://img.shields.io/badge/Java-17-orange) ![Selenium](https://img.shields.io/badge/Selenium-4.27-green) ![TestNG](https://img.shields.io/badge/TestNG-7.10-red) ![Maven](https://img.shields.io/badge/Maven-3.9-blue)

## Technology stack
- Java 17+
- Selenium WebDriver 4.27
- TestNG 7.10
- Apache Maven 3.9+
- HTML and CSS demonstration forms

## Test suite

| Module | Designed test invocations |
|---|---:|
| University | 50 |
| Hospital | 50 |
| Banking | 50 |
| E-Commerce | 50 |
| Recruitment | 50 |
| External Selenium sample page | 50 |
| **Total** | **300** |

These are data-driven test invocations defined in the project. They are not a claim that all tests have passed. Actual pass/fail results are produced when the suite is executed.

## Run on Windows (without VS Code)

### Requirements
1. Install JDK 17 or newer.
2. Install Apache Maven 3.9 or newer and add its `bin` directory to `PATH`.
3. Install Chrome, Firefox or Edge.
4. Keep an internet connection available for Maven dependencies and Selenium Manager's driver setup.

Verify installation in Command Prompt:

```bat
java -version
mvn -version
```

Extract the repository ZIP and double-click `run_windows.bat`. Choose Chrome, Firefox or Edge when prompted.

For headless Chrome:

```bat
run_headless.bat
```

## Run from terminal

```bash
mvn clean test -Dbrowser=chrome -Dheadless=false
```

Supported browser values: `chrome`, `firefox`, `edge`.

## Test reports

After execution, open `target/surefire-reports/index.html` (if generated) or inspect the XML/text reports in `target/surefire-reports/`. The GitHub Actions workflow also uploads this folder as a downloadable artifact after each run.

## Repository structure

```text
FormTestPro_Java/
├── .github/workflows/maven-tests.yml
├── pom.xml
├── testng.xml
├── run_windows.bat
├── run_headless.bat
├── index.html
├── SETUP_GUIDE.md
└── src/test/
    ├── java/com/formtestpro/base/DriverFactory.java
    ├── java/com/formtestpro/tests/InternalFormsTest.java
    ├── java/com/formtestpro/tests/ExternalWebsiteTest.java
    └── resources/forms/
        ├── university.html
        ├── hospital.html
        ├── banking.html
        ├── e-commerce.html
        └── recruitment.html
```

## Upload this project to GitHub

1. Sign in to GitHub and create a **New repository** (for example, `FormTest-Pro`).
2. Keep the repository empty; do not add a README or `.gitignore` because they are already included here.
3. Extract this project ZIP on your computer.
4. Open the extracted `FormTestPro_Java` folder, select all its contents (including the hidden `.gitignore` and `.github` folder), and upload them to the new GitHub repository. Alternatively, use Git commands:

```bash
git init
git add .
git commit -m "Initial FormTest Pro Java project"
git branch -M main
git remote add origin https://github.com/YOUR-USERNAME/FormTest-Pro.git
git push -u origin main
```

Replace `YOUR-USERNAME` with your GitHub username and use your actual repository URL.

## GitHub Actions

A workflow is included at `.github/workflows/maven-tests.yml`. After pushing to `main` or `master`, GitHub Actions will set up Java 17, run the Maven/TestNG suite with headless Chrome, and upload the test reports as an artifact. Check the **Actions** tab in the repository for the run status.

## GitHub Pages limitation

`index.html` is a static project overview/demo page and can be published with GitHub Pages. GitHub Pages cannot execute Java, Maven, Selenium or TestNG. The automated test suite runs locally or in GitHub Actions. To enable Pages, open **Settings → Pages**, choose **Deploy from a branch**, select `main` and `/ (root)`, then save.

## Responsible testing

The external suite targets `https://www.selenium.dev/selenium/web/web-form.html`. It checks page elements and fills a sample text field; it does not submit the external form, authenticate, bypass CAPTCHA or perform security exploitation. Only automate websites you own or are authorized to test.
