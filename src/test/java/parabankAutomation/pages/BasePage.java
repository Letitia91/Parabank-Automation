package parabankAutomation.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static utils.WebDriverFactoryStaticThreadLocal.getDriver;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.*;
import org.testng.Assert;
import parabankAutomation.tests.BaseTest;

public class BasePage extends BaseTest {

  public void fillInput(By byObject, String text) {
    waitUntilPageIsReady();
    wait.until(elementToBeClickable(byObject));
    getDriver().findElement(byObject).sendKeys(text);
  }

  public void clickOnButton(By byObject) {
    waitUntilPageIsReady();
    wait.withTimeout(Duration.ofSeconds(10));
    wait.ignoring(ElementClickInterceptedException.class);
    wait.ignoring(StaleElementReferenceException.class);
    wait.until(
        driver ->
            ((JavascriptExecutor) driver)
                .executeScript("return document.readyState")
                .equals("complete"));
    wait.until(elementToBeClickable(byObject));
    getDriver().findElement(byObject).click();
  }

  public void colorAndClickOnThePageElement(By Object) {
    wait.withTimeout(Duration.ofSeconds(10));
    clickOnButton(Object);
  }

  public List<WebElement> getListWithByObject(By selector) {
    wait.until(elementToBeClickable(selector));
    return getDriver().findElements(selector);
  }

  public void checkIfUrlContains(String url) {
    waitUntilPageIsReady();
    wait.withTimeout(Duration.ofSeconds(3));
    wait.until(driver -> getDriver().getCurrentUrl().contains(url));
    boolean contains = getDriver().getCurrentUrl().contains(url);
    Assert.assertTrue(contains, "The url does not contain: " + contains);
  }

  public void checkIfUrlContentEquals(String url) {
    waitUntilPageIsReady();
    wait.withTimeout(Duration.ofSeconds(3));
    wait.until(driver -> getDriver().getCurrentUrl().equals(url));
    boolean equals = getDriver().getCurrentUrl().contentEquals(url);
    Assert.assertTrue(equals, "The url is not equal with: " + equals);
  }

  public void waitUntilPageIsReady() {
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
  public void colorTheElement(final Object object) {
    JavascriptExecutor js = (JavascriptExecutor) getDriver();
    if (object instanceof By) {
      js.executeScript(
          "arguments[0].style.border='3px solid red'", getDriver().findElement((By) object));
    } else {
      js.executeScript("arguments[0].style.border='3px solid red'", object);
    }
  }

  public void assertEqualsText(By Object, String expectedResult) {
    waitUntilPageIsReady();
    Assert.assertEquals(
        getDriver().findElement(Object).getText(),
        expectedResult,
        "The text does not equal" + getDriver().findElement(Object).getText() + expectedResult);
  }
}
