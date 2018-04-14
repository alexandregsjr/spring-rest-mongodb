package com.alexandregsjr.entity.repository;

import com.alexandregsjr.entity.document.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;


import java.util.List;

/**
 * Created by alexandreseverojr on 12/04/18.
 */
public class CustomerRepositoryImpl implements CustomerRepositoryExt {

    MongoTemplate mongo;

    @Autowired public CustomerRepositoryImpl(MongoTemplate mongo) {
        this.mongo = mongo;
    }

    @Override public List<Customer> searchWithCriteria() {

        Criteria criteria1 = Criteria.where("firstName").is("Adam");
        Criteria criteria2 = Criteria.where("firstName").is("Sara");

        Query query = new Query(new Criteria().orOperator(criteria1, criteria2));

        return mongo.find(query, Customer.class);
    }
}
