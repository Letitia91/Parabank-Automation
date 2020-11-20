package parabankAutomation.pages;

import org.openqa.selenium.By;

public class MainPage extends BasePage {

  public final String OVERVIEW_HTM = "https://parabank.parasoft.com/parabank/overview.htm";
  public final String ACCOUNTS_OVERVIEW = "Accounts Overview";
  public final String FAKE_PASSWORD = "fake password";
  public final String THE_USERNAME_AND_PASSWORD_COULD_NOT_BE_VERIFIED =
      "The username and password could not be verified.";
  public By registerLink = By.cssSelector("a[href*='register.htm']");
  public By userName =
      By.xpath(
          "//*[@class ='login']//input[@name = 'username']"); // todo refactor using more specific
                                                              // selectors FINISH
  public By password = By.xpath("//*[@class ='login']//input[@name = 'password']");
  public By loginButton = By.xpath("//*[@class ='login']//input[@value= 'Log In']");
  public By accountOverview = By.cssSelector("#rightPanel > div > div > h1"); // different message
  public By userNameError = By.cssSelector("#rightPanel > p");
  public By forgotLoginButton = By.cssSelector("a[href*='lookup.htm']");
}
