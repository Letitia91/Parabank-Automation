package parabankAutomation.pages;

import org.openqa.selenium.By;
import parabankAutomation.services.CustomerService;

public class MainPage extends BasePage {

  public static final String REGISTER_HTM = "https://parabank.parasoft.com/parabank/register.htm";
  public static final String EXPECTED_RESULT =
      "Your account was created successfully. You are now logged in.";
  public static final String LOGOUT_URL =
      "https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC";
  public static final String THIS_USERNAME_ALREADY_EXISTS = "This username already exists.";
  public static final String OVERVIEW_HTM = "https://parabank.parasoft.com/parabank/overview.htm";
  public static final String ACCOUNTS_OVERVIEW = "Accounts Overview";
  public static final String FAKE_PASSWORD = "fake password";
  public static final String THE_USERNAME_AND_PASSWORD_COULD_NOT_BE_VERIFIED =
      "The username and password could not be verified.";
  public static final String FORGOT_LOGIN = "https://parabank.parasoft.com/parabank/lookup.htm";
  public static final String YOU_ARE_NOW_LOGGED_IN =
      "Your login information was located successfully. You are now logged in.";
  public static final String PASSWORDS_DID_NOT_MATCH = "Passwords did not match.";
  // Sign Up
  public static By registerLink = By.cssSelector("a[href*='register.htm']");
  public static By firstNameField = By.cssSelector("#customer\\.firstName");
  public static By lastNameField = By.cssSelector("#customer\\.lastName");
  public static By addressField = By.cssSelector("#customer\\.address\\.street");
  public static By cityField = By.cssSelector("#customer\\.address\\.city");
  public static By stateField = By.cssSelector("#customer\\.address\\.state");
  public static By zipCodeField = By.cssSelector("#customer\\.address\\.zipCode");
  public static By phoneNumberField = By.cssSelector("#customer\\.phoneNumber");
  public static By socialNumberField = By.cssSelector("#customer\\.ssn");
  public static By userNameField = By.cssSelector("#customer\\.username");
  public static By passwordField = By.cssSelector("#customer\\.password");
  public static By confirmField = By.cssSelector("#repeatedPassword");
  public static By registerButton =
      By.cssSelector("#customerForm > table > tbody > tr:nth-child(13) > td:nth-child(2) > input");
  public static By accountCreationSuccessful = By.cssSelector("#rightPanel > p");
  public static By userNameAlreadyExists = By.cssSelector("#customer\\.username\\.errors");
  public static By logoutButton = By.cssSelector("a[href*='/parabank/logout.htm']");
  public static By passwordError = By.cssSelector("#repeatedPassword\\.errors");

  // Customer Login
  public static By userName = By.cssSelector("#loginPanel > form > div:nth-child(2) > input");
  public static By password = By.cssSelector("#loginPanel > form > div:nth-child(4) > input");
  public static By loginButton = By.cssSelector("#loginPanel > form > div:nth-child(5) > input");
  public static By accountOverview = By.cssSelector("#rightPanel > div > div > h1");
  public static By userNameError = By.cssSelector("#rightPanel > p");
  public static By forgotLoginButton = By.cssSelector("a[href*='lookup.htm']");
  // Customer Lookup
  public static By firstNameLookup = By.cssSelector("#firstName");
  public static By lastNameLookup = By.cssSelector("#lastName");
  public static By addressLookup = By.cssSelector("#address\\.street");
  public static By cityLookup = By.cssSelector("#address\\.city");
  public static By stateLookup = By.cssSelector("#address\\.state");
  public static By zipCodeLookup = By.cssSelector("#address\\.zipCode");
  public static By socialNumberLookup = By.cssSelector("#ssn");
  public static By findMyLoginInfoButton =
      By.cssSelector("#lookupForm > table > tbody > tr:nth-child(8) > td:nth-child(2) > input");
  public static By loginInfoLocated = By.cssSelector("#rightPanel > p:nth-child(2)");

