package com.Desert.Service;

import com.Desert.Entity.Customer;

import java.util.List;

public interface CustomerService {

    long insertCustomer(Customer customer);

    Customer getCustomer(long customerID);

    List<Customer> getCustomerList();
}
