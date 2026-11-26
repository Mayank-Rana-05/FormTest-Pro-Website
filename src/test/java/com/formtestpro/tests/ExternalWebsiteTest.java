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

public class ExternalWebsiteTest {
    private static final String TARGET = "https://www.selenium.dev/selenium/web/web-form.html";
    private WebDriver driver;

    @BeforeClass public void setUp() { driver = DriverFactory.createDriver(); }
    @AfterClass(alwaysRun = true) public void tearDown() { if (driver != null) driver.quit(); }

    @DataProvider(name = "externalCases")
    public Object[][] externalCases() {
        Object[][] data = new Object[50][1];
        for (int i = 1; i <= 50; i++) data[i - 1][0] = i;
        return data;
    }

    @Test(dataProvider = "externalCases")
    public void verifyExternalSeleniumSample(int caseNumber) {
        driver.get(TARGET);
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("web form"), "Unexpected external page title");
        WebElement text = driver.findElement(By.name("my-text"));
        Assert.assertTrue(text.isDisplayed(), "Text input is not visible");
        String value = "FormTestPro external case " + caseNumber;
        text.clear(); text.sendKeys(value);
        Assert.assertEquals(text.getAttribute("value"), value);
        Assert.assertTrue(driver.findElement(By.name("my-password")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.name("my-textarea")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.name("my-select")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("button[type='submit']")).isDisplayed());
    }
}
