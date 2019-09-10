package com.Desert.Repository;

import com.Desert.Entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepoBean implements CustomerRepo {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public long insertCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        return (long) session.save(customer);
    }

    @Override
    public Customer getCustomer(long customerID) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Customer.class, customerID);
    }

    @Override
    public List<Customer> getCustomerList() {
        Session session = sessionFactory.getCurrentSession();
        Query<Customer> query =
                session.createQuery("FROM Customer", Customer.class);
        return query.getResultList();
    }
}
