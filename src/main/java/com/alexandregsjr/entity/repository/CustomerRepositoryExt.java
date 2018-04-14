package com.alexandregsjr.entity.repository;

import com.alexandregsjr.entity.document.Customer;

import javax.management.Query;
import java.util.List;

/**
 * Created by alexandreseverojr on 12/04/18.
 */
public interface CustomerRepositoryExt {


    List<Customer> searchWithCriteria();
}
