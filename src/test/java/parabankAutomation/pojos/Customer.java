package parabankAutomation.pojos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderClassName = "CustomerBuilder", toBuilder = true)
public class Customer {
  public String firstNameField;
  public String lastNameField;
  public String addressField;
  public String cityField;
  public String stateField;
  public String zipCodeField;
  public String phoneNumberField;
  public String socialNumberField;
  public String userNameField;
  public String passwordField;
  public String confirmField;
}
