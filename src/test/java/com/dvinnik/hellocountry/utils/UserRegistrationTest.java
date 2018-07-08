package com.dvinnik.hellocountry.utils;


import com.applitools.eyes.selenium.Eyes;
import com.dvinnik.hellocountry.utils.Constants;
import io.appium.java_client.AppiumDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class UserRegistrationTest {

    private WebDriver driver;

    private DesiredCapabilities createCapabilities(String apk) {
        // set up appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("platformVersion", "8.1.0");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("app", apk);
        return capabilities;
    }

    @Before
    public void setUp() throws Exception {
        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),
                createCapabilities(Constants.APK_PATH));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testUsernameField() throws Exception {
        // Initialize test data
        String username = "dmitry@gmail.com";

        // Find username field
        WebElement usernameField = driver.findElement(By.id("inputUsername"));
        usernameField.sendKeys(username);

        // Validate
        Assert.assertEquals(driver.findElement(By.id("labelUsername")).getText(), username);
    }
}
