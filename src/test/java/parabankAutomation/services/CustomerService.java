package parabankAutomation.services;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import parabankAutomation.pojos.Customer;

public class CustomerService {
  public static Customer getDefaultCustomer() {
    return Customer.builder() // todo complete all fields FINISH
        .firstNameField("Miruna")
        .lastNameField("Varga")
        .addressField("Iasomiei, 3A")
        .cityField("Sibiu")
        .stateField("Ardeal")
        .zipCodeField("12548")
        .phoneNumberField("65168984")
        .socialNumberField("654897892")
        .userNameField("Miruna")
        .passwordField("LelieDeTort123!")
        .confirmField("LelieDeTort123!")
        .build();
  }

  // todo create a Customer with random data FINISH
  public static Customer getRandomCustomer() {
    final String password = RandomStringUtils.randomNumeric(10);
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
        .passwordField(password)
        .confirmField(password)
        .build();
  }

  public static Customer getFakerCustomer() {
    Faker faker = new Faker();
    final String firstName = faker.name().firstName();
    final String password = faker.gameOfThrones().character();
    return Customer.builder()
        .firstNameField(firstName)
        .lastNameField(faker.name().lastName())
        .addressField(faker.address().streetAddress())
        .cityField(faker.address().cityName())
        .stateField(faker.address().state())
        .zipCodeField(faker.address().zipCode())
        .phoneNumberField(faker.phoneNumber().cellPhone())
        .socialNumberField(faker.phoneNumber().cellPhone())
        .userNameField(firstName)
        .passwordField(password)
        .confirmField(password)
        .build();
  }
}
