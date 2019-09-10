package com.Desert.Repository;

import com.Desert.Entity.Customer;

import java.util.List;

public interface CustomerRepo {

    long insertCustomer(Customer customer);

    Customer getCustomer(long customerID);

    List<Customer> getCustomerList();
}
