package com.formtestpro.tests;

import com.formtestpro.base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import java.nio.file.Path;
import java.util.Locale;

public class InternalFormsTest {
    private static final String[] MODULES = {"University", "Hospital", "Banking", "E-Commerce", "Recruitment"};
    private WebDriver driver;

    @BeforeClass public void setUp() { driver = DriverFactory.createDriver(); }
    @AfterClass(alwaysRun = true) public void tearDown() { if (driver != null) driver.quit(); }

    @DataProvider(name = "internalCases")
    public Object[][] internalCases() {
        Object[][] data = new Object[250][2];
        int row = 0;
        for (String module : MODULES) {
            for (int i = 1; i <= 50; i++) data[row++] = new Object[]{module, i};
        }
        return data;
    }

    @Test(dataProvider = "internalCases")
    public void verifyInternalForm(String module, int caseNumber) throws Exception {
        String file = module.toLowerCase(Locale.ROOT).replace(" ", "-") + ".html";
        Path page = Path.of("src", "test", "resources", "forms", file).toAbsolutePath();
        driver.get(page.toUri().toString());
        Assert.assertTrue(driver.getTitle().contains(module), module + " title check failed");
        WebElement name = driver.findElement(By.id("fullName"));
        WebElement email = driver.findElement(By.id("email"));
        Assert.assertTrue(name.isDisplayed(), "Name field not visible");
        Assert.assertTrue(email.isDisplayed(), "Email field not visible");
        String value = "Mayank Test " + caseNumber;
        name.clear(); name.sendKeys(value);
        email.clear(); email.sendKeys("mayank" + caseNumber + "@example.com");
        Assert.assertEquals(name.getAttribute("value"), value);
        Assert.assertTrue(driver.findElement(By.id("phone")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("category")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("details")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("consent")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("submitBtn")).isEnabled());
        driver.findElement(By.id("submitBtn")).click();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "Form submitted successfully");
    }
}
