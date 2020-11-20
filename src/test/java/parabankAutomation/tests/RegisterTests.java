package parabankAutomation.tests;

import org.testng.annotations.Test;
import parabankAutomation.pages.BasePage;
import parabankAutomation.steps.MainPageSteps;
import parabankAutomation.steps.RegisterSteps;

public class RegisterTests extends BasePage {

  MainPageSteps mainPageSteps = new MainPageSteps();
  RegisterSteps registerSteps = new RegisterSteps();

  @Test
  public void registerWithDefaultAccount() {
    mainPageSteps.clickOnRegister();
    registerSteps.createDefaultAccountMethod();
    registerSteps.clickOnLogoutButton();
  }

  @Test
  public void doubleRegisterWithAlreadyCreatedAccount() {
    mainPageSteps.clickOnRegister();
    registerSteps.createDoubleDefaultAccountMethod();
  }

  @Test
  public void registerWithRandomAccountRandomUtils() {
    mainPageSteps.clickOnRegister();
    registerSteps.createRandomAccountMethod();
    registerSteps.clickOnLogoutButton();
  }

  @Test
  public void registerWithRandomFakerAccount() {
    mainPageSteps.clickOnRegister();
    registerSteps.createFakerAccountMethod();
    registerSteps.clickOnLogoutButton();
  }

  @Test
  public void registerWithPasswordsMismatchAccount() {
    mainPageSteps.clickOnRegister();
    registerSteps.passwordAndConfirmNotTheSameMethod();
  }
}
