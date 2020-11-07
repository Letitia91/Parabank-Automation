package parabankAutomation.services;

import parabankAutomation.pojos.Customer;

public class CustomerService {
  public static Customer getDefaultCostumer() {
    return Customer.builder()
        .address("adresa") // todo complete all fields
        .build();
  }

  // todo create a Customer with random data
}
