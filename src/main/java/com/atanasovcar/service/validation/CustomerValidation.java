package com.atanasovcar.service.validation;

import com.atanasovcar.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerValidation {
    public void validateCustomer(Customer customer){
        validateCustomerEmail(customer);
        //validateCustomerPhoneNumber(customer);
        validateCustomerFirstName(customer);
        validateCustomerLastName(customer);
    }

    private void validateCustomerFirstName(Customer customer){
        String firstName = customer.getFirstName();
        String patternFirstName = "(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){0,24}$";

        if(!firstName.matches(patternFirstName)){
            throw new RuntimeException("Invalid Customer Name! Name pattern must be (First Name)");
        }
    }

    private void validateCustomerLastName(Customer customer){
        String lastName = customer.getLastName();
        String patternLastName = "(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){0,24}$";

        if(!lastName.matches(patternLastName)){
            throw new RuntimeException("Invalid Customer Last Name! Name pattern must be (Last Name)");
        }
    }
    private void validateCustomerEmail(Customer customer){
        String email = customer.getEmail();
        String patternEmail = "\\b[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,4}\\b";
        if(!email.matches(patternEmail)){
            throw new RuntimeException("Invalid email");
        }
    }
    private void validateCustomerPhoneNumber(Customer customer){
        String phoneNumber = customer.getPhoneNumber();
        String patternNumber = "(\\+)?(359|0)8[3456789]\\d{1}(|-| )\\d{3}(|-| )\\d{3}";

        if(!phoneNumber.matches(patternNumber)){
            throw new RuntimeException("Invalid mobile phone! Mobile phone must be +3598XX XXX XXX," +
                         " +3598XXXXXXXX,+3598XX-XXX-XXX or 08XX XXX XXX, 08XXXXXXXX, 08XX-XXX-XXX ");
        }
    }
}
