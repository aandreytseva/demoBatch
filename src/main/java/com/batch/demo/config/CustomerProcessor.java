package com.batch.demo.config;

import com.batch.demo.entity.Customer;
import com.batch.demo.validator.Validator;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.validator.ValidationException;

public class CustomerProcessor implements ItemProcessor<Customer, Customer> {

    @Override
    public Customer process(Customer customer) throws Exception {
        if (!customer.getCountry().isEmpty()) {
            return customer;
        }
        if (!Validator.isValidEmailAddress(customer.getEmail())) {
            throw new ValidationException("Provided customer email is not valid");
        } else {
            return null;
        }
    }
}
