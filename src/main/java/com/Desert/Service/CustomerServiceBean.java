package com.Desert.Service;

import com.Desert.Entity.Customer;
import com.Desert.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerServiceBean implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public long insertCustomer(Customer customer) {
        return customerRepo.insertCustomer(customer);
    }

    @Override
    public Customer getCustomer(long customerID) {
        return customerRepo.getCustomer(customerID);
    }

    @Override
    public List<Customer> getCustomerList() {
        return customerRepo.getCustomerList();
    }
}
