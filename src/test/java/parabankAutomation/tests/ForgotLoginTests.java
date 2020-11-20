package parabankAutomation.tests;

import org.testng.annotations.Test;
import parabankAutomation.pages.BasePage;
import parabankAutomation.steps.ForgotLoginSteps;
import parabankAutomation.steps.MainPageSteps;
import parabankAutomation.steps.RegisterSteps;

public class ForgotLoginTests extends BasePage {

  ForgotLoginSteps forgotLoginSteps = new ForgotLoginSteps();
  MainPageSteps mainPageSteps = new MainPageSteps();
  RegisterSteps registerSteps = new RegisterSteps();

  @Test
  public void forgotLoginDetails() {
    mainPageSteps.clickOnForgotLoginInfoLink();
    forgotLoginSteps.completeCustomerLookUpFields();
    forgotLoginSteps.clickOnFindMyLoginInfoButton();
    registerSteps.clickOnLogoutButton();
  }
}
