package com.alexandregsjr.controller;

import com.alexandregsjr.entity.document.Customer;
import com.alexandregsjr.entity.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping(path = "/customer/firstName/{firstName}")
    public List<Customer> getCustomerByFirstName(@PathVariable String firstName) {
        return customerRepository.findByFirstName(firstName);
    }

    @GetMapping(path = "/customer/lastName/{lastName}")
    public List<Customer> getCustomerByLastName(@PathVariable String lastName) {
        return customerRepository.findByLastName(lastName);
    }

    @PostMapping(path = "/customer/add")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @RequestMapping(path = "/customer/all")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
