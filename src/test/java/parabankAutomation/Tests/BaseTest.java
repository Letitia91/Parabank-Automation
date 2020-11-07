package parabankAutomation.Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {

  public static final String PARABANK_WEBSITE = "https://parabank.parasoft.com/parabank/index.htm";
  public static WebDriver chromeDriver;
  public static WebDriverWait wait;

  @BeforeClass
  public static void setupClass() {
    WebDriverManager.chromedriver().setup();
    System.setProperty("webdriver.chrome.silentOutput", "true"); // thi will clear the warnings
  }

  @Before
  public void setupTest() {
    chromeDriver = new ChromeDriver();
    wait = new WebDriverWait(chromeDriver, 10);
  }

  @After
  public void teardown() {
    if (chromeDriver != null) {
      chromeDriver.quit();
    }
  }
}