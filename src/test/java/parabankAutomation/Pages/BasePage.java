package parabankAutomation.Pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static parabankAutomation.Tests.BaseTest.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import parabankAutomation.Tests.BaseTest;

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

  public static void scrollToAndColorThePageElement(Object object) {
    wait.withTimeout(Duration.ofSeconds(10));
    scrollToWebElement(object);
    colorTheElement(object);
  }

  public static void colorAndClickOnThePageElement(By Object) {
    wait.withTimeout(Duration.ofSeconds(10));
    clickOnButton(Object);
  }

  public static void waitForAListToBeClickableArrayList(ArrayList<By> byList) {
    for (By byObject : byList) {
      BaseTest.wait.until(elementToBeClickable(byObject));
    }
  }

  public static void waitForAListToBeClickableList(List<By> byList) {
    for (By byObject : byList) {
      BaseTest.wait.until(elementToBeClickable(byObject));
    }
  }

  public static List<WebElement> getListWithByObject(By selector) {
    wait.until(elementToBeClickable(selector));
    return chromeDriver.findElements(selector);
  }

  public static void checkIfAListContainsAText(By byList, String searchedText) {
    List<WebElement> list = getListWithByObject(byList);
    Assert.assertFalse(list.isEmpty(), "The list of results is empty!");
    boolean found = false;
    for (WebElement element : list) {
      if (element.getText().contains(searchedText)) {
        found = true;
      }
    }
    Assert.assertTrue(found, "The list does not contains: " + searchedText);
  }

  public static void checkIfAListContainsAList(By byList, List<String> searchedText) {
    List<WebElement> list = getListWithByObject(byList);
    Assert.assertFalse(list.isEmpty(), "The list of results is empty!");
    boolean found = false;
    for (WebElement element : list) {
      if (searchedText.contains(element.getText())) {
        found = true;
      }
    }
    Assert.assertTrue(found, "The list does not contains: " + searchedText);
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

  /**
   * Info: executeScript("window.scrollBy(x-pixels,y-pixels)"); Link:
   * https://www.guru99.com/scroll-up-down-selenium-webdriver.html
   */
  public static void scrollIntoThePage(int xAx, int yAx) {
    JavascriptExecutor js = (JavascriptExecutor) chromeDriver;
    js.executeScript("window.scrollBy(" + xAx + "," + yAx + ")");
  }

  /**
   * link https://www.guru99.com/scroll-up-down-selenium-webdriver.html Horizontal scroll on the web
   * page.
   *
   * @param object
   */
  public static void scrollToWebElement(Object object) {
    waitUntilPageIsReady();
    JavascriptExecutor js = (JavascriptExecutor) chromeDriver;
    if (object instanceof By) {
      waitForAListToBeClickableList(List.of((By) object));
      js.executeScript("arguments[0].scrollIntoView();", chromeDriver.findElement((By) object));
    } else {
      js.executeScript("arguments[0].scrollIntoView();", object);
    }
  }

  public static void scrollToTheBottomOfThePage(By footerLinkedIn, By scrollToTop, String s) {
    JavascriptExecutor js = (JavascriptExecutor) chromeDriver;
    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
  }

  public static void removeTheWebElement(Object object) {
    JavascriptExecutor js = (JavascriptExecutor) chromeDriver;
    if (object instanceof By) {
      js.executeScript("arguments[0].remove();", chromeDriver.findElement((By) object));
    } else {
      js.executeScript("arguments[0].remove();", object);
    }
  }

  public static void mouseHoverByJavaScript(Object targetElement) {
    String javaScriptAction =
        "var evObj = document.createEvent('MouseEvents');"
            + "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
            + "arguments[0].dispatchEvent(evObj);";
    JavascriptExecutor js = (JavascriptExecutor) chromeDriver;
    js.executeScript(javaScriptAction, targetElement);
  }

  public static void seleniumHover(By byObject) {
    Actions action = new Actions(chromeDriver);
    WebElement info = chromeDriver.findElement(byObject);
    action.moveToElement(info).build().perform();
  }

  public static void checkExistenceOfElement(By byObject) {
    boolean equals = BaseTest.chromeDriver.findElement(byObject).isDisplayed();
    Assert.assertTrue(equals);
  }

  public static void scrollBottomToTop(By byObject, String str) {
    scrollToWebElement(byObject);
    colorAndClickOnThePageElement(byObject);
    checkIfUrlContentEquals(str);
  }

  public static void clickAndFillInCharacters(By Object, String characters) {
    clickOnButton(Object);
    chromeDriver.findElement(Object).sendKeys(characters);
  }

  public static void doubleClick(By Object) {
    clickOnButton(Object);
    clickOnButton(Object);
  }

  public static void checkIfTheCurrentUrlContainsTheSearchedText(String url) {
    boolean contains = BaseTest.chromeDriver.getCurrentUrl().contains(url);
    Assert.assertTrue(contains);
  }
}
