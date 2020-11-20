package parabankAutomation.pages;

import org.openqa.selenium.By;

public class RegisterPage extends BasePage {
  public final String REGISTER_HTM = "https://parabank.parasoft.com/parabank/register.htm";
  public final String EXPECTED_RESULT =
      "Your account was created successfully. You are now logged in.";
  public final String LOGOUT_URL = "https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC";
  public final String THIS_USERNAME_ALREADY_EXISTS = "This username already exists.";
  public final String PASSWORDS_DID_NOT_MATCH = "Passwords did not match.";
  public By firstNameField = By.cssSelector("#customer\\.firstName");
  public By lastNameField = By.cssSelector("#customer\\.lastName");
  public By addressField = By.cssSelector("#customer\\.address\\.street");
  public By cityField = By.cssSelector("#customer\\.address\\.city");
  public By stateField = By.cssSelector("#customer\\.address\\.state");
  public By zipCodeField = By.cssSelector("#customer\\.address\\.zipCode");
  public By phoneNumberField = By.cssSelector("#customer\\.phoneNumber");
  public By socialNumberField = By.cssSelector("#customer\\.ssn");
  public By userNameField = By.cssSelector("#customer\\.username");
  public By passwordField = By.cssSelector("#customer\\.password");
  public By confirmField = By.cssSelector("#repeatedPassword");
  public By registerButton =
      By.xpath(
          "//*[@id ='customerForm']//input[@value = 'Register']"); // todo Refactor long selectors
                                                                   // which are containing nth-child
                                                                   // FINISH
  public By accountCreationSuccessful = By.cssSelector("#rightPanel > p");
  public By userNameAlreadyExists = By.cssSelector("#customer\\.username\\.errors");
  public By logoutButton = By.cssSelector("a[href*='/parabank/logout.htm']");
  public By passwordError = By.cssSelector("#repeatedPassword\\.errors");
}
