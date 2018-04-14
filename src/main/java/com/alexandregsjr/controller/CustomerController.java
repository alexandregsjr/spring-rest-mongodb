package com.alexandregsjr.controller;

import com.alexandregsjr.entity.document.Customer;
import com.alexandregsjr.entity.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by alexandreseverojr on 12/04/18.
 */
@RestController
public class CustomerController {

    private final CustomerRepository customerRepository;

    @Autowired public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @RequestMapping(path = "/customer/firstName/{firstName}", method = RequestMethod.GET)
    public List<Customer> getCustomerByFirstName(@PathVariable String firstName) {
        return customerRepository.findByFirstName(firstName);
    }

    @RequestMapping(path = "/customer/lastName/{lastName}", method = RequestMethod.GET)
    public List<Customer> getCustomerByLastName(@PathVariable String lastName) {
        return customerRepository.findByLastName(lastName);
    }

    @RequestMapping("/customer/all")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}