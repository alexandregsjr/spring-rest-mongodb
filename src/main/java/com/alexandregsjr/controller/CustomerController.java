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
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerRepository customerRepository;

    @Autowired public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping(path = "/")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @PostMapping(path = "/", headers = "Accept=application/json")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @GetMapping(path = "/{firstName}")
    public List<Customer> getCustomerByFirstName(@PathVariable String firstName) {
        return customerRepository.findByFirstName(firstName);
    }
}
