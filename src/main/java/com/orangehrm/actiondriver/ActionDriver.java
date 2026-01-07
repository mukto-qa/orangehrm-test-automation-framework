package com.orangehrm.actiondriver;

import com.orangehrm.base.BaseTest;
import com.orangehrm.exception.UIActionException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class ActionDriver {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private static final int DEFAULT_EXPLICIT_WAIT = 30;

    public ActionDriver(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(resolveExplicitWait()));
    }

    private int resolveExplicitWait() {
        try {
            return Integer.parseInt(
                    BaseTest.getProperty().getProperty("explicitWait")
            );
        } catch (Exception e) {
            return DEFAULT_EXPLICIT_WAIT;
        }
    }

    private WebElement waitForElementToBeClickable(By locator) {
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (TimeoutException e) {
            throw new UIActionException("Timeout waiting for element to be clickable: " + locator, e);
        }
    }

    private WebElement waitForElementToBeVisible(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            throw new UIActionException("Timeout waiting for element to be visible: " + locator, e);
        }
    }

    public void waitForPageLoad(int timeout) {
        try {
            WebDriverWait pageLoadWait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            pageLoadWait.until(webDriver -> Objects.equals(((JavascriptExecutor) webDriver).executeScript("return document.readyState"), "complete"));
        } catch (TimeoutException e) {
            throw new UIActionException("Page did not load completely within "+timeout+" seconds", e);
        }
    }

    public void click(By locator) {
        try {
            waitForElementToBeClickable(locator).click();
        } catch (Exception e) {
            throw new UIActionException("Failed to click on element: " + locator, e);
        }
    }

    public void enterText(By locator, String text) {
        try {
            WebElement element = waitForElementToBeVisible(locator);
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
            throw new UIActionException("Failed to enter text on element: " + locator, e);
        }
    }

    public String getText(By locator) {
        try {
            return waitForElementToBeVisible(locator).getText();
        } catch (Exception e) {
            throw new UIActionException("Failed to get text on element: " + locator, e);
        }
    }

    public boolean isDisplayed(By locator) {
        try {
            return waitForElementToBeVisible(locator).isDisplayed();
        } catch (Exception e) {
            throw new UIActionException("Element: " + locator + " is not displayed ", e);
        }
    }

    public void scrollToElement(By locator) {
        try {
            WebElement element = waitForElementToBeVisible(locator);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView({block:'center', inline:'nearest'});", element);
        } catch (Exception e) {
            throw new UIActionException("Failed to scroll to element: " + locator, e);
        }
    }

    public void hover(By locator) {
        try {
            WebElement element = waitForElementToBeVisible(locator);
            Actions actions = new Actions(driver);
            actions.moveToElement(element).perform();
        } catch (Exception e) {
            throw new UIActionException("Failed to hover over element: " + locator, e);
        }
    }

    public void selectByVisibleText(By locator, String text) {
        try {
            WebElement element = waitForElementToBeVisible(locator);
            Select select = new Select(element);
            select.selectByVisibleText(text);
        } catch (Exception e) {
            throw new UIActionException("Failed to select value from dropdown: " + locator, e);
        }
    }

    public void selectFromCustomDropdown(By optionLocator) {
        try {
            waitForElementToBeClickable(optionLocator).click();
        } catch (Exception e) {
            throw new UIActionException("Failed to select option: " + optionLocator, e);
        }
    }

    public void pressKey(By locator, Keys key) {
        try {
            WebElement element = waitForElementToBeVisible(locator);
            element.sendKeys(key);
        } catch (Exception e) {
            throw new UIActionException("Failed to send key to element: " + locator, e);
        }
    }
}