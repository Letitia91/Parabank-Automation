package parabankAutomation.tests;

import static utils.WebDriverFactoryStaticThreadLocal.*;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

  public static final String PARABANK_WEBSITE = "https://parabank.parasoft.com/parabank/index.htm";
  public static WebDriverWait wait;

  @BeforeMethod
  public void setupTest() {
    setDriver();
    wait = new WebDriverWait(getDriver(), 10);
    getDriver().get(PARABANK_WEBSITE);
    getDriver().manage().window().maximize();
  }

  @AfterMethod
  public void teardown() {
    if (getDriver() != null) {
      closeBrowser();
    }
  }
}
