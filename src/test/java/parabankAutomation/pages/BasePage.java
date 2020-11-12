package parabankAutomation.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static parabankAutomation.pages.MainPage.*;
import static parabankAutomation.tests.BaseTest.*;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.*;
import org.testng.Assert;
import parabankAutomation.services.CustomerService;
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

  public static void assertEqualsText(By Object, String expectedResult) {
    Assert.assertEquals(
        chromeDriver.findElement(Object).getText(),
        expectedResult,
        "The text does not equal" + chromeDriver.findElement(Object).getText() + expectedResult);
  }

  public static void createDefaultCustomerMethod() {
    fillInput(firstNameField, CustomerService.getRandomCustomer().firstNameField);
    fillInput(lastNameField, CustomerService.getRandomCustomer().lastNameField);
    fillInput(addressField, CustomerService.getRandomCustomer().addressField);
    fillInput(cityField, CustomerService.getRandomCustomer().cityField);
    fillInput(stateField, CustomerService.getRandomCustomer().stateField);
    fillInput(zipCodeField, CustomerService.getRandomCustomer().zipCodeField);
    fillInput(phoneNumberField, CustomerService.getRandomCustomer().phoneNumberField);
    fillInput(socialNumberField, CustomerService.getRandomCustomer().socialNumberField);
    fillInput(userNameField, CustomerService.getRandomCustomer().userNameField);
    fillInput(passwordField, CustomerService.getRandomCustomer().passwordField);
    fillInput(confirmField, CustomerService.getDefaultCustomer().confirmField);
  }

  public static void createRandomCustomerMethod() {
    fillInput(firstNameField, CustomerService.getDefaultCustomer().firstNameField);
    fillInput(lastNameField, CustomerService.getDefaultCustomer().lastNameField);
    fillInput(addressField, CustomerService.getDefaultCustomer().addressField);
    fillInput(cityField, CustomerService.getDefaultCustomer().cityField);
    fillInput(stateField, CustomerService.getDefaultCustomer().stateField);
    fillInput(zipCodeField, CustomerService.getDefaultCustomer().zipCodeField);
    fillInput(phoneNumberField, CustomerService.getDefaultCustomer().phoneNumberField);
    fillInput(socialNumberField, CustomerService.getDefaultCustomer().socialNumberField);
    fillInput(userNameField, CustomerService.getDefaultCustomer().userNameField);
    fillInput(passwordField, CustomerService.getDefaultCustomer().passwordField);
    fillInput(confirmField, CustomerService.getDefaultCustomer().confirmField);
  }
}
