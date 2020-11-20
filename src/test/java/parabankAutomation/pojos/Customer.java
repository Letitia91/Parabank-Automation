package parabankAutomation.pojos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderClassName = "CustomerBuilder", toBuilder = true)
public class Customer {
  String firstNameField;
  String lastNameField;
  String addressField;
  String cityField;
  String stateField;
  String zipCodeField;
  String phoneNumberField;
  String socialNumberField;
  String userNameField;
  String passwordField;
  String confirmField;
}
