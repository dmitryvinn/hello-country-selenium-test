package com.dvinnik.hellocountry;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.dvinnik.hellocountry.utils.Constants.WEBSITE_URL;
import static org.junit.Assert.assertEquals;


public class HybridAppCssTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "geckodriver");
        driver = new FirefoxDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testDesktopFlagState() {
        driver.manage().window().setSize(new Dimension(927, 518));
        driver.get(WEBSITE_URL);
        WebElement flag = getFlag();
        assertEquals(flag.getCssValue("visibility"), "visible");
    }

    @Test
    public void testMobileFlagState() {
        driver.manage().window().setSize(new Dimension(374, 667));
        driver.get(WEBSITE_URL);
        WebElement flag = getFlag();
        assertEquals(flag.getCssValue("display"), "none");
    }

    @Test
    public void testPlatformTransitionFlagState() {
        driver.manage().window().setSize(new Dimension(375,667));
        driver.get(WEBSITE_URL);
        WebElement flag = getFlag();
        assertEquals(flag.getCssValue("visibility"), "hidden");
    }

    private WebElement getFlag() {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.className("countryFlag")));
    }

}
