package com.dvinnik.hellocountry;


import com.applitools.eyes.selenium.Eyes;
import com.dvinnik.hellocountry.utils.Constants;
import io.appium.java_client.AppiumDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class NativeScreenshotTest {

    private WebDriver driver;
    private Eyes eyes;

    private DesiredCapabilities createCapabilities(String apk) {
        // set up appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("platformVersion", "5.0.2");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("app", apk);
        capabilities.setCapability("newCommandTimeout", 600);
        return capabilities;
    }

    @Before
    public void setUp() throws Exception {
        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),
                createCapabilities(Constants.APK_PATH));
        // Create the Eyes instance
        eyes = new Eyes();
        eyes.setApiKey(Constants.API_KEY);
        driver = eyes.open(driver, "Hello Country Visual Test",
                "Hello America - Android");
    }

    @After
    public void tearDown() {
        // If "close" was not called, this will mark the test as aborted.
        eyes.abortIfNotClosed();
        driver.quit();
    }

    @Test
    public void testHelloAmerica() {
        eyes.checkWindow("Hello America");
        eyes.close();
    }

}
