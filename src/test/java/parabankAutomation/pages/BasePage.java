package parabankAutomation.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static parabankAutomation.tests.BaseTest.*;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.*;
import org.testng.Assert;
import parabankAutomation.tests.BaseTest;

public class BasePage {

  public static void fillInput(By byObject, String text) {
    wait.until(elementToBeClickable(byObject));
    chromeDriver.findElement(byObject).sendKeys(text);
  }

  public static void clickOnButton(By byObject) {
    wait.withTimeout(Duration.ofSeconds(10));
    wait.ignoring(ElementClickInterceptedException.class);
    wait.ignoring(StaleElementReferenceException.class);
    wait.until(
        driver ->
            ((JavascriptExecutor) driver)
                .executeScript("return document.readyState")
                .equals("complete"));
    wait.until(elementToBeClickable(byObject));
    chromeDriver.findElement(byObject).click();
    waitUntilPageIsReady();
  }

  public static void colorAndClickOnThePageElement(By Object) {
    wait.withTimeout(Duration.ofSeconds(10));
    clickOnButton(Object);
  }

  public static List<WebElement> getListWithByObject(By selector) {
    wait.until(elementToBeClickable(selector));
    return chromeDriver.findElements(selector);
  }

  public static void checkIfUrlContains(String url) {
    waitUntilPageIsReady();
    wait.withTimeout(Duration.ofSeconds(3));
    wait.until(driver -> BaseTest.chromeDriver.getCurrentUrl().contains(url));
    boolean contains = chromeDriver.getCurrentUrl().contains(url);
    Assert.assertTrue(contains, "The url does not contain: " + contains);
  }

  public static void checkIfUrlContentEquals(String url) {
    waitUntilPageIsReady();
    wait.withTimeout(Duration.ofSeconds(3));
    wait.until(driver -> BaseTest.chromeDriver.getCurrentUrl().equals(url));
    boolean equals = chromeDriver.getCurrentUrl().contentEquals(url);
    Assert.assertTrue(equals, "The url is not equal with: " + equals);
  }

  public static void waitUntilPageIsReady() {
    wait.until(
        driver ->
            ((JavascriptExecutor) driver)
                .executeScript("return document.readyState")
                .equals("complete"));
  }

  /**
   * This method will receive an By or WebElement object which will be colored with red This
   * arguments[0] is the WebElement
   *
   * @param object
   */
  public static void colorTheElement(final Object object) {
    JavascriptExecutor js = (JavascriptExecutor) chromeDriver;
    if (object instanceof By) {
      js.executeScript(
          "arguments[0].style.border='3px solid red'", chromeDriver.findElement((By) object));
    } else {
      js.executeScript("arguments[0].style.border='3px solid red'", object);
    }
  }
}
