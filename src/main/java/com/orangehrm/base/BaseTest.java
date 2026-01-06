package com.orangehrm.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    protected static Properties prop;
    protected WebDriver driver;


    @BeforeSuite
    public void loadConfig() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
        prop.load(fis);
    }

    @BeforeMethod
    public void setup() {
        System.out.println("Setting up driver for: " + this.getClass().getSimpleName());
        launchBrowser();
        configureBrowser();
    }

    private void launchBrowser() {
        String browser = prop.getProperty("browser");
        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser not recognized");
        }
    }

    private void configureBrowser() {
        // Implicit wait
        int implicitWait = Integer.parseInt(prop.getProperty("implicitWait"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        // Maximize the browser
        driver.manage().window().maximize();
        // Navigate to URL
        try {
            driver.get(prop.getProperty("baseUrl"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
