package com.atanasovcar.service;

import com.atanasovcar.exeption.ResourceNotFoundException;
import com.atanasovcar.model.Customer;
import com.atanasovcar.repository.CustomerRepository;
import com.atanasovcar.service.validation.CustomerValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerValidation customerValidation;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerValidation customerValidation) {
        this.customerRepository = customerRepository;
        this.customerValidation = customerValidation;
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }
    public void createOrUpdateCustomer (Customer customer){
        if(null == customer.getId()){
            validateAndCreateCustomer(customer);
            return;
        }
        updateCustomer(customer);
    }


    @Override
    public void deleteCustomer(Long id) {

    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);

        if(customer.isPresent()){
            return customer.get();
        }
        throw new ResourceNotFoundException("Customer not exist id :" + id);
    }
    public void validateAndCreateCustomer(Customer customer){
        customerValidation.validateCustomer(customer);
        customerRepository.save(customer);
    }
}
