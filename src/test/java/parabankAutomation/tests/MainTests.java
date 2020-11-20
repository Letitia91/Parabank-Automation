package parabankAutomation.tests;

import org.testng.annotations.Test;
import parabankAutomation.steps.MainPageSteps;
import parabankAutomation.steps.RegisterSteps;

public class MainTests extends BaseTest {
  MainPageSteps mainPageSteps = new MainPageSteps();
  RegisterSteps registerSteps = new RegisterSteps();

  @Test
  public void loginWithCorrectUser() {
    mainPageSteps.loginWithCorrectUserMethod();
    mainPageSteps.clickOnLoginButton();
    registerSteps.clickOnLogoutButton();
  }

  @Test
  public void loginWithIncorrectUser() {
    mainPageSteps.loginWithIncorrectUserMethod();
  }
}
