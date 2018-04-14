package com.alexandregsjr.entity.repository;

import com.alexandregsjr.entity.document.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by alexandreseverojr on 08/04/18.
 */
public interface CustomerRepository extends MongoRepository<Customer, String>, CustomerRepositoryExt {

    List<Customer> findByFirstName(String firstName);
    List<Customer> findByLastName(String lastName);

}
