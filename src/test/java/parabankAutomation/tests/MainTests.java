package parabankAutomation.tests;

import static parabankAutomation.pages.MainPage.*;

import org.junit.Test;

public class MainTests extends BaseTest {

  @Test
  public void createDefaultAccount() {
    createDefaultAccountMethod();
  }

  @Test
  public void createDoubleDefaultAccount() {
    createDoubleDefaultAccountMethod();
  }

  @Test
  public void createRandomAccount() {
    createRandomAccountMethod();
  }

  @Test
  public void loginWithCorrectUser() {
    loginWithCorrectUserMethod();
  }

  @Test
  public void loginWithIncorrectUser() {
    loginWithIncorrectUserMethod();
  }

  @Test
  public void passwordsMismatch() {
    passwordAndConfirmNotTheSameMethod();
  }

  @Test
  public void forgotLoginDetails() {
    forgotLoginMethod();
  }
}
