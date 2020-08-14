package com.atanasovcar.service;

import com.atanasovcar.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    void updateCustomer(Customer customer);

    void createCustomer(Customer customer);


    void deleteCustomer(Long id);

    List<Customer> getAllCustomer();

    Customer getCustomerById(Long id);
}