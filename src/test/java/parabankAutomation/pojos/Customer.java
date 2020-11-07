package parabankAutomation.pojos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderClassName = "CustomerBuilder", toBuilder = true)
public class Customer {
  String firstName;
  String lastName;
  String address;
  String city;
  String state;
  String zipCode;
  String phone;
  String ssn;
  String username;
  String password;
}
