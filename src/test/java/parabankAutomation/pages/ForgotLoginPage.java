package parabankAutomation.pages;

import org.openqa.selenium.By;

public class ForgotLoginPage extends BasePage {
  public final String FORGOT_LOGIN = "https://parabank.parasoft.com/parabank/lookup.htm";
  public final String YOU_ARE_NOW_LOGGED_IN =
      "Your login information was located successfully. You are now logged in.";
  // Customer Lookup
  public By firstNameLookup = By.cssSelector("#firstName");
  public By lastNameLookup = By.cssSelector("#lastName");
  public By addressLookup = By.cssSelector("#address\\.street");
  public By cityLookup = By.cssSelector("#address\\.city");
  public By stateLookup = By.cssSelector("#address\\.state");
  public By zipCodeLookup = By.cssSelector("#address\\.zipCode");
  public By socialNumberLookup = By.cssSelector("#ssn");
  public By findMyLoginInfoButton =
      By.xpath("//input[@value = 'Find My Login Info']"); // todo refactor FINISH
  public By loginInfoLocated =
      By.xpath(
          "//p[contains(text(), 'Your login information was located successfully')]"); // todo
                                                                                       // refactor
                                                                                       // FINISH
}
