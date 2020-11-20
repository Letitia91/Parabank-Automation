package parabankAutomation.steps;

import static parabankAutomation.services.CustomerService.getDefaultCustomer;

import parabankAutomation.pages.ForgotLoginPage;
import parabankAutomation.pages.MainPage;
import parabankAutomation.pojos.Customer;

public class ForgotLoginSteps extends ForgotLoginPage {
  MainPage mainPage = new MainPage();

  public void completeCustomerLookUpFields() {

    checkIfUrlContains(FORGOT_LOGIN);
    Customer defaultCustomer = getDefaultCustomer();
    fillInput(firstNameLookup, defaultCustomer.getFirstNameField());
    fillInput(lastNameLookup, defaultCustomer.getLastNameField());
    fillInput(addressLookup, defaultCustomer.getAddressField());
    fillInput(cityLookup, defaultCustomer.getCityField());
    fillInput(stateLookup, defaultCustomer.getStateField());
    fillInput(zipCodeLookup, defaultCustomer.getZipCodeField());
    fillInput(socialNumberLookup, defaultCustomer.getSocialNumberField());
  }

  public void clickOnFindMyLoginInfoButton() {
    clickOnButton(findMyLoginInfoButton);
    assertEqualsText(loginInfoLocated, YOU_ARE_NOW_LOGGED_IN);
  }
}
