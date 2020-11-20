package parabankAutomation.steps;

import static parabankAutomation.services.CustomerService.getRandomCustomer;

import parabankAutomation.pages.MainPage;
import parabankAutomation.pages.RegisterPage;
import parabankAutomation.pojos.Customer;
import parabankAutomation.services.CustomerService;

public class RegisterSteps extends RegisterPage {
  Customer randomCustomer = CustomerService.getRandomCustomer();
  Customer defaultCustomer = CustomerService.getDefaultCustomer();
  MainPage mainPage = new MainPage();

  public void clickOnLogoutButton() {
    clickOnButton(logoutButton);
    checkIfUrlContentEquals(LOGOUT_URL);
  }

  // run only when a new default account is needed
  public void createDefaultAccountMethod() {
    checkIfUrlContains(REGISTER_HTM);
    createDefaultCustomerMethod();
    clickOnButton(registerButton);
    checkIfUrlContentEquals(REGISTER_HTM);
    assertEqualsText(accountCreationSuccessful, EXPECTED_RESULT);
  }

  // has to be run after createDefaultAccountMethod
  public void createDoubleDefaultAccountMethod() {
    checkIfUrlContains(REGISTER_HTM);
    createDefaultCustomerMethod();
    clickOnButton(registerButton);
    checkIfUrlContentEquals(REGISTER_HTM);
    assertEqualsText(userNameAlreadyExists, THIS_USERNAME_ALREADY_EXISTS);
  }

  public void createRandomAccountMethod() {
    checkIfUrlContains(REGISTER_HTM);
    Customer randomCustomer = getRandomCustomer();
    createRandomCustomerMethod();
    clickOnButton(registerButton);
    checkIfUrlContentEquals(REGISTER_HTM);
    assertEqualsText(accountCreationSuccessful, EXPECTED_RESULT);
  }

  public void createFakerAccountMethod() {
    checkIfUrlContains(REGISTER_HTM);
    createFakerCustomerMethod();
    clickOnButton(registerButton);
    checkIfUrlContentEquals(REGISTER_HTM);
    assertEqualsText(accountCreationSuccessful, EXPECTED_RESULT);
  }

  public void passwordAndConfirmNotTheSameMethod() {
    clickOnButton(mainPage.registerLink);
    checkIfUrlContains(REGISTER_HTM);
    fillInput(firstNameField, defaultCustomer.getFirstNameField());
    fillInput(lastNameField, defaultCustomer.getLastNameField());
    fillInput(addressField, defaultCustomer.getAddressField());
    fillInput(cityField, defaultCustomer.getCityField());
    fillInput(stateField, defaultCustomer.getStateField());
    fillInput(zipCodeField, defaultCustomer.getZipCodeField());
    fillInput(phoneNumberField, defaultCustomer.getPhoneNumberField());
    fillInput(socialNumberField, defaultCustomer.getSocialNumberField());
    fillInput(userNameField, defaultCustomer.getUserNameField());
    fillInput(passwordField, defaultCustomer.getPasswordField());
    fillInput(confirmField, randomCustomer.getConfirmField());
    clickOnButton(registerButton);
    assertEqualsText(passwordError, PASSWORDS_DID_NOT_MATCH);
  }

  public void createRandomCustomerMethod() {
    fillInput(firstNameField, randomCustomer.getFirstNameField());
    fillInput(lastNameField, randomCustomer.getLastNameField());
    fillInput(addressField, randomCustomer.getAddressField());
    fillInput(cityField, randomCustomer.getCityField());
    fillInput(stateField, randomCustomer.getStateField());
    fillInput(zipCodeField, randomCustomer.getZipCodeField());
    fillInput(phoneNumberField, randomCustomer.getPhoneNumberField());
    fillInput(socialNumberField, randomCustomer.getSocialNumberField());
    fillInput(userNameField, randomCustomer.getUserNameField());
    fillInput(passwordField, randomCustomer.getPasswordField());
    fillInput(confirmField, randomCustomer.getConfirmField());
  }

  public void createFakerCustomerMethod() {
    Customer fakerCustomer = CustomerService.getFakerCustomer();
    fillInput(firstNameField, fakerCustomer.getFirstNameField());
    fillInput(lastNameField, fakerCustomer.getLastNameField());
    fillInput(addressField, fakerCustomer.getAddressField());
    fillInput(cityField, fakerCustomer.getCityField());
    fillInput(stateField, fakerCustomer.getStateField());
    fillInput(zipCodeField, fakerCustomer.getZipCodeField());
    fillInput(phoneNumberField, fakerCustomer.getPhoneNumberField());
    fillInput(socialNumberField, fakerCustomer.getSocialNumberField());
    fillInput(userNameField, fakerCustomer.getUserNameField());
    fillInput(passwordField, fakerCustomer.getPasswordField());
    fillInput(confirmField, fakerCustomer.getConfirmField());
  }

  public void createDefaultCustomerMethod() {
    fillInput(firstNameField, defaultCustomer.getFirstNameField());
    fillInput(lastNameField, defaultCustomer.getLastNameField());
    fillInput(addressField, defaultCustomer.getAddressField());
    fillInput(cityField, defaultCustomer.getCityField());
    fillInput(stateField, defaultCustomer.getStateField());
    fillInput(zipCodeField, defaultCustomer.getZipCodeField());
    fillInput(phoneNumberField, defaultCustomer.getPhoneNumberField());
    fillInput(socialNumberField, defaultCustomer.getSocialNumberField());
    fillInput(userNameField, defaultCustomer.getUserNameField());
    fillInput(passwordField, defaultCustomer.getPasswordField());
    fillInput(confirmField, defaultCustomer.getConfirmField());
  }
}