  // Create Account
  public static void createDefaultAccountMethod() {
    waitUntilPageIsReady();
    clickOnButton(registerLink);
    checkIfUrlContains(REGISTER_HTM);
    createDefaultCustomerMethod();
    clickOnButton(registerButton);
    checkIfUrlContentEquals(REGISTER_HTM);
    waitUntilPageIsReady();
    assertEqualsText(accountCreationSuccessful, EXPECTED_RESULT);
    clickOnButton(logoutButton);
    checkIfUrlContentEquals(LOGOUT_URL);
  }

  public static void
      createDoubleDefaultAccountMethod() { // has to be run after createDefaultAccountMethod
    waitUntilPageIsReady();
    clickOnButton(registerLink);
    checkIfUrlContains(REGISTER_HTM);
    createRandomCustomerMethod();
    clickOnButton(registerButton);
    checkIfUrlContentEquals(REGISTER_HTM);
    waitUntilPageIsReady();
    assertEqualsText(userNameAlreadyExists, THIS_USERNAME_ALREADY_EXISTS);
  }

  public static void loginWithCorrectUserMethod() {
    waitUntilPageIsReady();
    fillInput(userName, CustomerService.getDefaultCustomer().userNameField);
    fillInput(password, CustomerService.getDefaultCustomer().passwordField);
    clickOnButton(loginButton);
    checkIfUrlContentEquals(OVERVIEW_HTM);
    assertEqualsText(accountOverview, ACCOUNTS_OVERVIEW);
  }

  public static void loginWithIncorrectUserMethod() {
    waitUntilPageIsReady();
    fillInput(userName, CustomerService.getDefaultCustomer().userNameField);
    fillInput(password, FAKE_PASSWORD);
    clickOnButton(loginButton);
    waitUntilPageIsReady();
    assertEqualsText(userNameError, THE_USERNAME_AND_PASSWORD_COULD_NOT_BE_VERIFIED);
  }

  public static void forgotLoginMethod() {
    waitUntilPageIsReady();
    clickOnButton(forgotLoginButton);
    checkIfUrlContains(FORGOT_LOGIN);
    fillInput(firstNameLookup, CustomerService.getDefaultCustomer().firstNameField);
    fillInput(lastNameLookup, CustomerService.getDefaultCustomer().lastNameField);
    fillInput(addressLookup, CustomerService.getDefaultCustomer().addressField);
    fillInput(cityLookup, CustomerService.getDefaultCustomer().cityField);
    fillInput(stateLookup, CustomerService.getDefaultCustomer().stateField);
    fillInput(zipCodeLookup, CustomerService.getDefaultCustomer().zipCodeField);
    fillInput(socialNumberLookup, CustomerService.getDefaultCustomer().socialNumberField);
    clickOnButton(findMyLoginInfoButton);
    assertEqualsText(loginInfoLocated, YOU_ARE_NOW_LOGGED_IN);
  }

  public static void createRandomAccountMethod() {
    waitUntilPageIsReady();
    clickOnButton(registerLink);
    checkIfUrlContains(REGISTER_HTM);
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
    fillInput(confirmField, CustomerService.getRandomCustomer().confirmField);
    clickOnButton(registerButton);
    checkIfUrlContentEquals(REGISTER_HTM);
    waitUntilPageIsReady();
    assertEqualsText(accountCreationSuccessful, EXPECTED_RESULT);
    clickOnButton(logoutButton);
    checkIfUrlContentEquals(LOGOUT_URL);
  }

  public static void passwordAndConfirmNotTheSameMethod() {
    waitUntilPageIsReady();
    clickOnButton(registerLink);
    checkIfUrlContains(REGISTER_HTM);

    clickOnButton(registerButton);
    assertEqualsText(passwordError, PASSWORDS_DID_NOT_MATCH);
  }
}
