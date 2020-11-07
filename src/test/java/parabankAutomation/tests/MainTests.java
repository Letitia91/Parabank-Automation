package parabankAutomation.tests;

import org.junit.Test;
import parabankAutomation.services.CustomerService;

public class MainTests extends BaseTest {

  @Test
  public void goToCareerPage() {
    System.out.println(CustomerService.getDefaultCostumer().getAddress());
  }
}
