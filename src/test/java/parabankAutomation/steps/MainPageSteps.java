package parabankAutomation.steps;

import static parabankAutomation.services.CustomerService.getDefaultCustomer;

import parabankAutomation.pages.MainPage;
import parabankAutomation.pojos.Customer;

public class MainPageSteps extends MainPage {
  final Customer defaultCustomer = getDefaultCustomer();

  public void loginWithCorrectUserMethod() {
    fillInput(userName, defaultCustomer.getUserNameField());
    fillInput(password, defaultCustomer.getPasswordField());
  }

  public void clickOnLoginButton() {
    clickOnButton(loginButton);
    checkIfUrlContains(OVERVIEW_HTM);
    assertEqualsText(accountOverview, ACCOUNTS_OVERVIEW);
  }

  public void loginWithIncorrectUserMethod() {
    fillInput(userName, defaultCustomer.getUserNameField());
    fillInput(password, FAKE_PASSWORD);
    clickOnButton(loginButton);
    assertEqualsText(userNameError, THE_USERNAME_AND_PASSWORD_COULD_NOT_BE_VERIFIED);
  }

  public void clickOnRegister() {
    clickOnButton(registerLink);
  }

  public void clickOnForgotLoginInfoLink() {
    clickOnButton(forgotLoginButton);
  }
}
