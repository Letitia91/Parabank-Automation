package parabankAutomation.services;

import org.apache.commons.lang3.RandomStringUtils;
import parabankAutomation.pojos.Customer;

public class CustomerService {
  public static Customer getDefaultCustomer() {
    return Customer.builder() // todo complete all fields FINISH
        .firstNameField("Selena")
        .lastNameField("Leos")
        .addressField("Iasomiei, 3A")
        .cityField("Brasov")
        .stateField("Ardeal")
        .zipCodeField("12548")
        .phoneNumberField("074879555")
        .socialNumberField("541646")
        .userNameField("Selena")
        .passwordField("FelieDeTort123")
        .confirmField("FelieDeTort123")
        .build();
  }

  // todo create a Customer with random data FINISH
  public static Customer getRandomCustomer() {
    return Customer.builder()
        .firstNameField(RandomStringUtils.randomAlphanumeric(5).toUpperCase())
        .lastNameField(RandomStringUtils.randomAlphanumeric(7).toUpperCase())
        .addressField(RandomStringUtils.randomAlphanumeric(10).toUpperCase())
        .cityField(RandomStringUtils.randomAlphabetic(9).toUpperCase())
        .stateField(RandomStringUtils.randomAlphabetic(6).toUpperCase())
        .zipCodeField(RandomStringUtils.randomNumeric(6))
        .phoneNumberField(RandomStringUtils.randomNumeric(9))
        .socialNumberField(RandomStringUtils.randomNumeric(10))
        .userNameField(RandomStringUtils.randomAlphanumeric(5).toUpperCase())
        .passwordField("ASCI1234!!")
        .confirmField("ASCI1234!!")
        .build();
  }
}
