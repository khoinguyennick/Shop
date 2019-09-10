package com.Desert.Repository;

import com.Desert.Entity.Receipt;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReceiptRepoBean implements ReceiptRepo {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public long insertReceipt(Receipt receipt) {
        Session session = sessionFactory.getCurrentSession();
        return (long) session.save(receipt);
    }
}
