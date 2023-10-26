package com.ageoflearning.qa.selenium.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Properties;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseFramework {

    protected WebDriver driver;

    protected Wait<WebDriver> wait;

    private static final Logger LOG = LoggerFactory.getLogger(BaseFramework.class);

    private static final String CONFIG_FILE = "./conf/automation.properties";

    private static final String DRIVER_FIREFOX = "firefox";

    private static final String DRIVER_CHROME = "chrome";

    private static final String DRIVER_SAFARI = "safari";

    private static final String DRIVER_ANDROID = "android";

    private static final String DRIVER_IOS = "ios";

    private static Properties configuration;

    @Rule
    public final JUnitSoftAssertions softly = new JUnitSoftAssertions();

    @BeforeClass
    public static void beforeClass() throws IOException {
        configuration = new Properties();
        FileInputStream input;

        LOG.info("Loading in configuration file.");
        input = new FileInputStream(new File(CONFIG_FILE));
        configuration.loadFromXML(input);
        input.close();
    }

    @Before
    public void setUpBefore() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        // Which driver to use
        if (DRIVER_CHROME.equalsIgnoreCase(configuration.getProperty("BROWSER"))) {
            options.addArguments("disable-infobars");
            options.setAcceptInsecureCerts(true);
            options.addArguments("--incognito");
            options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        } else if (DRIVER_FIREFOX.equalsIgnoreCase(configuration.getProperty("BROWSER"))) {
            //Not Implemented
        } else if (DRIVER_SAFARI.equalsIgnoreCase(configuration.getProperty("BROWSER"))) {
            //Not Implemented
        } else if (DRIVER_ANDROID.equalsIgnoreCase(configuration.getProperty("BROWSER"))) {
            ///Not Implemented
        } else if (DRIVER_IOS.equalsIgnoreCase(configuration.getProperty("BROWSER"))) {
            //Not Implemented
        }
        // Define fluent wait
        wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getConfiguration(String config) {
        return configuration.getProperty(config);
    }

    public final boolean doesURLContains(String pageURL) {
        return wait.until(ExpectedConditions.urlContains(pageURL));
    }

    @After
    public void tearDownAfter() {
        LOG.info("Quitting driver.");
        driver.quit();
        driver = null;
    }
}
